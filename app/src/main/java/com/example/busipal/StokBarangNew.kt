package com.example.busipal

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import coil.load
import coil.transform.CircleCropTransformation
import com.example.busipal.databinding.ActivityMainBinding
import com.example.busipal.databinding.ActivityStokBarangNewBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_stok_barang_new.*

class StokBarangNew : AppCompatActivity() {
    private lateinit var binding: ActivityStokBarangNewBinding
    private val CAMERA_REQUEST_CODE =1
    private val GALLERY_REQUEST_CODE =2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityStokBarangNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivItem.setOnClickListener{
            val pictureDialog = AlertDialog.Builder(this)
            pictureDialog.setTitle("Select Action")
            val pictureDialogItem = arrayOf("Select Photo from Gallery",
                "Capture Photo from Camera")
            pictureDialog.setItems(pictureDialogItem){dialog, which ->
                when(which) {
                    0 ->  {
                        galleryCheckPermission()
                    }
                    1 -> {
                        cameraCheckPermission()
                    }
                }
            }
            pictureDialog.show()
        }

        btnPlusStokBarang.setOnClickListener {
            var tmp: Int = tvNilaiJumlahProduk.text.toString().toInt()

            tmp += 1
            tvNilaiJumlahProduk.text = tmp.toString()
        }

        btnMinStokBarang.setOnClickListener {
            var tmp: Int = tvNilaiJumlahProduk.text.toString().toInt()

            tmp -= 1
            tvNilaiJumlahProduk.text = tmp.toString()
        }


    }



    private fun galleryCheckPermission(){
        Dexter.withContext(this).withPermission(
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object : PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                gallery()
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText( applicationContext,
                    "You have denied the storage permission to select image",
                    Toast.LENGTH_SHORT).show()

                showRorationalDialogForPermission()
            }

            override fun onPermissionRationaleShouldBeShown(
                p0: PermissionRequest?, p1: PermissionToken?) {
                showRorationalDialogForPermission()
            }

        }).onSameThread().check()
    }
    private fun gallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/"
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }
    private fun cameraCheckPermission(){
        Dexter.withContext(this)
            .withPermissions(android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.CAMERA).withListener(

                object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                        report?.let {

                            if(report.areAllPermissionsGranted()){
                                camera()
                            }
                        }
                    }
                    override fun onPermissionRationaleShouldBeShown(
                        p0: MutableList<PermissionRequest>?,
                        p1: PermissionToken?) {

                        showRorationalDialogForPermission()
                    }
                }
            ).onSameThread().check()
    }

    private fun camera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){

            when(requestCode){
                CAMERA_REQUEST_CODE ->{
                    val bitmap = data?.extras?.get("data") as Bitmap
                    binding.ivItem.load(bitmap){
                        crossfade(true)
                        crossfade(1000)
                        transformations(CircleCropTransformation())
                    }
                }
                GALLERY_REQUEST_CODE ->{
                    binding.ivItem.load(data?.data){
                        crossfade(true)
                        crossfade(1000)
                        transformations(CircleCropTransformation())
                    }
                }
            }
        }
    }

    private fun showRorationalDialogForPermission(){
        AlertDialog.Builder(this)
            .setMessage("It looks like you have turned off permissions"
                    + "It can be enable under App settings!!!")

            .setPositiveButton("GO TO SETTINGS"){_,_->
                try {
                    val intent= Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivity(intent)

                }catch (e: ActivityNotFoundException){
                    e.printStackTrace()
                }
            }
            .setNegativeButton("CANCEL"){dialog,_->
                dialog.dismiss()
            }.show()
    }

    fun CreateBarang(view: View) {
        startActivity(Intent(this,StokBarang::class.java))
    }

    fun btnBack(view: View) {
        startActivity(Intent(this,StokBarang::class.java))
    }
}