package br.com.victorhgo.kotlinmovie.config

object ApiConfig {
    // URLs da API
    val BASE_URL: String get() = ConfigProvider.getBaseUrl()
    val IMAGE_BASE_URL: String get() = ConfigProvider.getImageBaseUrl()
    
    // Token de acesso - agora obtido através do ConfigProvider
    val ACCESS_TOKEN: String get() = ConfigProvider.getApiKey()
    
    // Configurações de idioma
    val DEFAULT_LANGUAGE: String get() = ConfigProvider.getDefaultLanguage()
    
    // Constantes para desenvolvimento (fallback)
    private const val DEV_BASE_URL = "https://api.themoviedb.org"
    private const val DEV_IMAGE_BASE_URL = "https://image.tmdb.org/t/p"
    private const val DEV_ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5Mjk1ZmY2N2NkYjIwYzdiMDY1MGQ4Y2ExM2ExZTU2NCIsIm5iZiI6MTc1NDc0ODQ4MC43MzcsInN1YiI6IjY4OTc1NjQwYTc2OTBhOGUwODZkNjNhMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dWx69wTArEQMKtytsFUvboRP0BqCPL9GYhd8UsDxEJM"
    private const val DEV_DEFAULT_LANGUAGE = "pt-BR"
}
