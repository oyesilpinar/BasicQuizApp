package com.ougen.basicquizapp

import com.google.gson.annotations.SerializedName

class ListQuestion {
    @SerializedName(value = "question")
    val questionList: ArrayList<Question>? = null


}