package com.ougen.basicquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class BeginActivity : AppCompatActivity() {


    lateinit var tv_basla: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begin)

        tv_basla=findViewById(R.id.tv_basla)

        tv_basla.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            }





    }
}