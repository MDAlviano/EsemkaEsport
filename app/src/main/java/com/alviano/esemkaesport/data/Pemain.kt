package com.alviano.esemkaesport.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pemain(
    val nama: String,
    val role: String,
    val foto: Int
): Parcelable
