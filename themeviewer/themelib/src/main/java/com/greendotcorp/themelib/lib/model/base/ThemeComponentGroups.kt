package com.greendotcorp.core.theme.lib.model.base

import com.google.gson.annotations.SerializedName

data class Header (

        val view : View? = null,
  
        val balanceCarousel: Carousel? = null,
      
        val rightButton : Button? = null,

        val leftButton : Button? = null
)

data class Tile (

        val view: View?,

        val image: String?,

        val profileBackgroundImage: Image?,

        val profileImage: Image?,

        val nameLabel: Label?,

        val levelLabel: Label?,

        val pointsLabel: Label?,

        val titleLabel: Label?,

        val descriptionLabel: Label?,

        val starImage: Image?,

        val disclosureImage : Image?,

        val progressBar : ProgressBar?

)

data class ChallengeTile (

        val view: View?,
        val image: String?,

        val subTitleComposite: Composite?,
        val titleComposite: Composite?,
        val descriptionComposite: Composite?,
        val pointsPill : Bar?,
        val promotionsBar: Bar?,
        val nameComposite: Composite?,
        val levelComposite: Composite?,
        val pointsComposite: Composite?,
        val profileImage: Image?,
        val starImage: Image?,
        val progressBar : ProgressBar?

)

data class Row (
        @SerializedName("view")
        val view : View? = null,
        @SerializedName("informationLabel")
        val informationLabel : Label? = null,
        @SerializedName("initialsLabel")
        val initialsLabel : Label? = null,
        @SerializedName("typeLabel")
        val typeLabel : Label? = null,
        @SerializedName("dateLabel")
        val dateLabel : Label? = null,
        @SerializedName("statusLabel")
        val statusLabel : Label? = null,
        @SerializedName("transactorBackgroundImage")
        val transactorBackgroundImage : Image? = null,
        @SerializedName("creditAmountLabel")
        val creditAmountLabel : Label? = null,
        @SerializedName("pendingAmountLabel")
        val pendingAmountLabel : Label? = null,
        @SerializedName("confirmedAmountLabel")
        val confirmedAmountLabel : Label? = null
)

data class Transaction (
        @SerializedName("view")
        val view: View? = null,
        @SerializedName("topView")
        val topView: View? = null,
        val middleView: View? = null,
        @SerializedName("bottomView")
        val bottomView: View? = null,
        @SerializedName("headerTitle")
        val headerTitle: Title? = null,
        @SerializedName("expandButton")
        val expandButton : Button? = null,
        @SerializedName("noTransactionRow")
        val noTransactionRow : Row? = null,
        @SerializedName("row")
        val row: Row? = null
)

data class Transactors (
        @SerializedName("view")
        val view : View? = null,
        @SerializedName("informationTitle")
        val informationTitle : Title? = null,
        @SerializedName("informationDescription")
        val informationDescription : Description? = null,
        @SerializedName("icon")
        val icon : Icon? = null,
        @SerializedName("background")
        val background : Background? = null,
        @SerializedName("description")
        val description : Description? = null
)

data class Activity (
        @SerializedName("view")
        val view : View? = null,
        @SerializedName("topView")
        val topView: View? = null,
        @SerializedName("bottomView")
        val bottomView: View? = null,
        @SerializedName("headerTitle")
        val headerTitle: Title? = null,
        @SerializedName("expandButton")
        val expandButton: Button? = null,
        @SerializedName("noTransactionRow")
        val noTransactionRow: Row? = null,
        @SerializedName("row")
        val row: Row? = null
)