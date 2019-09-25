package com.github.gmarcell.myadventure


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.github.gmarcell.myadventure.databinding.FragmentNormalEndingBinding

class NormalEnding : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding:FragmentNormalEndingBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_normal_ending, container, false)
        binding.tryAgainButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_normalEnding_to_gameFragment)
        }
        return binding.root
    }
}
