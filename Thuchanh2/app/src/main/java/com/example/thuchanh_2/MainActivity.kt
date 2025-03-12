package com.example.thuchanh_2

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    var dsNhanVien: MutableList<String> = mutableListOf("Nguyen Van B","Nguyen Van C","Nguyen Van D", "Nguyen Van E","Nguyen Van F")
    val sachDaChon: MutableList<String> = mutableListOf()

    var dsSach: MutableList<String> = mutableListOf("Sach 3", "Sach 4", "Sach 5", "Sach 6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        addEvents()

    }

    private fun addEvents() {
        // Ham xu lí hien Danh Sach Nhan Vien
        HienDanhSach()
        // Ham xu li hien thi Sach
        HienThiSach()
        // Ham them sach
        ThemSach()
        
    }

    fun ThemSach() {
        val btnThem = findViewById<Button>(R.id.btnThem)
        val chkSach1 = findViewById<CheckBox>(R.id.chkSach1)
        val chkSach2 = findViewById<CheckBox>(R.id.chkSach2)
        var edtTen = findViewById<EditText>(R.id.edtTen)

        btnThem.setOnClickListener {
            var tenNV = edtTen.text.toString()
            if(chkSach1.isChecked){
                sachDaChon.add(chkSach1.text.toString())
            }
            if(chkSach2.isChecked){
                sachDaChon.add(chkSach2.text.toString())
            }

            var message = "Nhân viên: " + tenNV + "\n" + "Sách đã chọn: " + sachDaChon
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            edtTen.setText("")
            sachDaChon.clear()
            edtTen.requestFocus()


        }
    }


    fun HienThiSach() {
        var btnHienSach = findViewById<Button>(R.id.btnHienSach)
        btnHienSach.setOnClickListener {
            val lvSach = findViewById<ListView>(R.id.lvSach)
            val linerSach = findViewById<LinearLayout>(R.id.linerSach)
            lvSach.visibility = View.VISIBLE
            linerSach.visibility = View.VISIBLE
            lvSach.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                dsSach
            )

            lvSach.setOnItemClickListener { parent, view, position, id ->

//                lvSach.visibility = View.GONE
                linerSach.visibility = View.GONE
            }
        }
    }

    fun HienDanhSach() {
        var btnDoi = findViewById<Button>(R.id.btnDoi)
        btnDoi.setOnClickListener {
            val lvTen = findViewById<ListView>(R.id.lvTen)
            val linerAn = findViewById<LinearLayout>(R.id.linerAn)
            lvTen.visibility = View.VISIBLE
            linerAn.visibility = View.VISIBLE
            lvTen.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                dsNhanVien
            )

            var edtTen = findViewById<EditText>(R.id.edtTen)
            var s: String = edtTen.text.toString()
            lvTen.setOnItemClickListener { parent, view, position, id ->
                edtTen.setText(dsNhanVien[position])
//                lvTen.visibility = View.GONE
                linerAn.visibility = View.GONE

            }
        }
        

        // hien danh sach
    }
}







