package com.ougen.basicquizapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class MainActivity : AppCompatActivity(){

        //global olarak değişkenlerimizi tanımlıyoruz
        lateinit var tvJsonString: TextView
        lateinit var b_opt1: Button
        lateinit var b_opt2: Button
        lateinit var b_opt3: Button
        var currentQuestion:Int=0
        var dogru:Int=0
        var yanlis:Int=0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvJsonString=findViewById(R.id.tv_question)
        b_opt1=findViewById(R.id.tv_opt1)
        b_opt2=findViewById(R.id.tv_opt2)
        b_opt3=findViewById(R.id.tv_opt3)


        //Json datasını çalıştırmak için gerekli fonksiyonu çagirdik
        getListFromJsonData(this)

        //soruları gösteren fonksiyonu cagirdik
        showQuestion(currentQuestion)


        /*
        var  obj = questionList.get(count)
        b_opt1.setText(obj.opt1)
        b_opt2.setText(obj.opt2)
        b_opt3.setText(obj.opt3)
        count=count+1


         */     val questionList=getListFromJsonData(this)
                System.out.println(questionList[currentQuestion].opt2==questionList[currentQuestion].answer)

               b_opt1.setOnClickListener{
                   if (questionList[currentQuestion].opt1 == questionList[currentQuestion].answer){
                       //dogru
                       dogru++

                       Toast.makeText(this@MainActivity,"Doğru",Toast.LENGTH_LONG).show()
                   }
                   else{
                       //yanlis
                       yanlis++
                       Toast.makeText(this@MainActivity,"Yanlış! Doğru cevap: "
                               + questionList[currentQuestion].answer,Toast.LENGTH_LONG).show()
                   }

                   //diger soruyu yükle
                   if(currentQuestion<questionList.size-1){
                       currentQuestion++
                       showQuestion(currentQuestion)
                   }
                   else{
                       //bitti
                       val intent = Intent(this,EndActivity::class.java)
                       intent.putExtra("Doğru Sayisi",dogru)
                       intent.putExtra("Yanlis Sayisi",yanlis)
                       startActivity(intent)
                       finish()

                   }

               }

               b_opt2.setOnClickListener{
                   if (questionList[currentQuestion].opt2==(questionList[currentQuestion].answer)){
                       //dogru
                       dogru++
                       Toast.makeText(this@MainActivity,"Doğru",Toast.LENGTH_LONG).show()
                   }
                   else{
                       //yanlis
                       yanlis++
                       Toast.makeText(this@MainActivity,"Yanlış! Doğru cevap: "
                               + questionList[currentQuestion].answer,Toast.LENGTH_LONG).show()
                   }

                   //diger soruyu yükle
                   if(currentQuestion<questionList.size-1){
                       currentQuestion++
                       showQuestion(currentQuestion)
                   }
                   else{
                       //bitti
                       val intent = Intent(this,EndActivity::class.java)
                       intent.putExtra("Doğru Sayisi",dogru)
                       intent.putExtra("Yanlis Sayisi",yanlis)
                       startActivity(intent)
                       finish()

                   }
               }

               b_opt3.setOnClickListener{

                   if (questionList[currentQuestion].opt3==(questionList[currentQuestion].answer)){
                       //dogru
                       dogru++
                       Toast.makeText(this@MainActivity,"Doğru",Toast.LENGTH_LONG).show()
                   }
                   else{
                       //yanlis
                       yanlis++
                       Toast.makeText(this@MainActivity,"Yanlış! Doğru cevap: "
                               + questionList[currentQuestion].answer,Toast.LENGTH_LONG).show()
                   }

                   //diger soruyu yükle
                     if(currentQuestion<questionList.size-1){
                       currentQuestion++
                       showQuestion(currentQuestion)
                     }
                     else{
                       //bitti
                       val intent = Intent(this,EndActivity::class.java)
                       intent.putExtra("Doğru Sayisi",dogru)
                       intent.putExtra("Yanlis Sayisi",yanlis)
                       startActivity(intent)
                       finish()

                       }


               }


    }



    fun showQuestion(number:Int){
        val questionList=getListFromJsonData(this)
        tvJsonString.setText(questionList.get(number).q)
        b_opt1.setText(questionList.get(number).opt1)
        b_opt2.setText(questionList.get(number).opt2)
        b_opt3.setText(questionList.get(number).opt3)
        System.out.println(dogru)
        System.out.println(yanlis)


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