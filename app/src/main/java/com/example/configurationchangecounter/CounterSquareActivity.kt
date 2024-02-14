package com.example.configurationchangecounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.configurationchangecounter.databinding.ActivityCounterSquareBinding
import java.lang.IllegalStateException

class CounterSquareActivity : AppCompatActivity() {

    private var CounterSquare: Int = 0

    private var currentCounter: Int = 0

    private var _binding: ActivityCounterSquareBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("ActivityCounterSquareBinding is null")

    override fun onSaveInstanceState(savedInstanceState: Bundle){
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt("currentCounterSquare", CounterSquare)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityCounterSquareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentCounter = intent.getIntExtra("counter", 0) - 1

        CounterSquare = currentCounter * currentCounter

        binding.tvCounterSquare.text = CounterSquare.toString()

        binding.btnGoBack.setOnClickListener {
            startActivity(Intent(this, ConfigurationCounterActivity::class.java).apply {
                putExtra("counter", currentCounter)
            })
        }


        Log.d("CounterSquareActivityLog", "Created")

    }

    override fun onStart() {
        super.onStart()
        Log.d("CounterSquareActivityLog", "Started")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CounterSquareActivityLog", "Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CounterSquareActivityLog", "Paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CounterSquareActivityLog", "Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CounterSquareActivityLog", "Destroyed")
    }
}