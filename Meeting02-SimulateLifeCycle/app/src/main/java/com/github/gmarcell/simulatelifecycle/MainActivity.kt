package com.github.gmarcell.simulatelifecycle

import android.content.Intent
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val Tag="Main Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(Tag,"In Oncreate")
        val about_us = findViewById<Button>(R.id.about_us)
        about_us.setOnClickListener {
            val i = Intent(this,AboutUs::class.java)
            startActivity(i)
        }
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
