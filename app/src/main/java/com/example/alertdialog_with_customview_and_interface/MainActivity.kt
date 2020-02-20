package com.example.alertdialog_with_customview_and_interface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(),AlertDialogEx.MyInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bt1_login.setOnClickListener {
            AlertDialogEx().show(supportFragmentManager,"alertdialog")
        }

    }

    override fun myWork(username: String, pass: String) {
        tv1.setText(username+"\n"+pass)
    }
}
