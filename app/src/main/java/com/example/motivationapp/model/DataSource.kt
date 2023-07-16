package com.example.daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Motivation(
    val day: Int,
    @StringRes val title: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val description: Int
)