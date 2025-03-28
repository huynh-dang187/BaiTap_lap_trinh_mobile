package com.example.learnfirebasebytutorials

import android.R.attr.onClick
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable


import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ripple // Chỉ dùng Material3 ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnfirebasebytutorials.ui.theme.LearnFireBaseByTutorialsTheme
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun GoogleSignInButton(signIn: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.size(width = 513.dp, height = 300.dp)) {
            Image(
                painter = painterResource(R.drawable.nen),
                contentDescription = "Nền",
                modifier = Modifier.size(width = 513.dp, height = 500.dp)
            )
            Image(
                painter = painterResource(R.drawable.uth),
                contentDescription = "Nền",
                modifier = Modifier
                    .size(width = 300.dp, height = 300.dp)
                    .padding(start = 92.dp, top = 106.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(R.drawable.smart_taskpng),
                contentDescription = "Nền",
                modifier = Modifier
                    .size(width = 280.dp, height = 70.dp)
                    .padding(start = 120.dp, top = 7.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Welcome",
                fontSize = 20.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(start = 149.dp, top = 100.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Ready to explore? Log in to get started.",
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(start = 40.dp, top = 10.dp)
            )
        }

        // Bọc nút đăng nhập trong một Box riêng
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.button_google),
                contentDescription = "Google Sign-In Button",
                modifier = Modifier
                    .size(width = 300.dp, height = 80.dp)
                    .align(Alignment.Center) // Đưa ảnh vào giữa
                    .clickable {
                        Log.d("GoogleSignIn", "Button clicked")
                        signIn()
                    }
            )
        }

        // Nút đăng xuất và đăng nhập lại
//        Button(
//            onClick = { SignOutAndSignInNew() },
//            modifier = Modifier.padding(top = 30.dp, start = 90.dp)
//        ) {
//            Text("Đăng xuất và Đăng nhập lại")
//        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearnFireBaseByTutorialsTheme {
        GoogleSignInButton()
    }
}