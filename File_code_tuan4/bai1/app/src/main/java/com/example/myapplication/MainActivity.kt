package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime .Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                AllScreen()
                }
            }
        }
    }

val mautrongbutton = Color(0xFF2196F3)
val mauButton = Color(0xFF2196F3) // Alpha: 1A, Màu: 2196F3 (Xanh)
val mauChu = Color(0xFF2196F3)

@Composable
fun AllScreen(){
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = "ScreenRoot") {
        composable("ScreenRoot"){
            RootScreen(navController=navController)
        }
        composable("List_lazy"){
            List_lazy(navController=navController)
        }
        composable("Detail"){
            Detail(navController=navController)
        }
    }
}


    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        MyApplicationTheme {
            AllScreen()
        }

    }