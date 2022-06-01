package com.example.basicfirebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //guardar datos
        val database = Firebase.database
        val myRef = database.reference

        myRef.child("ejemplo").child("1").setValue(Card("1", "rojo", "corazones"))
        myRef.child("ejemplo").child("2").setValue(Card("2", "rojo", "corazones"))
        myRef.child("ejemplo").child("3").setValue(Card("3", "negro", "picas"))

        //leer datos
        val thirdvalue = myRef.child("ejemplo").child("3").get().addOnSuccessListener { response ->
            //TODO
            Log.i("firebaseResponse", response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }

    //

    }
}