package com.example.sms

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {  ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val batteryChanged = BatteryChanged(::onBatteryChanged)
        val intent = IntentFilter(Intent.ACTION_BATTERY_CHANGED)

        registerReceiver(batteryChanged,intent)

    }
    fun onBatteryChanged(level:Int, status:Int){
        binding.changeBattery.text = getString(R.string.activity_main_change_battery,level)

        val statuses = resources.getStringArray(R.array.activity_main_change_status_array)
        binding.changeStatus.text = getString(R.string.activity_main_change_status,statuses[status-1])
    }

}