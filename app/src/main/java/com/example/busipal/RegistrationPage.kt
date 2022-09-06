package com.example.busipal

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_registration_page.*

class RegistrationPage : AppCompatActivity() {


    lateinit var controller: DatabaseController;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)

        controller = DatabaseController(this)

    }

    fun btnDont(view: View){
        val MainActivity = Intent(this,MainActivity::class.java)
        startActivity(MainActivity)
    }

    fun btnRegister(view: View){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Something is going wrong... ")
            .setPositiveButton("OK", DialogInterface.OnClickListener{ dialog, which ->dialog.dismiss()})

        if (etPassword.text.toString() != etRetype.text.toString() && etPassword.text.toString() != ""){
            builder.setMessage("Password Did'nt Match")
            builder.show()
        }else if(etUsername.text.toString() == ""){
            builder.setMessage("Username is empty!")
            builder.show()
        }else if(etPassword.text.toString() == ""){
            builder.setMessage("Password is empty!")
            builder.show()
        }else if(etEmail.text.toString() == ""){
            builder.setMessage("Email is empty!")
            builder.show()
        }else{

            saveUser()

            builder.setTitle("Congratulation")
                .setPositiveButton("OK", DialogInterface.OnClickListener{ dialog, which -> startActivity(Intent(this,HomeScreen::class.java))})
            builder.setMessage("account succesfully added!")
            builder.show()
            userList.add(etUsername.text.toString())
            passList.add(etPassword.text.toString())
            etUsername.text.clear()
            etEmail.text.clear()
            etPassword.text.clear()
            etRetype.text.clear()


        }

    }

    private fun saveUser() {
        controller.saveUser(etUsername.text.toString(),
        etEmail.text.toString(),
        etPassword.text.toString())
    }
}