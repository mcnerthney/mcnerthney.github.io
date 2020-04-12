package com.greendotcorp.core.theme.app

import android.animation.Animator
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.textfield.TextInputEditText
import com.greendotcorp.core.theme.lib.ThemeManagerEx

/*
themeManagerEx bindings

 */

@BindingAdapter("t_background")
fun t_background(view: View, style: Any?) {
    val theme = ThemeManagerEx.current.value ?: return

    val themeDrawable = theme.getDrawable(style)
    themeDrawable.let {
        view.background = it?.drawable
    }

    val color = theme.getColor(style)
    color?.let {
        when (view) {
            is CardView -> {
                view.setCardBackgroundColor(it)
            }
            else -> {
                view.setBackgroundColor(it)
            }
        }
    }
}

@BindingAdapter("t_textColorHint")
fun t_textColorHint(view: View, style: Any? ) {

    val theme = ThemeManagerEx.current.value ?: return
    val color = theme.getColor(style)

    color?.let {
        when ( color ) {
            is Int -> { // it's a Color
                when (view) {
                    is TextView -> view.setHintTextColor(color)
                    is AppCompatEditText -> view.setHintTextColor(color)
                    is TextInputEditText -> view.setHintTextColor(color)
                    //is AmountInputField -> view.setHintTextColor(color)
                    is EditText -> view.setHintTextColor(color)
                    else -> {}
                }

            }
            else -> {}
        }
    }
}

@BindingAdapter("t_animation")
fun t_animation(lottie: LottieAnimationView, style: Any?) {
    val theme = ThemeManagerEx.current.value ?: return

    val themeDrawable = theme.getDrawable(style)

    if ( themeDrawable != null && !themeDrawable.animation.isNullOrBlank() ) {
        val asset = themeDrawable.animation
        asset.let {
            lottie.setAnimation(asset)
            lottie.visibility = View.VISIBLE
            val animatorListener = object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) {
                   lottie.visibility = View.VISIBLE
                }
                override fun onAnimationCancel(p0: Animator?) { }
                override fun onAnimationRepeat(p0: Animator?) { }
                override fun onAnimationEnd(animation: Animator?) {
                }
            }
            lottie.addAnimatorListener(animatorListener)
            lottie.playAnimation()
        }
    } else {
        lottie.visibility = View.GONE
    }
}

@BindingAdapter("t_font")
fun t_typeface(view: View, style: Any?) {
    val theme = ThemeManagerEx.current.value ?: return
    val font = theme.getFont(style)

    font?.let {
        if (view is TextView) {
            view.setTypeface(it.typeface)
            view.textSize = it.size
        }
    }
}

@BindingAdapter("t_textColor")
fun t_textcolor(view: View, style: Any?) {
    val theme = ThemeManagerEx.current.value ?: return
    val color = theme.getColor(style)

    color?.let {
        when (view) {
            is TextView -> view.setTextColor(color)
            is AppCompatEditText -> view.setTextColor(color)
           // is GEditTextField -> view.setTextColor(color)
            is TextInputEditText -> view.setTextColor(color)
           // is AmountInputField -> view.setTextColor(color)
            is EditText -> view.setTextColor(color)
           // is GEditDateField -> view.setTextColor(color)
          //  is GEditPercentField -> view.setTextColor(color)
          //  is GEditAmountField -> view.setTextColor(color)
        }
    }

}


@BindingAdapter("t_imageDrawable")
fun t_imageDrawable(view: ImageView, style: Any?) {
    val theme = ThemeManagerEx.current.value ?: return
    val themeDrawable = theme.getDrawable(style)
    when (view) {
        is ImageView -> {
            if ( themeDrawable != null ) {
                view.clipToOutline = true
                view.visibility = View.VISIBLE
                view.setImageDrawable(themeDrawable.drawable)
            }
            else {
                view.visibility = View.GONE
            }
        }
    }

}

@BindingAdapter("t_marginTop")
fun t_marginTop(v: View, topMargin: Any?) {
    val theme = ThemeManagerEx.current.value ?: return
    val dimen = theme.getPixelCount(topMargin)
    dimen?.let {
        val layoutParams = v.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.topMargin = it.toInt()
        v.layoutParams = layoutParams
    }
}

@BindingAdapter("t_marginBottom")
fun t_marginBottom(v: View, bottomMargin: Any?) {
    val theme = ThemeManagerEx.current.value ?: return
    val dimen = theme.getPixelCount(bottomMargin)
    dimen?.let {
        val layoutParams = v.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.bottomMargin = it.toInt()
        v.layoutParams = layoutParams
    }
}

@BindingAdapter("t_marginLeft")
fun t_marginLeft(v: View, leftMargin: Any?) {
    val theme = ThemeManagerEx.current.value ?: return
    val dimen = theme.getPixelCount(leftMargin)
    dimen?.let {
        val layoutParams = v.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.leftMargin = it.toInt()
        v.layoutParams = layoutParams
    }
}

@BindingAdapter("t_marginRight")
fun t_marginRight(v: View, rightMargin: Any?) {
    val theme = ThemeManagerEx.current.value ?: return
    val dimen = theme.getPixelCount(rightMargin)
    dimen?.let {
        val layoutParams = v.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.rightMargin = it.toInt()
        v.layoutParams = layoutParams
    }
}

@BindingAdapter("t_layout_width")
fun setLayoutWidth(v: View, width: Any?) {
    val theme = ThemeManagerEx.current.value ?: return
    val dimen = theme.getPixelCount(width)
    dimen?.let {
        v.layoutParams.width = it.toInt()
        v.requestLayout()
    }
}

@BindingAdapter("t_layout_height")
fun setLayoutHeight(v: View, height: Any?) {
    val theme = ThemeManagerEx.current.value ?: return
    val dimen = theme.getPixelCount(height)
    dimen?.let {
        v.layoutParams.height = it.toInt()
        v.requestLayout()
    }
}

@BindingAdapter("t_layout_marginHorizontal", "view_fullscreen")
fun setMarginBothComputedFullScreen(v: View, leftandRightMargin: Any?, viewFullscreen: Int) {
    val theme = ThemeManagerEx.current.value ?: return
    val dimen = theme.getPixelCount(leftandRightMargin)
    dimen?.let {
        val layoutParams = v.layoutParams as ViewGroup.MarginLayoutParams
        when {
            viewFullscreen == 0 -> {
                // compute left and right margins as equal values to center the image
                layoutParams.leftMargin = it.toInt()
                layoutParams.rightMargin = it.toInt()
                layoutParams.width = v.context.resources.displayMetrics.widthPixels - 2 * it.toInt()
            }
            viewFullscreen == 1 -> {
                // expand image to full screen
                layoutParams.leftMargin = 0
                layoutParams.rightMargin = 0
                layoutParams.width = v.context.resources.displayMetrics.widthPixels
            }
            viewFullscreen == 2 -> // left justify image
                layoutParams.leftMargin = 0
            viewFullscreen < 0 -> {
                // left justify image with right margin = -viewFullscreen
                layoutParams.leftMargin = 0
                layoutParams.width = v.context.resources.displayMetrics.widthPixels + viewFullscreen
            }
            else -> {
                // use viewFullScreen for equal left and right margins, and center the image
                layoutParams.leftMargin = viewFullscreen
                layoutParams.rightMargin = viewFullscreen
                layoutParams.width = v.context.resources.displayMetrics.widthPixels - 2 * viewFullscreen
            }
        }
        v.layoutParams = layoutParams
        v.requestLayout()
    }
}
