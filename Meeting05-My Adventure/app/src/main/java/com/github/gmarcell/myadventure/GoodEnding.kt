package com.github.gmarcell.myadventure


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.github.gmarcell.myadventure.databinding.FragmentGoodEndingBinding

class GoodEnding : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGoodEndingBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_good_ending, container, false)
        binding.tryAgainButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_goodEnding_to_gameFragment)
        }
        return binding.root
    }
}
