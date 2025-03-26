package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.w3c.dom.Text

@Composable
fun Detail(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        Row {
            Image(
                painter = painterResource(R.drawable.image_2),
                contentDescription = "Anh2",
                modifier = Modifier
                    .padding(start = 25.dp, top = 47.dp)
                    .size(width = 40.dp, height = 40.dp)

            )

            Text(
                text = "Detail", fontSize = 28.sp, color = mauChu, fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 100.dp, top = 50.dp)


            )

        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,


        ) {
            Text(
                text = "The only way to do great work \n" +
                        "       is to love what you do",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterVertically)

            )
        }
        Image(painter = painterResource(R.drawable.image_4), contentDescription = "Anh4"
            , modifier = Modifier
                .padding(start = 46.dp,top = 39.dp)
                .size(width = 296.dp, height = 444.dp)
        )
        Button(onClick = {navController.navigate("ScreenRoot")} , colors = ButtonDefaults.buttonColors(mauButton)//navController.navigate("ScreenRoot")
            , modifier = Modifier.padding(start = 48.dp,top = 83.dp)
                .size(width = 315.dp, height = 53.dp)


        ) {
                Text(text = "BACK TO ROOT", fontWeight = FontWeight.SemiBold)

        }
    }
}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        Detail()
//    }
//
//}