package com.github.gmarcell.myadventure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.github.gmarcell.myadventure.databinding.FragmentEndingsBinding
/**
 * A simple [Fragment] subclass.
 */
class EndingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingsBinding>(inflater,
            R.layout.fragment_endings, container, false)

        // Ending Buttons Listeners...
        binding.badEndingOneButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[2]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingTwoButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[9]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingThreeButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[10]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingFourButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[11]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingFiveButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[15]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingSixButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[16]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.normalEndingButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[8]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.goodEndingButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[14]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }

        // Enabling/disabling buttons
        if (MyApplication.badEnding1) binding.badEndingOneButton.isEnabled = true
        if (MyApplication.badEnding2) binding.badEndingTwoButton.isEnabled = true
        if (MyApplication.badEnding3) binding.badEndingThreeButton.isEnabled = true
        if (MyApplication.badEnding4) binding.badEndingFourButton.isEnabled = true
        if (MyApplication.badEnding5) binding.badEndingFiveButton.isEnabled = true
        if (MyApplication.badEnding6) binding.badEndingSixButton.isEnabled = true
        if (MyApplication.normalEnding) binding.normalEndingButton.isEnabled = true
        if (MyApplication.goodEnding) binding.goodEndingButton.isEnabled = true

        return binding.root
    }
}
