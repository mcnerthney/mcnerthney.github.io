package com.softllc.apps.themeviewer.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.greendotcorp.core.theme.lib.ThemeProvider
import com.softllc.apps.themeviewer.databinding.ThemeViewPagerFragmentBinding

class ThemeViewPagerFragment : Fragment() {

    private lateinit var binding: ThemeViewPagerFragmentBinding
    private lateinit var viewModel: ThemeViewPagerModel

    private lateinit var adapter : ThemeViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ThemeViewPagerFragmentBinding.inflate(inflater, container, false)

        adapter = ThemeViewPagerAdapter(parentFragmentManager)
        binding.themeViewPagerFragmentViewPager.adapter = adapter

        ThemeProvider.current.observe(viewLifecycleOwner, Observer { theme ->
            binding.theme = theme
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThemeViewPagerModel::class.java)
    }

}

