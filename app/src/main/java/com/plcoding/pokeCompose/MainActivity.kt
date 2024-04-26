package com.plcoding.pokeCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.plcoding.pokeCompose.ui.theme.JetpackComposePokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePokedexTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "poke_list"){
                    composable("poke_list"){

                    }
                    composable(
                        "poke_list/{dominant_cr}/{poke_name}",
                                arguments = listOf(
                                navArgument("dominant_cr"){
                                    type= NavType.IntType
                                },
                                navArgument("poke_name"){
                                    type= NavType.StringType
                                }
                            )
                    ){
                        val dominantColor  = remember {
                            val color = it.arguments?.getInt("dominant_cr")
                            color?.let{ Color(it) }?: Color.White
                        }
                        val pokeName = it.arguments?.getString("poke_name")
                    }
                }
                
            }
        }
    }
}
