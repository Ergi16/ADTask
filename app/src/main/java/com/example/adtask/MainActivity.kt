package com.example.adtask

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    var currentUsers: ArrayList<User>? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        actionBar?.hide()
        this.window.statusBarColor = Color.BLACK

    }

}