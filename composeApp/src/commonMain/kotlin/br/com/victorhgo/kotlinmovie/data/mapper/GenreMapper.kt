package br.com.victorhgo.kotlinmovie.data.mapper

import br.com.victorhgo.kotlinmovie.data.network.model.GenreResponse
import br.com.victorhgo.kotlinmovie.domain.model.Genre

fun GenreResponse.toModel() = Genre(
    id = this.id,
    name = this.name,
)