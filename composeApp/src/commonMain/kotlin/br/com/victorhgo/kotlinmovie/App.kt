package br.com.victorhgo.kotlinmovie

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.victorhgo.kotlinmovie.design_system.theme.MoviesAppTheme
import br.com.victorhgo.kotlinmovie.di.dataModule
import br.com.victorhgo.kotlinmovie.di.networkModule
import br.com.victorhgo.kotlinmovie.di.viewModelModule
import br.com.victorhgo.kotlinmovie.ui.navigation.AppRoutes
import br.com.victorhgo.kotlinmovie.ui.screen.moviedetail.MovieDetailRoute
import br.com.victorhgo.kotlinmovie.ui.screen.movies.MoviesListRoute
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(
        application = {
            modules(networkModule, dataModule, viewModelModule)
        }
    ){
        MoviesAppTheme {
            val navController = rememberNavController()
            NavHost(navController, startDestination = AppRoutes.MoviesList){
                composable<AppRoutes.MoviesList>{
                    MoviesListRoute(
                        navigateToMovieDetail =  { movieId ->
                            navController.navigate(AppRoutes.MovieDetail(movieId))
                        }
                    )
                }
                composable<AppRoutes.MovieDetail>{
                    MovieDetailRoute(
                        navigationBack = {
                            navController.popBackStack()
                        }
                    )
                }

            }
        }
    }
}