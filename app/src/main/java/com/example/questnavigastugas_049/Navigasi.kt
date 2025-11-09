package com.example.questnavigastugas_049

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigastugas_049.view.FormulirScreen
import com.example.questnavigastugas_049.view.ListScreen
import com.example.questnavigastugas_049.view.WelcomeScreen

enum class Screen {
    Welcome,
    List,
    Form
}

@Composable
fun TugasAppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.name
    ) {
        composable(route = Screen.Welcome.name) {
            WelcomeScreen(
                onMasukClick = {
                    navController.navigate(Screen.List.name)
                }
            )
        }
