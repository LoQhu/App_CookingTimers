package com.example.app_cookingtimers.adapters

import android.content.ContentValues.TAG
import android.graphics.Color
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.app_cookingtimers.CTimer
import com.example.app_cookingtimers.MainActivity
import com.example.app_cookingtimers.R
import com.example.app_cookingtimers.models.MyTimer
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class TimerAdapter(context:MainActivity, listTimers:ArrayList<MyTimer>) : BaseAdapter() {

    private var _context:MainActivity
    private var _listTimers:ArrayList<MyTimer>


    init {
        _context = context
    }
    init{
        _listTimers = listTimers
    }

    override fun getCount(): Int {
        return _listTimers.count()
    }

    override fun getItem(position: Int): MyTimer {
        return _listTimers.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 1L
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val timer: MyTimer = getItem(position)
        val v:View = _context.layoutInflater.inflate(R.layout.timer_item, null)

//        val cTimer : CTimer = CTimer(timer,v)
//        val t = Thread(cTimer)
//        t.start()
        var timeE : Long = 0
        val cdt = object : CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {
                Log.d(TAG, "onTick: "+ timeE)
                timeE++
            }

            override fun onFinish() {
                Toast.makeText(v.context,"countdown done",Toast.LENGTH_SHORT).show()
            }

        }.start()
        val txt_cookedItem:TextView = v.findViewById(R.id.item_Timer_Food)
        txt_cookedItem.setText(timer.getCookedItem())
        val txt_timeRemaining:TextView = v.findViewById(R.id.item_Timer_timer)
        txt_timeRemaining.setText(timer.getRemainingTime().toString())
        val btnPause:Button = v.findViewById(R.id.item_Timer_btn_PauseResume)
        btnPause.setOnClickListener {
            if (timer.getPuaseStatus()) {
                timer.pauseUnpause()
                Toast.makeText(this._context, "Resumed", Toast.LENGTH_LONG).show()
            } else {
                timer.pauseUnpause()
                Toast.makeText(this._context, "Paused", Toast.LENGTH_LONG).show()
            }
        }
        val btnDelete:Button = v.findViewById(R.id.item_Timer_btn_Delete)
        btnDelete.setOnClickListener({
            Toast.makeText(this._context,"Deleted",Toast.LENGTH_LONG).show()
        })

        return v
    }

}