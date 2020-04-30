package com.softllc.apps.themeviewer.globalstyle

import android.graphics.Typeface
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.softllc.apps.themeviewer.databinding.ItemGlobalFontBinding

class ThemeGlobalStyleFontHolder(val binding: ItemGlobalFontBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ThemeGlobalStyleAdapter.ViewItem.ViewGlobalFont) {


        fun View.hideOrShow() {
            //visibility = if ( visibility == View.VISIBLE ) View.INVISIBLE else View.VISIBLE
        }

        val theme = item.theme

        binding.theme = theme

        binding.fontName.text = item.name

        val font = theme.getFont(item.font)
        binding.fontName.typeface = font?.typeface ?: Typeface.DEFAULT
        binding.fontName.textSize = font?.size ?: 12f

        binding.fontDescription.text = item.font.toString()


    }
}