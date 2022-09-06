package com.example.busipal

import android.content.BroadcastReceiver
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.busipal.R.*
import com.example.busipal.R.layout.*
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_service.*
import org.w3c.dom.Text

private val AdRequest.Builder.addTestDevice: AdRequest
    get() {
        return this.build()
    }
var userList: MutableList<String> = mutableListOf<String>()
var passList: MutableList<String> = mutableListOf<String>()

class MainActivity : AppCompatActivity() {

    private var mInterstitialAd: InterstitialAd? = null
    lateinit var mAdView: AdView
    private var MyReceiver: BroadcastReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        MyReceiver = MyReceiver()
        broadcastIntent()



        loadBanner()
        loadInterAd()

    }

    private fun loadInterAd() {
        var adRequest = AdRequest.Builder().build()


        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest , object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(TAG, adError!!.toString())
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(TAG, "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })

        mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
            override fun onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.")
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                Log.d(TAG, "Ad dismissed fullscreen content.")
                mInterstitialAd = null
            }

            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                // Called when ad fails to show.
                Log.e(TAG, "Ad failed to show fullscreen content.")
                mInterstitialAd = null
            }

            override fun onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(TAG, "Ad recorded an impression.")
            }

            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad showed fullscreen content.")
            }
        }

        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.")
        }
    }

    private fun loadBanner() {
        MobileAds.initialize(this){}

        mAdView = findViewById(R.id.adView)
        val adReq = AdRequest.Builder()
            .addTestDevice

        mAdView.loadAd(adReq)

        adView.adListener = object: AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                Toast.makeText(this@MainActivity, "Ad Loaded", Toast.LENGTH_SHORT).show()
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        }

    }

    fun broadcastIntent() {
        registerReceiver(MyReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(MyReceiver)
    }

    fun btnLogin(view: View){
        val homeScreenDisplay = Intent(this,Navbar::class.java)
        val builder:AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Something is going wrong... ")
            .setPositiveButton("OK", DialogInterface.OnClickListener{dialog,which ->dialog.dismiss()})

        validation(etUsername,etPw,builder,homeScreenDisplay)

    }

    private fun validation(username: EditText, password: EditText, builder: AlertDialog.Builder, homeScreenDisplay: Intent) {
        if(userList.size != 0 && username.text.toString() != "admin"){
            for (i in 0..userList.size-1){
                if(userList[i] == etUsername.text.toString()){
                    if(passList[i] == etPw.text.toString()){
                        startActivity(homeScreenDisplay)
                    }else{
                        if(i == userList.size-1){
                            builder.setMessage("Wrong Username")
                            builder.show()
                        }
                        continue
                    }
                }else{
                    if(i == userList.size-1){
                        builder.setMessage("Wrong Username")
                        builder.show()
                    }
                    continue
                }
            }
        }else if(username.getText().toString() == "" ){
            builder.setMessage("Username could not be Null")
            builder.show()
        }else if(password.getText().toString() == "" ){
            builder.setMessage("Password could not be Null")
            builder.show()
        }else if(username.getText().toString() != "admin" && password.getText().toString() != "admin" ){
            builder.setMessage("Wrong Username and Password")
            builder.show()
        }else if(username.getText().toString() != "admin" && password.getText().toString() == "admin" ){
            builder.setMessage("Wrong Username")
            builder.show()
        }else if(username.getText().toString() == "admin" && password.getText().toString() != "admin" ){
            builder.setMessage("Wrong Password")
            builder.show()
        }else if(username.getText().toString() == "admin" && password.getText().toString() == "admin" ){
            startActivity(homeScreenDisplay)
            startService(Intent(this,MyService::class.java))
        }else{
            builder.show()
        }
    }

    fun btnDont(view: View){
        val registrationPage = Intent(this,RegistrationPage::class.java)
        startActivity(registrationPage)
    }
}

