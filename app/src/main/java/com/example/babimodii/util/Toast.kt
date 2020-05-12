package com.example.babimodii.util

import android.content.Context
import android.widget.Toast

fun tampilToast(contex:Context, message:String){
    Toast.makeText(contex, message, Toast.LENGTH_SHORT).show()
}