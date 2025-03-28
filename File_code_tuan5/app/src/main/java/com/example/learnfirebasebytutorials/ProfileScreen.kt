package com.example.learnfirebasebytutorials

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


val mautrongbutton = Color(0xFF2196F3)
val mauButton = Color(0xFF2196F3) // Alpha: 1A, Màu: 2196F3 (Xanh)
val mauChu = Color(0xFF2196F3)

@Composable
fun ProfileScreen(profileImage: Uri, name: String, email: String,date:String ,onSignOut: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth().height(80.dp)) {
            Image(
                painter = painterResource(R.drawable.image_2),
                contentDescription = "Anh2",
                modifier = Modifier
                    .padding(start = 25.dp, top = 35.dp)
                    .size(40.dp)
            )

            Text(
                text = "Profile",
                fontSize = 24.sp,
                color = mauChu,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 90  .dp, top = 40.dp)
            )
        }

        // Sửa Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentAlignment = Alignment.Center // Đảm bảo ảnh ở giữa Box
        ) {
            AsyncImage(
                model = profileImage,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
        }
        //Name
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Column {
                // Text "Name" (Không có border)
                Text(
                    text = "Name",
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp) // Cách NameGoogle 1 chút
                )

                // Text nameGoogle (Có border)
                Text(
                    text = name,
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.Black) // Viền đen
                        .padding(8.dp) // Để chữ không bị dính vào viền
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        //Email
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Column {
                // Text "Name" (Không có border)
                Text(
                    text = "Email",
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp) // Cách NameGoogle 1 chút
                )

                // Text nameGoogle (Có border)
                Text(
                    text = email,
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.Black) // Viền đen
                        .padding(8.dp) // Để chữ không bị dính vào viền
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        //Date
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Column {
                // Text "Name" (Không có border)
                Text(
                    text = "Date of Birth",
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp) // Cách NameGoogle 1 chút
                )

                // Text nameGoogle (Có border)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.Black) // Viền đen
                        .padding(5.dp), // Khoảng cách bên trong viền
                    verticalAlignment = Alignment.CenterVertically // Đưa các thành phần về giữa theo chiều dọc
                ) {
                    Text(
                        text = date,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f) // Để text chiếm hết phần trống bên trái
                    )

                    Image(
                        painter = painterResource(R.drawable.material_symbols),
                        contentDescription = "Arrows",
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterVertically) // Đảm bảo hình nằm giữa hàng dọc
                    )
                }

            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row {
        Button(
            onClick = onSignOut,
            modifier = Modifier.padding(top = 130.dp)
                .size(width = 349.dp, height = 52.dp)
        ) {
            Text("Back")
        }
        }
    }
}

