package com.ougen.basicquizapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
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
        val questionList=getListFromJsonData(this)
        //Soruları karıştırdık ve gösterme ekranına gönderdik
        val a=getListFromJsonData(this).shuffled()
        //soruları gösteren fonksiyonu cagirdik
        showQuestion(currentQuestion,a)






               b_opt1.setOnClickListener{
                   if (a[currentQuestion].opt1 == a[currentQuestion].answer){
                       //dogru
                       dogru++

                       Toast.makeText(this@MainActivity,"Doğru",Toast.LENGTH_SHORT).show()
                   }
                   else{
                       //yanlis
                       yanlis++
                       Toast.makeText(this@MainActivity,"Yanlış! Doğru cevap: "
                               + a[currentQuestion].answer,Toast.LENGTH_SHORT).show()
                   }

                   //diger soruyu yükle
                   if(currentQuestion<questionList.size-1){
                       currentQuestion++
                       showQuestion(currentQuestion, a)
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
                   if (a[currentQuestion].opt2==(a[currentQuestion].answer)){
                       //dogru
                       dogru++
                       Toast.makeText(this@MainActivity,"Doğru",Toast.LENGTH_SHORT).show()
                   }
                   else{
                       //yanlis
                       yanlis++
                       Toast.makeText(this@MainActivity,"Yanlış! Doğru cevap: "
                               + a[currentQuestion].answer,Toast.LENGTH_SHORT).show()
                   }

                   //diger soruyu yükle
                   if(currentQuestion<questionList.size-1){
                       currentQuestion++
                       showQuestion(currentQuestion, a)
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

                   if (a[currentQuestion].opt3==(a[currentQuestion].answer)){
                       //dogru
                       dogru++
                       Toast.makeText(this@MainActivity,"Doğru",Toast.LENGTH_SHORT).show()
                   }
                   else{
                       //yanlis
                       yanlis++
                       Toast.makeText(this@MainActivity,"Yanlış! Doğru cevap: "
                               + a[currentQuestion].answer,Toast.LENGTH_SHORT).show()
                   }

                   //diger soruyu yükle
                     if(currentQuestion<questionList.size-1){
                       currentQuestion++
                       showQuestion(currentQuestion,a)
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



    fun showQuestion(number: Int, a: List<Question>){




        tvJsonString.setText(a.get(number).q)
        b_opt1.setText(a.get(number).opt1)
        b_opt2.setText(a.get(number).opt2)
        b_opt3.setText(a.get(number).opt3)



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