package com.github.gmarcell.tryyourluck

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.gmarcell.tryyourluck.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val OnID = 17301516
    val OffID = 17301513
    lateinit var ViewSelect: View
    var IDSelect = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val box: List<Int> = listOf(
            binding.textBox1.id, binding.textBox2.id,
            binding.textBox3.id, binding.textBox4.id,
            binding.textBox5.id, binding.textBox6.id,
            binding.textBox7.id, binding.textBox8.id,
            binding.textBox9.id, binding.textBox10.id,
            binding.textBox11.id, binding.textBox12.id,
            binding.textBox13.id, binding.textBox14.id,
            binding.textBox15.id, binding.textBox16.id
        )
        IDSelect = box[Random.nextInt(0, 16)]
        setListeners()
    }

    private fun setLogic(view: View) {
        if(view.id == IDSelect) {
            setBackground(view, OnID)
            ViewSelect = view
            Toast.makeText(this, "YOU LUCKY!!! Press The Star to Restart", Toast.LENGTH_LONG).show()
            ViewSelect.setOnClickListener {
                reset()
            }
        } else setBackground(view, OffID)
    }

    private fun setBackground(view: View, buttonIcon: Int) {
        view.setBackgroundResource(buttonIcon)
    }

    private fun reset() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val box: List<Int> = listOf(
            binding.textBox1.id, binding.textBox2.id,
            binding.textBox3.id, binding.textBox4.id,
            binding.textBox5.id, binding.textBox6.id,
            binding.textBox7.id, binding.textBox8.id,
            binding.textBox9.id, binding.textBox10.id,
            binding.textBox11.id, binding.textBox12.id,
            binding.textBox13.id, binding.textBox14.id,
            binding.textBox15.id, binding.textBox16.id
        )
        IDSelect = box[Random.nextInt(0, 16)]

        val textBox1 = findViewById<TextView>(R.id.text_box1)
        val textBox2 = findViewById<TextView>(R.id.text_box2)
        val textBox3 = findViewById<TextView>(R.id.text_box3)
        val textBox4 = findViewById<TextView>(R.id.text_box4)
        val textBox5 = findViewById<TextView>(R.id.text_box5)
        val textBox6 = findViewById<TextView>(R.id.text_box6)
        val textBox7 = findViewById<TextView>(R.id.text_box7)
        val textBox8 = findViewById<TextView>(R.id.text_box8)
        val textBox9 = findViewById<TextView>(R.id.text_box9)
        val textBox10 = findViewById<TextView>(R.id.text_box10)
        val textBox11 = findViewById<TextView>(R.id.text_box11)
        val textBox12 = findViewById<TextView>(R.id.text_box12)
        val textBox13 = findViewById<TextView>(R.id.text_box13)
        val textBox14 = findViewById<TextView>(R.id.text_box14)
        val textBox15 = findViewById<TextView>(R.id.text_box15)
        val textBox16 = findViewById<TextView>(R.id.text_box16)

        val clickableViews: List<View> =
            listOf(textBox1, textBox2, textBox3, textBox4, textBox5, textBox6, textBox7, textBox8,
                textBox9, textBox10, textBox11, textBox12, textBox13, textBox14, textBox15, textBox16)

        for (item in clickableViews) {
            item.setOnClickListener {
                setLogic(it)
            }
            item.setBackgroundColor(Color.WHITE)
        }
    }

    private fun setListeners() {
        val textBox1 = findViewById<TextView>(R.id.text_box1)
        val textBox2 = findViewById<TextView>(R.id.text_box2)
        val textBox3 = findViewById<TextView>(R.id.text_box3)
        val textBox4 = findViewById<TextView>(R.id.text_box4)
        val textBox5 = findViewById<TextView>(R.id.text_box5)
        val textBox6 = findViewById<TextView>(R.id.text_box6)
        val textBox7 = findViewById<TextView>(R.id.text_box7)
        val textBox8 = findViewById<TextView>(R.id.text_box8)
        val textBox9 = findViewById<TextView>(R.id.text_box9)
        val textBox10 = findViewById<TextView>(R.id.text_box10)
        val textBox11 = findViewById<TextView>(R.id.text_box11)
        val textBox12 = findViewById<TextView>(R.id.text_box12)
        val textBox13 = findViewById<TextView>(R.id.text_box13)
        val textBox14 = findViewById<TextView>(R.id.text_box14)
        val textBox15 = findViewById<TextView>(R.id.text_box15)
        val textBox16 = findViewById<TextView>(R.id.text_box16)

        val clickableViews: List<View> =
            listOf(textBox1, textBox2, textBox3, textBox4, textBox5, textBox6, textBox7, textBox8,
                textBox9, textBox10, textBox11, textBox12, textBox13, textBox14, textBox15, textBox16)

        for (item in clickableViews) {
            item.setOnClickListener {
                setLogic(it)
            }
        }
    }
}
