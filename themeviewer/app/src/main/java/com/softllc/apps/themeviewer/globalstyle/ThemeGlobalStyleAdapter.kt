package com.softllc.apps.themeviewer.globalstyle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greendotcorp.core.theme.lib.Theme
import com.greendotcorp.core.theme.lib.model.base.Fonts
import com.greendotcorp.core.theme.lib.model.base.GlobalFont

import com.softllc.apps.themeviewer.databinding.ItemGlobalFontBinding
import java.lang.reflect.Field


class ThemeGlobalStyleAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    enum class AdapterViewType {
        GLOBAL_FONT,
        GLOBAL_COLOR,
        GLOBAL_DIMEN,
        GLOBAL_COMPOSITE
    }

    sealed class ViewItem(val viewType: AdapterViewType) {
        class ViewGlobalFont(val theme: Theme, val name: String, val font: GlobalFont) :
            ViewItem(
                AdapterViewType.GLOBAL_FONT
            )

//        class ViewSectionFooter(val challengeSectionModel: ChallengesSectionModel) :
//                ViewItem(AdapterViewType.SECTION_FOOTER){}
//
//        class ViewBadgeList(val badges: List<ChallengesItemModel>) :
//                ViewItem(AdapterViewType.BADGE_LIST) {}
//
//        class ViewChallengeDetail(val challengeModel: ChallengesItemModel) :
//                ViewItem(AdapterViewType.CHALLENGE_DETAIL) {}

    }

    private val viewItems = ArrayList<ViewItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            //AdapterViewType.GLOBAL_FONT.ordinal -> {
            else -> {
                val binding = ItemGlobalFontBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ThemeGlobalStyleFontHolder(
                    binding
                )
            }
//            AdapterViewType.SECTION_FOOTER.ordinal -> {
//                val binding =  ItemChallengesSectionFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return ChallengesSectionFooterHolder(binding)
//            }
//            AdapterViewType.BADGE_LIST.ordinal -> {
//                val binding =  ItemChallengesAchievementListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return ChallengesBadgeListHolder(binding, onBadgeClick)
//            }
//            else -> { //ChallengesMainAdapter.viewType.CHALLENGE_DETAIL.ordinal,
//                val binding =  ItemChallengeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                return ChallengesCardHolder(binding)
//            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = viewItems[position]) {
            is ViewItem.ViewGlobalFont -> {
                if (holder is ThemeGlobalStyleFontHolder) {
                    //Log.d("djm", "ThemeGlobalStyleAdapter.onBindViewHolder ${item.theme.id}")

                    holder.bind(item)
                }
            }
//            is ViewItem.ViewSectionFooter -> {
//                if ( holder is ChallengesSectionFooterHolder) {
//                    holder.bind(item)
//                }
//            }
//            is ViewItem.ViewBadgeList -> {
//                if ( holder is ChallengesBadgeListHolder ) {
//                    holder.bind(item)
//                }
//            }
//            is ViewItem.ViewChallengeDetail -> {
//                if ( holder is ChallengesCardHolder ) {
//                    holder.bind(item)
//                }
//            }
        }
    }


    override fun getItemCount(): Int {
        //Log.d("djm", "ThemeGlobalStyleAdapter.getItemCount ${viewItems.size}")

        return viewItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return viewItems[position].viewType.ordinal
    }

    fun update(theme: Theme?) {

        viewItems.clear()

        theme?.globalStyle?.let { style->
            style.font?.let { fonts ->
                val ftClass: Class<*> = Fonts::class.java

                val fields: Array<Field> = ftClass.declaredFields
                fields.forEach { field ->

                    val value = fonts::class.java.getDeclaredField(field.name)
                    value.isAccessible = true
                    val data = value.get(fonts)
                    if ( data is GlobalFont) {
                        viewItems.add(
                            ViewItem.ViewGlobalFont(
                                theme,
                                field.name,
                                data
                            )
                        )
                    }
                }
            }
        }
        notifyDataSetChanged()
    }
}


