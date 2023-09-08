package com.geektech.hw_5_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.hw_5_3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var countTen = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plusOrMinus()
    }

    private fun editText() {


        val bundle = Bundle()
        bundle.putString("tash", binding.etText.text.toString())
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, secondFragment).commit()
    }

    private fun plusOrMinus() {
        var count = binding.tvZero.text.toString().toInt().plus(1)
        binding.btnOne.setOnClickListener {
            when (countTen) {
                false -> {
                    when (count == 10) {
                        false -> {
                            binding.tvZero.text = count++.toString()
                        }
                        true -> {
                            countTen = true
                            binding.tvZero.text = count--.toString()
                            binding.btnOne.text = "-"
                        }
                    }
                }
                true -> {
                    when (count == 0) {
                        false ->
                            binding.tvZero.text = count--.toString()
                        true -> editText()
                    }
                }
            }
        }
    }

}
