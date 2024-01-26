package com.example.app_cookingtimers

import android.content.ContentValues.TAG
import android.os.CountDownTimer
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.app_cookingtimers.models.MyTimer

class CTimer(timer:MyTimer, v:View): Runnable{
    private val _context : View = v
    private var _timer : MyTimer = timer
    private var _timeElapsed : Long = 0


    override fun run() {
        Looper.prepare()
//        if(!_timer.getPuaseStatus()){
//
//        }
//        _timer.setTimeRemaining(_timer.getInitialTime()-_timeElapsed)
//        _context.findViewById<TextView>(R.id.item_Timer_timer).setText(_timer.getRemainingTime().toString())
//        _timeElapsed++
        Log.d(TAG, "run: ticked from run")
        object : CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {
                println("Ticked " + _timeElapsed + " times")
                _timeElapsed++
            }

            override fun onFinish() {
                Toast.makeText(_context.context,"Finished",Toast.LENGTH_SHORT).show()
            }

        }.start()
    }
}