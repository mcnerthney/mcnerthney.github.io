package com.greendotcorp.core.theme.lib.model.base

data class View (
        val content: String? = null,
        val drawable: String? = null,
        val widthByHeight: Double? = null,
        val top: Double? = null,
        val bottom: Double? = null,
        val leading: Double? = null,
        val trailing: Double? = null,
        val shadow: Shadow? = null,
        val height: Double? = null,
        val width: Double? = null,
        val rowItemCount: Int? = null,
        val interItemSpaceX: Double? = null,
        val interItemSpaceY: Double? = null
)

data class Shadow(
        val radius: Double? = null,
        val color: String? = null,
        val opacity: Double? = null,
        val height: Double? = null
)

data class Carousel(
        val view: View? = null,
        val titleLabel: Label? = null,
        val descriptionLabel: Label? = null
)

data class Label(
        val composite: Composite? = null,
        val bottom: Double? = null,
        val content: String? = null,
        val leading: Double? = null,
        val trailing: Double? = null,
        val top: Double? = null
)

data class Button(
        val top: Double? = null,
        val width: Double? = null,
        val trailing: Double? = null,
        val leading: Double? = null,
        val composite: Composite? = null,
        val content: String? = null,
        val lock: String? = null,
        val unlock: String? = null
)

data class Composite(
        val font: Any? = null,
        val color: String? = null
)


data class Image(
        val content: String? = null,
        val leading: Double? = null,
        val width: Double? = null,
        val trailing: Double? = null,
        val height: Double? = null,
        val shadow: Shadow? = null,
        val widthByHeight: Double? = null,
        val top: Double? = null,
        val bottom: Double? = null
)

data class Title(
        val leading: Double? = null,
        val content: String? = null,
        val composite: Composite? = null,
        val bottom: Double? = null
)

data class Grid(
        val view: View? = null,
        val items: List<GridItem>? = null
)

data class GridItem(
        val view: View? = null,
        val iconImage: Image? = null,
        val titleLabel: Label? = null,
        val backgroundImage: Image? = null
)

data class Footer(
        val top: Double? = null,
        val bottom: Double? = null,
        val leading: Double? = null,
        val trailing: Double? = null,
        val widthByHeight: Double? = null,
        val content: String? = null,
        val shadow: Shadow? = null
)

data class Description(
        val content: String? = null,
        val composite: Composite? = null,
        val height: Double? = null
)

data class Icon(
        val content: String? = null,
        val composite: Composite? = null
)

data class Background(
        val width: Double? = null,
        val content: String? = null
)

data class Table(
        val view: View? = null,
        val settings: List<TableSettings>? = null
)

data class RewardsTable(
        val view: View? = null,
        val headerTitle: Description? = null,
        val headerDescription: Description? = null,
        val rowTitle: Description? = null,
        val rowDescription: Description? = null,
        val rowImage: View? = null,
        val percentageTitle: Description? = null,
        val smallPercentageTitle: Description? = null,
        val amountTitle: Description? = null
)

data class SearchTable(
        val view: View? = null,
        val headerTitle: Description? = null,
        val rowTitle: Description? = null
)

data class SearchBar(
        val view: View? = null,
        val iconImage: Image? = null,
        val searchTextField: SearchTextField? = null,
        val searchPlaceholder: SearchPlaceholder? = null,

        val searchClearIcon: SearchClearIcon? = null
)

data class SearchTextField(
        val composite: Composite? = null
)

data class SearchPlaceholder(
        val content: String? = null,
        val composite: Composite? = null
)

data class SearchClearIcon(

        val content: String? = null,

        val height: Double? = null
)

data class TableSettings(
        val view: View? = null,
        val iconBackgroundImage: Image? = null,
        val iconImage: Image? = null,
        val titleLabel: Label? = null,
        val descriptionLabel: Label? = null,
        val disclosureImage: Image? = null
)

data class Tabs(
        val title: String? = null,
        val iconWidthRatio: Double? = null,
        val iconWidthRatioSelected: Double? = null,
        val composite: Composite? = null,
        val compositeSelected: Composite? = null,
        val icon: String? = null,
        val iconSelected: String? = null,
        val background: String? = null,
        val backgroundSelected: String? = null
)

data class ProgressBar(
        val backgroundColor: String? = null,
        val progressColor: String? = null,
        val borderColor: String? = null,
        val leftComposite: Composite? = null,
        val rightComposte: Composite? = null,
        val centerComposite: Composite? = null,
        val trailingText: GlobalFont? = null // font
)

data class Bar(
        val color: String?,
        val composite: Composite?
)















