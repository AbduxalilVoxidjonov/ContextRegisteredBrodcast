package com.example.sms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BatteryChanged(private val changedBattary:(level :Int, status:Int)->Unit): BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val level = intent?.getIntExtra("level", 0)?:return
        val status = intent.getIntExtra("status", 0)
        changedBattary(level,status)

    }


}