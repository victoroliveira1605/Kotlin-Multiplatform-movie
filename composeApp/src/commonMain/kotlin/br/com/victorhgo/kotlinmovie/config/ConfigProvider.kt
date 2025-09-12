package br.com.victorhgo.kotlinmovie.config

/**
 * Provedor de configuração que pode ser estendido para diferentes ambientes
 * e fontes de configuração (variáveis de ambiente, arquivos de configuração, etc.)
 */
expect object ConfigProvider {
    fun getApiKey(): String
    fun getBaseUrl(): String
    fun getImageBaseUrl(): String
    fun getDefaultLanguage(): String
}
