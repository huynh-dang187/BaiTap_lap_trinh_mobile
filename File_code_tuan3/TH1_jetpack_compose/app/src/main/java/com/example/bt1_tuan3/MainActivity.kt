package com.example.bt1_tuan3

import android.os.Bundle
import androidx.compose.ui.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.KeyEventDispatcher.Component
import com.example.bt1_tuan3.ui.theme.BT1_tuan3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BT1_tuan3Theme {
                Change_Screen()

            }
            }
        }
    }


@Composable
fun Change_Screen(){
    var ShowScreen by rememberSaveable { mutableStateOf("ImReady") }
    when(ShowScreen){
        "ImReady" -> ImReady (onNavigate = {ShowScreen = "Components"})
        "Components" -> Components (onNavigate = {ShowScreen = "ComponentsDetail"}  )
        "ComponentsDetail" -> ComponentsDetail (onNavigate = {ShowScreen = "Components"})
    }

}


// Màu Customs
val mauBox = Color(0x4D2196F3)
val mauxanhnuocbien = Color(0xFF2196F3)
val customColor = Color(0xFF00FFFF)



@Composable
fun ImReady(onNavigate: () -> Unit){
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_black))
    Column(modifier = Modifier.fillMaxSize()) {
        //Ảnh
        Image(
            painter = painterResource(R.drawable.image),
            contentDescription = "Ảnh JetpackC",
            modifier = Modifier
                .size(width = 216.dp, height = 233.dp)
                .scale(2.25f)//phóng to ảnh
                .padding(start = 80.dp, top = 128.dp)

        )
        //Chữ JetpackCompose
        Text(text = "Jetpack Compose",
            fontFamily =  FontFamily.SansSerif,
            maxLines = 1,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 110.dp, top = 180.dp)
        )

        Box(modifier = Modifier
            .padding(top = 12.dp)
        ) {
            Text(
                text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 33.dp, bottom = 250.dp, end = 33.dp)
            )

        }
        //Button cuối
        Box  (modifier = Modifier.fillMaxSize()){

            Button(
                onClick = onNavigate,
                colors = ButtonDefaults.buttonColors(containerColor = customColor),
                modifier = Modifier
                    .size(width = 315.dp, height = 52.dp)
                    .align(Alignment.Center)

            ) {

                Text(text = "I'm Ready")
            }
        }
    }
}

@Composable
fun Components(onNavigate: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Để dễ kiểm tra UI
    ) {
        // Tiêu đề
        Box (modifier = Modifier.offset ( x= 5.dp )){
            Text(

                text = "UI Components List",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = mauxanhnuocbien,
                modifier = Modifier

                    .padding(start = 86.dp, top = 20.dp, end = 80.dp)
            )
        }

        // Display Section

            Text(
                text = "Display ",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 13.dp, top = 20.dp)
            )

            // Box chứa Text Display
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .height(71.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomEnd = 20.dp,
                            bottomStart = 20.dp
                        )
                    )
                    .offset(x = 5.dp)
                    .background(mauBox) // Kiểm tra nếu bị che mất
                    .padding(vertical = 10.dp) // Thêm padding để dễ nhìn
            ) {
                Text(
                    text = "Text\nDisplay Text",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable { onNavigate() }
                        .padding(start = 33.dp)
                )
            }
            //tạo khoảng cách giữa 2 box
            Spacer(modifier = Modifier.height(16.dp))
            // Box chứa Image Display
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .height(71.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomEnd = 20.dp,
                            bottomStart = 20.dp
                        )
                    )
                    .offset(x = 5.dp)
                    .background(mauBox) // Kiểm tra nếu bị che mất
                    .padding(vertical = 10.dp)
            ) {
                Text(
                    text = "Image\nDisplay an Image",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 33.dp)
                )
            }
            //phan 2//phan 2//phan 2//phan 2

        Text(
            text = "Input",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 13.dp, top = 20.dp)
        )

        // Box chứa Text Display
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(71.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                )
                .offset(x = 5.dp)
                .background(mauBox) // Kiểm tra nếu bị che mất
                .padding(vertical = 10.dp) // Thêm padding để dễ nhìn
        ) {
            Text(
                text = "TextField\nInput field for text",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 33.dp)
            )
        }
        //tạo khoảng cách giữa 2 box
        Spacer(modifier = Modifier.height(16.dp))
        // Box chứa Image Display
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(71.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                )
                .offset(x = 5.dp)
                .background(mauBox) // Kiểm tra nếu bị che mất
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = "PasswordField\nInput field for passwords",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 33.dp)
            )
        }
        //Phan 3
        Text(
            text = "Layout",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 13.dp, top = 20.dp)
        )

        // Box chứa Text Display
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(71.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                )
                .offset(x = 5.dp)
                .background(mauBox) // Kiểm tra nếu bị che mất
                .padding(vertical = 10.dp) // Thêm padding để dễ nhìn
        ) {
            Text(
                text = "Column\nArranges elements vertically",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 33.dp)
            )
        }
        //tạo khoảng cách giữa 2 box
        Spacer(modifier = Modifier.height(16.dp))
        // Box chứa Image Display
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(71.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                )
                .offset(x = 5.dp)
                .background(mauBox) // Kiểm tra nếu bị che mất
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = "Row\nArranges elements horizontally",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 33.dp)
            )
        }
        }

    }


@Composable
fun ComponentsDetail(onNavigate: () -> Unit){
    Column(modifier = Modifier.fillMaxHeight()){
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(R.drawable.chevron_left),
                contentDescription = "left_row",
                modifier = Modifier
                    .padding(start = 19.dp, top = 47.dp)
                    .size(40.dp)
                    .clickable { onNavigate() }

                )

            Text(text = "Text Detail",
                fontSize = 30.sp,
                color = mauxanhnuocbien,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 74.dp,top = 47.dp)


                )

        }
        Image(painter = painterResource(R.drawable.image_2),
            contentDescription = "Anh2",
            modifier = Modifier
                .padding(start = 36.dp, top = 240.dp)
                .size(width = 355.dp, height = 240.dp)

        )
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BT1_tuan3Theme {
        Change_Screen()

    }
}