package com.ougen.basicquizapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class MainActivity : AppCompatActivity() {


        var count:Int=0
        lateinit var tvJsonString: TextView
        lateinit var b_opt1: Button
        lateinit var b_opt2: Button
        lateinit var b_opt3: Button
        lateinit var b_next: Button
        var currentQuestion:Int=0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvJsonString=findViewById(R.id.tv_question)
        b_opt1=findViewById(R.id.tv_opt1)
        b_opt2=findViewById(R.id.tv_opt2)
        b_opt3=findViewById(R.id.tv_opt3)
        b_next=findViewById(R.id.btn_next)


        getListFromJsonData(this)

        showQuestion(currentQuestion)







        /*
        var  obj = questionList.get(count)
        b_opt1.setText(obj.opt1)
        b_opt2.setText(obj.opt2)
        b_opt3.setText(obj.opt3)
        count=count+1


         */
               b_opt1.setOnClickListener(View.OnClickListener { view ->
                   // Do some,work here
               })

               b_opt2.setOnClickListener(View.OnClickListener { view ->
                   // Do some work here
               })

               b_opt3.setOnClickListener(View.OnClickListener { view ->



               })

               b_next.setOnClickListener(View.OnClickListener { view ->


               })


    }



    fun showQuestion(number:Int){
        val questionList=getListFromJsonData(this)
        tvJsonString.setText(questionList.get(number).q)
        b_opt1.setText(questionList.get(number).opt1)
        b_opt2.setText(questionList.get(number).opt2)
        b_opt3.setText(questionList.get(number).opt3)


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