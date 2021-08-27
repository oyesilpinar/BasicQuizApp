package com.ougen.basicquizapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvJsonString=findViewById<TextView>(R.id.tv_question)


        val b_opt1=findViewById<Button>(R.id.tv_opt1)
        val b_opt2=findViewById<Button>(R.id.tv_opt2)
        val b_opt3=findViewById<Button>(R.id.tv_opt3)
        val b_next=findViewById<Button>(R.id.btn_next)




        b_opt1.setOnClickListener(View.OnClickListener { view ->
            // Do some work here
        })

        b_opt2.setOnClickListener(View.OnClickListener { view ->
            // Do some work here
        })

        b_opt3.setOnClickListener(View.OnClickListener { view ->
            // Do some work here
        })

        b_next.setOnClickListener(View.OnClickListener { view ->
            // Do some work here
        })


       /*
       *
       *
       * String cevap
       * opt1 cevap=Bosan
       * opt2
       * opt3
       * c
       *
       *
       *
       * */

    }


    fun getListFromJsonData(context: Context): List<Question> {
        val jsonString: String?
        val gson = Gson()
        var questionList: List<Question> = listOf()
        try {
            jsonString = context.assets.open("ingilizcekelimeler.json").bufferedReader().use { it.readText()   }
            val listQuestionType = object : TypeToken<List<Question>>() {}.type
            questionList = gson.fromJson(jsonString,listQuestionType)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return questionList
        }
        return questionList

    }


















}