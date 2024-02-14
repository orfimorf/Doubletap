package com.example.myapplication

object Storage {
    private var number: Int = 0;
    private var change: Boolean = true;

    fun getNumber(): Int {
        return this.number
    }
    fun plusNumber(){
        this.number++
    }
    fun setNumber(number: Int){
        this.number = number
    }

    fun getChange():Boolean{
        return this.change
    }

    fun switchChange(){
        this.change = !this.change
    }

}