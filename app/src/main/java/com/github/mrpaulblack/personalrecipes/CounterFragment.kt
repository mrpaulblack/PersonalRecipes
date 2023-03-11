package com.github.mrpaulblack.personalrecipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.mrpaulblack.personalrecipes.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {
    private val viewModel by viewModels<CounterViewModel>();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentCounterBinding.inflate(inflater)

        binding.counterButton.setOnClickListener {
            viewModel.onCounterClicked();
        }

        viewModel.counter.observe(viewLifecycleOwner) {
            binding.counterText.text = it.toString();
        }

        return binding.root;
    }
}
