package br.com.victorhgo.kotlinmovie.data.mapper

import br.com.victorhgo.kotlinmovie.config.ApiConfig
import br.com.victorhgo.kotlinmovie.data.network.model.CastMemberResponse
import br.com.victorhgo.kotlinmovie.domain.model.CastMember
import br.com.victorhgo.kotlinmovie.domain.model.ImageSize

fun CastMemberResponse.toModel() = CastMember(
    id = this.id,
    mainRole = this.department,
    name = this.name,
    character = this.character,
    profileUrl = "${ApiConfig.IMAGE_BASE_URL}/${ImageSize.X_SMALL.size}/${this.profilePath}",
)