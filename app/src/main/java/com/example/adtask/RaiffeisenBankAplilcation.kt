package com.example.adtask

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class RaiffeisenBankAplilcation : Application() {


    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object{
        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        var context: Context? = null
    }



}