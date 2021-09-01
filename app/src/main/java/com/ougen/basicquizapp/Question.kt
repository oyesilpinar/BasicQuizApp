package com.ougen.basicquizapp

class Question (
    val answer: String,
    val opt1: String,
    val opt2: String,
    val opt3: String,
    val q: String
    )
{
    override fun toString(): String = q+"\n"+opt1+"\n"+opt2+"\n"+opt3+"\n"+answer

}