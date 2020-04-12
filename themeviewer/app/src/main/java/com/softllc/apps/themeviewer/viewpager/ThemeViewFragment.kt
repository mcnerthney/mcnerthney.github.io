package com.softllc.apps.themeviewer.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.softllc.apps.themeviewer.databinding.ThemeViewFragmentBinding


class ThemeViewFragment() : Fragment() {

    private lateinit var binding: ThemeViewFragmentBinding
    private lateinit var viewModel: ThemeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ThemeViewFragmentBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThemeViewModel::class.java)
    }

}

