package br.com.victorhgo.kotlinmovie.di

import br.com.victorhgo.kotlinmovie.data.repository.MoviesRepository
import org.koin.dsl.module

val dataModule = module{
    factory { MoviesRepository(get()) }
}