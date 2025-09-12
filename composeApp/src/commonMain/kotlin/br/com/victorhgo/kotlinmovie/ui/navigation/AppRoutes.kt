package br.com.victorhgo.kotlinmovie.ui.navigation

import kotlinx.serialization.Serializable

sealed interface AppRoutes {
    @Serializable
    data object MoviesList: AppRoutes
    @Serializable
    data class MovieDetail(val id: Int): AppRoutes
}