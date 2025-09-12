package br.com.victorhgo.kotlinmovie.data.network

import br.com.victorhgo.kotlinmovie.config.ApiConfig
import br.com.victorhgo.kotlinmovie.data.network.model.CreditsListResponse
import br.com.victorhgo.kotlinmovie.data.network.model.MovieResponse
import br.com.victorhgo.kotlinmovie.data.network.model.MoviesListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        accessToken = ApiConfig.ACCESS_TOKEN,
                        refreshToken = ""
                    )
                }
            }
        }
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
    }

    suspend fun getMovies(category: String): MoviesListResponse {
        return client.get("${ApiConfig.BASE_URL}/3/movie/$category") {
            addLanguageParam()
        }.body()
    }

    suspend fun getMovieDetail(movieId: Int): MovieResponse {
        return client.get("${ApiConfig.BASE_URL}/3/movie/$movieId") {
            addLanguageParam()
        }.body()
    }

    suspend fun getCredits(movieId: Int): CreditsListResponse {
        return client.get("${ApiConfig.BASE_URL}/3/movie/$movieId/credits") {
            addLanguageParam()
        }.body()
    }

    private fun HttpRequestBuilder.addLanguageParam(language: String = ApiConfig.DEFAULT_LANGUAGE){
        parameter("language", language)
    }
}