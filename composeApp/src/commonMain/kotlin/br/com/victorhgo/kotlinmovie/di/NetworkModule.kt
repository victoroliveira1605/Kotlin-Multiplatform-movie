package br.com.victorhgo.kotlinmovie.di

import br.com.victorhgo.kotlinmovie.data.network.KtorClient
import br.com.victorhgo.kotlinmovie.data.repository.MoviesRepository
import org.koin.dsl.module

val networkModule = module {
    single { KtorClient() }
    single { MoviesRepository(get(), get()) }
}