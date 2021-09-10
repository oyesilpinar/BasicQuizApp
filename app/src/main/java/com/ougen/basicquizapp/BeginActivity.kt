package com.ougen.basicquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle





class BeginActivity : AppCompatActivity() {

    lateinit var tvBasla: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begin)

        tvBasla=find



        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}