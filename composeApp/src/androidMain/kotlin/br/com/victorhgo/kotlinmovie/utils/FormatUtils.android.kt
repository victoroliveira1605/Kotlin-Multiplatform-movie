package br.com.victorhgo.kotlinmovie.utils

import java.util.Locale

actual fun Double.formatRating(): String =
    String.format(Locale.getDefault(), "%.1f", this)