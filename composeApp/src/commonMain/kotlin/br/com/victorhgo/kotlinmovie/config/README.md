# Configuração da API

Este diretório contém a estrutura de configuração para gerenciar as constantes da API de forma centralizada e segura.

## Estrutura

### `ApiConfig.kt`
- Classe principal que fornece acesso às configurações da API
- Usa o `ConfigProvider` para obter os valores dinamicamente
- Contém constantes de fallback para desenvolvimento

### `ConfigProvider.kt` (expect)
- Interface comum para diferentes plataformas
- Define os métodos que devem ser implementados em cada plataforma

### Implementações específicas por plataforma:

#### Android (`ConfigProvider.android.kt`)
- Implementação para Android
- Pode usar `BuildConfig` ou variáveis de ambiente
- Atualmente retorna valores hardcoded para desenvolvimento

#### iOS (`ConfigProvider.ios.kt`)
- Implementação para iOS
- Pode usar variáveis de ambiente do iOS
- Atualmente retorna valores hardcoded para desenvolvimento

## Como usar

```kotlin
// Em qualquer lugar do código
val apiKey = ApiConfig.ACCESS_TOKEN
val baseUrl = ApiConfig.BASE_URL
val imageUrl = ApiConfig.IMAGE_BASE_URL
val language = ApiConfig.DEFAULT_LANGUAGE
```

## Configuração para Produção

### Android
1. Adicione as chaves no `build.gradle.kts`:
```kotlin
android {
    buildTypes {
        release {
            buildConfigField("String", "API_KEY", "\"sua_chave_aqui\"")
        }
    }
}
```

2. Atualize o `ConfigProvider.android.kt`:
```kotlin
actual fun getApiKey(): String {
    return BuildConfig.API_KEY
}
```

### iOS
1. Adicione as chaves no `Info.plist` ou use variáveis de ambiente
2. Atualize o `ConfigProvider.ios.kt` para ler essas configurações

## Vantagens desta abordagem

1. **Centralização**: Todas as configurações em um local
2. **Segurança**: Fácil de mover para variáveis de ambiente em produção
3. **Flexibilidade**: Diferentes configurações por plataforma
4. **Manutenibilidade**: Mudanças em um local afetam todo o projeto
5. **Testabilidade**: Fácil de mockar para testes
