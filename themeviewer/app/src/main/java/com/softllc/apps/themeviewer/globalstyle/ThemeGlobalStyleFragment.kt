package com.softllc.apps.themeviewer.globalstyle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.greendotcorp.core.theme.app.nextTheme
import com.greendotcorp.core.theme.lib.ThemeProvider
import com.softllc.apps.themeviewer.databinding.ThemeViewGlobalStyleFragmentBinding
import com.softllc.apps.themeviewer.viewpager.ThemeViewModel

class ThemeGlobalStyleFragment() : Fragment() {

    private lateinit var binding: ThemeViewGlobalStyleFragmentBinding
    private lateinit var viewModel: ThemeViewModel
    private val adapter = ThemeGlobalStyleAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ThemeViewGlobalStyleFragmentBinding.inflate(inflater, container, false)

        binding.fontList.layoutManager = LinearLayoutManager(context)
        binding.fontList.adapter = adapter
        
        ThemeProvider.current.observe(viewLifecycleOwner, Observer { theme ->
            if (theme != null) {
                adapter.update(theme)

                binding.themeHeading.text = theme.id

                binding.theme = theme

            }
        })

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

