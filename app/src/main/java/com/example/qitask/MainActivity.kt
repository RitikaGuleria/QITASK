package com.example.qitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qitask.login.HomeScreen
import com.example.qitask.login.LoginScreen
import com.example.qitask.login.RegisterationScreen
import com.example.qitask.ui.theme.QITASKTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

//    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        auth = Firebase.auth

        setContent {
            QITASKTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                        AllNavigation()
                }
            }
        }
    }
}
@Composable
private fun AllNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "login")
    {
        composable(route="login"){
            LoginScreen(navHostController = navController)
        }
        composable(route="register"){
            RegisterationScreen(navHostController = navController)
        }
        composable(route="homescreen"){
            HomeScreen()
        }
    }

}
