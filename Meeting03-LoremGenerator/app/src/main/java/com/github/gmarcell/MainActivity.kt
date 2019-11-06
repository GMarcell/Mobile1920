package com.github.gmarcell

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.github.gmarcell.databinding.ActivityMainBinding
import com.github.gmarcell.R.layout.activity_main as activity_main1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val DefLoremIpsum: MyData = MyData("DefLoremIpsum", "Lorem Ipsum is simply " +
            "dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's " +
            "standard dummy text ever since the 1500s, when an unknown printer took a galley of type " +
            "and scrambled it to make a type specimen book. It has survived not only five centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged. It was " +
            "popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
            "and more recently with desktop publishing software like Aldus PageMaker including versions " +
            "of Lorem Ipsum.")

    private val LoremIpsumComeFrom: MyData = MyData("LoremIpsumComeFrom", "Contrary to" +
            " popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical " +
            "Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin " +
            "professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin " +
            "words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word " +
            "in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections " +
            "1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil)" +
            " by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very " +
            "popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit " +
            "amet..\", comes from a line in section 1.10.32.\n" +
            "\n" +
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those " +
            "interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero " +
            "are also reproduced in their exact original form, accompanied by English versions from " +
            "the 1914 translation by H. Rackham.")

    private val LoremIpsumSource: MyData = MyData("LoremIpsumSource", "There are many " +
            "variations of passages of Lorem Ipsum available, but the majority have suffered alteration " +
            "in some form, by injected humour, or randomised words which don't look even slightly " +
            "believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there" +
            " isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators" +
            " on the Internet tend to repeat predefined chunks as necessary, making this the first " +
            "true generator on the Internet. It uses a dictionary of over 200 Latin words, combined " +
            "with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable." +
            " The generated Lorem Ipsum is therefore always free from repetition, injected humour, " +
            "or non-characteristic words etc.")

    private val LoremIpsumUse: MyData = MyData("LoremIpsumUse", "It is a long established" +
            " fact that a reader will be distracted by the readable content of a page when looking " +
            "at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal " +
            "distribution of letters, as opposed to using 'Content here, content here', making it " +
            "look like readable English. Many desktop publishing packages and web page editors now " +
            "use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover" +
            " many web sites still in their infancy. Various versions have evolved over the years, " +
            "sometimes by accident, sometimes on purpose (injected humour and the like).")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, activity_main1)
        binding.defLoremIpsum = DefLoremIpsum
        binding.loremIpsumComeFrom = LoremIpsumComeFrom
        binding.loremIpsumSource = LoremIpsumSource
        binding.loremIpsumUse = LoremIpsumUse

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.lorem_Info, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.loremType.adapter = adapter

        binding.loremType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val currentType: String = binding.loremType.getItemAtPosition(position).toString()
                when (currentType) {
                    "What is Lorem Ipsum?" -> {
                        binding.titleText.text = DefLoremIpsum.type
                        binding.loremText.text = DefLoremIpsum.content
                    }
                    "Where does it come from?" -> {
                        binding.titleText.text = LoremIpsumComeFrom.type
                        binding.loremText.text = LoremIpsumComeFrom.content
                    }
                    "Where can I get some?" -> {
                        binding.titleText.text = LoremIpsumSource.type
                        binding.loremText.text = LoremIpsumSource.content
                    }
                    "Why do we use it?" -> {
                        binding.titleText.text = LoremIpsumUse.type
                        binding.loremText.text = LoremIpsumUse.content
                    }
                }
            }
        }
    }
}
