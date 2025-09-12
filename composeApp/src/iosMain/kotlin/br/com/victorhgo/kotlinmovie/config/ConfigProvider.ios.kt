package br.com.victorhgo.kotlinmovie.config

actual object ConfigProvider {
    
    actual fun getApiKey(): String {
        // Em produção, você pode usar variáveis de ambiente do iOS
        // Por enquanto, retorna o valor hardcoded para desenvolvimento
        return "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5Mjk1ZmY2N2NkYjIwYzdiMDY1MGQ4Y2ExM2ExZTU2NCIsIm5iZiI6MTc1NDc0ODQ4MC43MzcsInN1YiI6IjY4OTc1NjQwYTc2OTBhOGUwODZkNjNhMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dWx69wTArEQMKtytsFUvboRP0BqCPL9GYhd8UsDxEJM"
    }
    
    actual fun getBaseUrl(): String = "https://api.themoviedb.org"
    
    actual fun getImageBaseUrl(): String = "https://image.tmdb.org/t/p"
    
    actual fun getDefaultLanguage(): String = "pt-BR"
}
