package br.com.victorhgo.kotlinmovie.di

import br.com.victorhgo.kotlinmovie.ui.screen.moviedetail.MovieDetailViewModel
import br.com.victorhgo.kotlinmovie.ui.screen.movies.MoviesListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module{
    viewModel { MoviesListViewModel(get()) }
    viewModel { MovieDetailViewModel(get(), get()) }
}