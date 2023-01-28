package com.example.flowtestapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.flowtestapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val binding by viewBinding(FragmentSecondBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}