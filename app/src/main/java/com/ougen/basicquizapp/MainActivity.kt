package com.ougen.basicquizapp

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

class MainActivity : AppCompatActivity() {






    private var questionsList: ArrayList<Question> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvJsonString=findViewById<TextView>(R.id.tv_question)


        val b_opt1=findViewById<Button>(R.id.tv_opt1)
        val b_opt2=findViewById<Button>(R.id.tv_opt2)
        val b_opt3=findViewById<Button>(R.id.tv_opt3)


        b_opt1.setOnClickListener(View.OnClickListener { view ->
            // Do some work here
        })

        b_opt2.setOnClickListener(View.OnClickListener { view ->
            // Do some work here
        })

        b_opt3.setOnClickListener(View.OnClickListener { view ->
            // Do some work here
        })





        // ********************************************************************************************************************************************

        var questionArraySize = 0
        // get all question objects of selected category from json file and store in questionsList
        try {
            val obj = JSONObject(loadJSONFromAsset())
            val questionArray = obj.getJSONArray("ingilizcekelimeler.json")
            questionArraySize = questionArray.length()
            for (i in 0 until questionArray.length()) {
                val questionJSONObject = questionArray.getJSONObject(i)
                val question = Question(
                    q = questionJSONObject.getString("q"),
                    opt1 = questionJSONObject.getString("opt1"),
                    opt2 = questionJSONObject.getString("opt2"),
                    opt3 = questionJSONObject.getString("opt3"),
                    answer = questionJSONObject.getString("answer")

                )
                questionsList.add(question)
                println(questionsList[0])



            }
        } catch (ex: JSONException) {
            ex.printStackTrace()
        }





// ********************************************************************************************************************************************



    }







    private fun loadJSONFromAsset(): String {
        var json: String = ""
        try {
            val inputStream: InputStream = assets.open("ingilizcekelimeler.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return json
    }




}