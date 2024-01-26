package com.example.app_cookingtimers.models

import android.app.Activity
import android.content.ContentValues.TAG
import android.graphics.Color
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.app_cookingtimers.R
import org.w3c.dom.Text
import java.util.DuplicateFormatFlagsException
import java.util.concurrent.FutureTask

class MyTimer(cookedItem:String, timeRemaining:Long, timeInitial:Long, isPaused:Boolean?){
    private val mF: Long = 10L
    private var _cookedItem:String; init {_cookedItem = cookedItem}
    private var _timeRemaining: Long; init {_timeRemaining = timeRemaining}
    private var _timeInitial: Long; init{_timeInitial = timeInitial}
    private var _isPaused:Boolean;
    private var _isDone:Boolean = false
//    private val _v :View = v
    private var _timeElapsed : Long = 0
    init {
        if (isPaused != null) {
            _isPaused = isPaused
        }else _isPaused = false
    }
    public fun getInitialTime():Long{
        return _timeInitial
    }
    fun setTimeRemaining(NT:Long){
        _timeRemaining = NT
    }
    fun getRemainingTime():Long{
        return _timeRemaining
    }
    fun setCookedItem(item:String){
        _cookedItem = item
    }
    fun getCookedItem():String{
        return _cookedItem
    }
    fun pauseUnpause(){
        _isPaused = !_isPaused
        Log.d(TAG, "pauseUnpause: "+_isPaused)
    }
    fun getPuaseStatus():Boolean{
        return _isPaused
    }
    fun setDone(flag:Boolean){
        _isDone = flag
    }
    fun getDoneStatus():Boolean{
        return _isDone
    }
    fun checkDone():Boolean{
        if(_timeRemaining <= 0){
            setDone(true)
        }
        return getDoneStatus()
    }
}