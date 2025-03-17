package com.example.bt2_tuan3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.bt2_tuan3.ui.theme.BT2_tuan3Theme
import kotlinx.coroutines.delay
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BT2_tuan3Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {
                        SpLashScreen(navController = navController)
                    }
                    composable("Started_First") {
                        Started_First(
                            onNavigate = { navController.navigate("Started_Second") } // Điều hướng khi nhấn nút "Next"
                        )
                    }
                    composable("Started_Second") {
                        Started_Second(
                            onNavigate = { navController.navigate("Started_Third") }, // Điều hướng khi nhấn nút "Next"onNavigate = { navController.navigate("Started_Third") } // Điều hướng khi nhấn nút "Next"
                            navController = navController
                        )
                    }
                    composable("Started_Third") {
                        Started_Third(
                            onNavigate = { navController.navigate("splash") },
                            navController = navController
                        )
                    }

                }
            }
        }
    }
}
val MauChu_UTH = Color(0xFF006EE9)
val Mau_button1 = Color(0xFF2196F3)


//Chuyen doi giua cac man hinh
//@Composable
//fun ChangeScreen(){
//    SpLashScreen(navController:NavController)
//}
//UI_1
@Composable
fun SpLashScreen(navController:NavController){
    LaunchedEffect(true) {
        delay(1500)
        navController.navigate("Started_First")
    }
    Column(modifier = Modifier
        .fillMaxSize()

    ) {

            Image(
                painter = painterResource(R.drawable.image_1),
                contentDescription = "UTH",

                modifier = Modifier

                    .padding(start = 136.dp, top = 316.dp)
                    .size(width = 103.dp, height = 70.dp)
            )

            //top 90
            //start 70
            Text(text = "UTH SmartTasks", fontSize = 30.sp, color = MauChu_UTH,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 70.dp, top = 30.dp)




            )


    }
}

//UI_2
@Composable
fun Started_First(onNavigate: () -> Unit){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(){
            Image(painter = painterResource(R.drawable.ellipsis), contentDescription ="ellipsis",
                modifier = Modifier
                    .padding(start = 15.dp, top = 69.dp)
                    .size(width = 42.dp, height = 10.dp)

                )

            Text(text ="skip", fontSize = 20.sp, fontWeight = FontWeight.W500,color = MauChu_UTH,
                modifier =Modifier
                    .padding(start = 279.dp, top = 65.dp)



            )
        }
        Image(painter = painterResource(R.drawable.image_2), contentDescription = "mainimage",
            modifier = Modifier
                .padding(start = 28.dp,top = 184.dp)
                .size(width = 318.dp, height = 410.dp)
                


        )
        Button(onClick = {onNavigate()}, colors = ButtonDefaults.buttonColors(Mau_button1),
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 348.dp, height = 90.dp)
                .padding( top = 40.dp)
                .padding(horizontal = 20.dp)

        ) {
            Text(text = "Next", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 30.sp,


                )
        }
    }
}

//UI_3
@Composable
fun Started_Second(onNavigate: () -> Unit,navController: NavController){
    Column (modifier = Modifier.fillMaxSize()){
        Row {
                Image(painter = painterResource(R.drawable.ellipsis_1), contentDescription ="ellipsis",
                    modifier = Modifier
                        .padding(start = 15.dp, top = 69.dp)
                        .size(width = 42.dp, height = 10.dp)

                )

                Text(text ="skip", fontSize = 20.sp, fontWeight = FontWeight.W500,color = MauChu_UTH,
                    modifier =Modifier
                        .padding(start = 279.dp, top = 65.dp)



                )
        }
        Image(painter = painterResource(R.drawable.image_3), contentDescription = "mainimage",
            modifier = Modifier

                .padding(start = 28.dp,top = 184.dp)
                .size(width = 318.dp, height = 410.dp)



        )
        Row(){
            Image(painter = painterResource(R.drawable.button_left), contentDescription = "left_arrows"
                , modifier = Modifier
                    .clickable { navController.popBackStack() }
                    .padding(start = 21.dp,top = 40.dp)
                    .size(width = 53.dp, height = 53.dp)

            )

            Button(onClick = {onNavigate()}, colors = ButtonDefaults.buttonColors(Mau_button1),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 348.dp, height = 90.dp)
                    .padding( top = 40.dp)
                    .padding(horizontal = 20.dp)

            ) {
                Text(text = "Next", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 30.sp,


                    )
            }
        }

    }
}

//UI_4
@Composable
fun Started_Third(onNavigate: () -> Unit,navController: NavController){
    Column (modifier = Modifier.fillMaxSize()){
        Row {
            Image(painter = painterResource(R.drawable.ellipsis_2), contentDescription ="ellipsis",
                modifier = Modifier
                    .padding(start = 15.dp, top = 69.dp)
                    .size(width = 42.dp, height = 10.dp)

            )

            Text(text ="skip", fontSize = 20.sp, fontWeight = FontWeight.W500,color = MauChu_UTH,
                modifier =Modifier
                    .padding(start = 279.dp, top = 65.dp)



            )
        }
        Image(painter = painterResource(R.drawable.image_4), contentDescription = "mainimage",
            modifier = Modifier
                .padding(start = 28.dp,top = 184.dp)
                .size(width = 318.dp, height = 410.dp)



        )
        Row(){
            Image(painter = painterResource(R.drawable.button_left), contentDescription = "left_arrows"
                , modifier = Modifier
                    .clickable { navController.popBackStack() }
                    .padding(start = 21.dp,top = 40.dp)
                    .size(width = 53.dp, height = 53.dp)

            )

            Button(onClick = {onNavigate()}, colors = ButtonDefaults.buttonColors(Mau_button1),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 348.dp, height = 90.dp)
                    .padding( top = 40.dp)
                    .padding(horizontal = 20.dp)

            ) {
                Text(text = "Get Started", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 30.sp,


                    )
            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BT2_tuan3Theme {
        SpLashScreen(navController = rememberNavController())
    }
}
