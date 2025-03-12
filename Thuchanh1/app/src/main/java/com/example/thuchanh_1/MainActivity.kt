package com.example.thuchanh_1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var NhapTuoi = findViewById<EditText>(R.id.edt2)
        var Kiemtra = findViewById<Button>(R.id.btn3)
        Kiemtra.background.setTint(Color.RED)

        var Kiemtratuoi : View.OnClickListener? = null
        Kiemtratuoi = View.OnClickListener {
            val A = NhapTuoi.text.toString().toInt();
            if(it == Kiemtra){
                if (A < 2) {
                        Toast.makeText(this,"Em Bé",Toast.LENGTH_LONG).show()
                }else if (A > 2 && A <=6){
                    Toast.makeText(this,"Trẻ Em",Toast.LENGTH_LONG).show()
                }else if (A >= 6 && A < 65){
                    Toast.makeText(this,"Người Lớn",Toast.LENGTH_LONG).show()
                }else if (A > 65){
                    Toast.makeText(this,"Người Già",Toast.LENGTH_LONG).show()
                }
            }
        }
        Kiemtra.setOnClickListener(Kiemtratuoi)
    }
}