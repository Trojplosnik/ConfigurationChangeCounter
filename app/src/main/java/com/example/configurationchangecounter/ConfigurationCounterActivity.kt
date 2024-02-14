package com.example.configurationchangecounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.configurationchangecounter.databinding.ActivityCounterConfigurationBinding
import java.lang.IllegalStateException

class ConfigurationCounterActivity : AppCompatActivity() {

    private var counter: Int = 0

    private var _binding: ActivityCounterConfigurationBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("ActivityCounterConfigurationBinding is null")

    override fun onSaveInstanceState(savedInstanceState: Bundle){
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt("currentCounter", counter)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityCounterConfigurationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        counter =  savedInstanceState?.getInt("currentCounter", 0) ?: intent?.getIntExtra("counter", 0) ?: 0



        binding.tvCounter.text = counter.toString()
        binding.btnCalculateSquare.setOnClickListener {
            startActivity(Intent(this, CounterSquareActivity::class.java).apply {
                putExtra("counter", counter)
            })
        }

        counter++



        Log.d("CounterConfigurationLog", "Created")
    }

    override fun onStart() {
        super.onStart()
        Log.d("CounterConfigurationLog", "Started")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CounterConfigurationLog", "Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CounterConfigurationLog", "Paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CounterConfigurationLog", "Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CounterConfigurationLog", "Destroyed")
    }
}