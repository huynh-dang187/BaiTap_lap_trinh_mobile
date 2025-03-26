package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.w3c.dom.Text

@Composable
fun RootScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()){
        Row (modifier =Modifier.fillMaxWidth()){
            Image(
                painter = painterResource(R.drawable.image_1),
                contentDescription = "Anh1",
                modifier = Modifier
                    .padding(start = 100.dp, top = 159.dp)
                    .width(216.dp)
                    .height(233.dp)
            )
        }
        Row(modifier =Modifier.fillMaxWidth(),    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.nav_56),

                contentDescription = "Anh2",
                modifier = Modifier

                    .padding(start = 15.dp, top = 20.dp)
                    .width(339.dp)
                    .height(126.dp)


            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {navController.navigate("List_lazy")}, colors = ButtonDefaults.buttonColors(mauButton),
                modifier = Modifier
                    .padding(start = 50.dp, top = 100.dp)
                    .width(315.dp)
                    .height(53.dp)
            ) {
                Text(text = "PUSH")

            }
        }
    }
}



//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        RootScreen()
//    }
//
//}