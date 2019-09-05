package com.github.gmarcell.simulatelifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

class AboutUs: AppCompatActivity() {

    val Tag = "About Us"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Log.d(Tag, "Inside Oncreate")
        Toast.makeText(this, "You are under about us", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(Tag,"In Onstart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Tag,"In Onstop")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Tag,"In Onpause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Tag,"In Ondestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(Tag,"In Onrestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(Tag,"In Onresume")
    }
}