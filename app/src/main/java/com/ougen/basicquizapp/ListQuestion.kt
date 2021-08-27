package com.ougen.basicquizapp

import com.google.gson.annotations.SerializedName

class ListQuestion {
    @SerializedName(value = "q")
    var q: ArrayList<Question> =ArrayList()

}