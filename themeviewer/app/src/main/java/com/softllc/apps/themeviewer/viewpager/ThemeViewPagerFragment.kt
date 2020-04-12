package com.softllc.apps.themeviewer.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.softllc.apps.themeviewer.databinding.ThemeViewPagerFragmentBinding
import android.util.Log
import androidx.lifecycle.Observer
import com.greendotcorp.core.theme.app.themes.ClassicTheme
import com.greendotcorp.core.theme.lib.ThemeManagerEx
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ThemeViewPagerFragment : Fragment() {

    private lateinit var binding: ThemeViewPagerFragmentBinding
    private lateinit var viewModel: ThemeViewPagerModel

    private lateinit var adapter : ThemeViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        GlobalScope.launch {
           // ThemeManagerEx.setThemes(ClassicTheme(requireContext()))
        }

        adapter = ThemeViewPagerAdapter(parentFragmentManager)

        binding = ThemeViewPagerFragmentBinding.inflate(inflater, container, false)
        binding.themeViewPagerFragmentViewPager.adapter = adapter
        ThemeManagerEx.current.observe(viewLifecycleOwner, Observer { theme ->
            binding.theme = theme
        })

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThemeViewPagerModel::class.java)
    }

}

