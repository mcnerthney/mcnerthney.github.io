package com.softllc.apps.themeviewer.globalstyle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.greendotcorp.core.theme.app.nextTheme
import com.greendotcorp.core.theme.lib.ThemeProvider

import com.softllc.apps.themeviewer.databinding.ThemeViewChallengesFragmentBinding
import com.softllc.apps.themeviewer.viewpager.ThemeScreenType
import com.softllc.apps.themeviewer.viewpager.ThemeViewModel

class ThemeChallengesFragment() : Fragment() {

    private lateinit var binding: ThemeViewChallengesFragmentBinding
    private lateinit var viewModel: ThemeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ThemeViewChallengesFragmentBinding.inflate(inflater, container, false)
        binding.challengesHeading.text = "${ThemeScreenType.Challenges.name}"

        ThemeProvider.current.observe(viewLifecycleOwner, Observer { binding.theme = it })
        binding.root.setOnClickListener {
            nextTheme(this.requireContext())
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThemeViewModel::class.java)
    }

}

