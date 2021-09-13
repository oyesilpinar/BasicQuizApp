package com.ougen.basicquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndActivity : AppCompatActivity() {

    lateinit var tv_result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        tv_result=findViewById(R.id.result)

        var dogru:Int=intent.getIntExtra("Doğru Sayisi",0)
        var yanlis:Int=intent.getIntExtra("Yanlis Sayisi",0)

        tv_result.setText("Doğru: " + dogru + "\n\n\nYanlış: " + yanlis)

    }


}