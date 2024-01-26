package com.example.app_cookingtimers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.app_cookingtimers.adapters.TimerAdapter
import com.example.app_cookingtimers.models.MyTimer

class MainActivity : AppCompatActivity() {
    lateinit var timerAdapter: TimerAdapter
    lateinit var listOfTimers: ArrayList<MyTimer>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfTimers = ArrayList<MyTimer>()
        listOfTimers.add(MyTimer("Chicken",120,240,false))
//        listOfTimers.add(MyTimer("Pasta",30,100,false))
//        listOfTimers.add(MyTimer("Bread",400,650,false))
//        listOfTimers.add(MyTimer("Soup",10,800,false))
        timerAdapter = TimerAdapter(this,listOfTimers)


        val ls: ListView = findViewById(R.id.lst_main_timers)
        ls.adapter = timerAdapter
    }
}