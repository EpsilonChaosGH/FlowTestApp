package com.example.flowtestapp.app.screens.second

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.flowtestapp.R
import com.example.flowtestapp.app.screens.first.FirstViewModel
import com.example.flowtestapp.databinding.FragmentFirstBinding
import com.example.flowtestapp.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment(R.layout.fragment_second) {

    private val binding by viewBinding(FragmentSecondBinding::bind)

    private val viewModel by viewModels<SecondViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            viewModel.getRandomNumber()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { number ->
                binding.textView.text = number.toString()
            }
        }
    }
}