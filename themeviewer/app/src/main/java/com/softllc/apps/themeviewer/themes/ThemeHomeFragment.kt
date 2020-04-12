package com.softllc.apps.themeviewer.globalstyle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.greendotcorp.core.theme.app.nextTheme
import com.greendotcorp.core.theme.lib.ThemeManagerEx
import com.softllc.apps.themeviewer.databinding.ThemeViewHomeFragmentBinding
import com.softllc.apps.themeviewer.viewpager.ThemeScreenType
import com.softllc.apps.themeviewer.viewpager.ThemeViewModel

class ThemeHomeFragment() : Fragment() {

    private lateinit var binding: ThemeViewHomeFragmentBinding
    private lateinit var viewModel: ThemeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ThemeViewHomeFragmentBinding.inflate(inflater, container, false)

        ThemeManagerEx.current.observe(viewLifecycleOwner, Observer { theme ->
            if (theme != null) {

                binding.homeHeading.text = "${ThemeScreenType.Home.name}"

                binding.theme = theme

            }
        })

        binding.root.setOnClickListener {
            nextTheme(requireContext())
        }
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThemeViewModel::class.java)
    }

}

