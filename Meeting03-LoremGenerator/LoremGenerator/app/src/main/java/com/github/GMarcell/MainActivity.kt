package com.github.GMarcell

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.github.GMarcell.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myData : MyData = MyData("Created By Sandro Tampan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myData = myData
        binding.creatorButton.setOnClickListener {
            pickCreatorName(it)
        }
        binding.creatorText.setOnClickListener {
            changeCreatorName(it)
        }
    }
     private fun pickCreatorName(view: View){
         // assign views

         binding.apply {
             myData?.creator=creatorFill.text.toString()
             invalidateAll()
             creatorText.text = creatorFill.text.toString()
             creatorFill.visibility=View.GONE
             creatorButton.visibility=View.GONE
             creatorText.visibility=View.GONE
         }

         val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
         imn.hideSoftInputFromWindow(view.windowToken,0)
     }

    private fun changeCreatorName(view: View){
        //assign view
        binding.apply {
            creatorFill.visibility=View.GONE
            creatorButton.visibility=View.GONE
            creatorText.visibility=View.GONE
            creatorFill.requestFocus()
        }

        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.showSoftInput(binding.creatorFill, 0)
    }
}
