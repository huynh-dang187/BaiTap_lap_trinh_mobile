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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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


//
val items = listOf("01 | The only way to do great work is to love what you do.",
    "02 | The only way to do great work is to love what you do.",
    "03 | The only way to do great work is to love what you do.",
    "04 | The only way to do great work is to love what you do.",
    "05 | The only way to do great work is to love what you do.",
    "1.000.000 | The only way to do great work is to love what you do.",
    "2.000.0000 | The only way to do great work is to love what you do.")
//
@Composable
fun List_lazy(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        Row {
            Image(painter = painterResource(R.drawable.image_2), contentDescription = "Anh2"
                , modifier = Modifier
                    .padding(start = 25.dp,top = 47.dp)
                    .size(width =  40.dp, height = 40.dp)

            )

            Text(text = "LazyColumn", fontSize =24.sp, color = mauChu, fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 65.dp, top = 50.dp)


            )

        }

            LazyColumn (

            ){
                items(items) { item ->
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .padding(vertical = 14.dp, horizontal = 5.dp)
                            .background(mautrongbutton)// Thêm padding cho Row nếu cần
                    ) {
                        // Text chiếm phần lớn không gian
                        Text(
                            text = item,
                            modifier = Modifier

                                .weight(1f) // Đảm bảo Text chiếm phần lớn không gian
                                 // Màu nền cho Text
                                .padding(20.dp),
                            // Padding cho Text
                            color = Color.White,  // Màu chữ
                            fontSize = 18.sp
                        )

                        // Hình ảnh nằm bên cạnh
                        Image(
                            painter = painterResource(R.drawable.image_3),
                            contentDescription = "Anh3",
                            modifier = Modifier
                                .clickable { navController.navigate("Detail") }
                                .size(50.dp)  // Đặt kích thước hình ảnh
                                .padding(horizontal = 10.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }


    }


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        AllScreen()
//    }
//
//}