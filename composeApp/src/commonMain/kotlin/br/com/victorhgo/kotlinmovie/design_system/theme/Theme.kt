package br.com.victorhgo.kotlinmovie.design_system.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import br.com.victorhgo.kotlinmovie.design_system.colors.AppColorScheme
import br.com.victorhgo.kotlinmovie.design_system.text_styles.AppTypography
import br.com.victorhgo.kotlinmovie.design_system.util.AppShapes

@Composable
fun MoviesAppTheme(
    content:@Composable () -> Unit
){
    MaterialTheme(
        colorScheme = AppColorScheme,
        shapes = AppShapes,
        typography = AppTypography()
    ){
        content()
    }
}