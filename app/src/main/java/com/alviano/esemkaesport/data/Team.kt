package com.alviano.esemkaesport.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val name: String,
    val logo: Int,
): Parcelable
