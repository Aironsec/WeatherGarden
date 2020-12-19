package ru.stplab.weathergarden

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.stplab.weathergarden.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityMainBinding.inflate(layoutInflater)
    }
}