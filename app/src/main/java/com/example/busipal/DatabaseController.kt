package com.example.busipal

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DatabaseController(activityContext: Context) {

    private lateinit var ref : DatabaseReference;
    private var context = activityContext;

    fun saveUser(username: String, email: String, password: String){
        ref = FirebaseDatabase.getInstance().getReference("USER")

        val userID = ref.push().key.toString()
        val userData = User(username,email, password)

        ref.child(userID).setValue(userData).apply {
            addOnCompleteListener {
                Toast.makeText(context, "Data Tersimpan", Toast.LENGTH_SHORT).show()
            }
            addOnFailureListener {
                Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}