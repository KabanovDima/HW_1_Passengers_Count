package com.example.android.count_passengers_hw1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android.count_passengers_hw1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter: Int = 0
    var freeSeats: Int = 49
    var deltaSeats:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.passengersCount.text = counter.toString()
        binding.buttonMinus.isEnabled = false

        binding.buttonPlus.setOnClickListener {
            counter++
            deltaSeats=freeSeats-counter
            if(counter==0){
                binding.buttonMinus.isEnabled = false
                binding.infoFreeSeats.text="Все места свободны"
                binding.infoFreeSeats.setTextColor(Color.GREEN)
            }
            if (counter <= freeSeats) {
                binding.infoFreeSeats.setTextColor(Color.BLUE)
                binding.passengersCount.text=counter.toString()
                binding.infoFreeSeats.text="Осталось мест: $deltaSeats"
                binding.buttonMinus.isEnabled = true
            }
            if(counter>=50){
                binding.infoFreeSeats.setTextColor(Color.RED)
                binding.infoFreeSeats.text="Пассажиров слишком много"
                binding.buttonReset.visibility=View.VISIBLE
//                binding.passengersCount.text="50"
            }
        }
        binding.buttonMinus.setOnClickListener {
            if(counter==0){
                binding.infoFreeSeats.setTextColor(Color.GREEN)
                binding.infoFreeSeats.text="Все места свободны"
            }
            if (counter > 0 && counter <=50) {
                binding.buttonMinus.isEnabled = true
                binding.infoFreeSeats.setTextColor(Color.BLUE)
                counter--
                if(counter==0){
                    deltaSeats=freeSeats
                }else{
                    deltaSeats++
                }
                binding.passengersCount.text = counter.toString()
                binding.infoFreeSeats.text="Осталось мест: $deltaSeats"
            }
        }

        binding.buttonReset.setOnClickListener {
            counter=0
            deltaSeats=0
            binding.passengersCount.text=counter.toString()
            binding.infoFreeSeats.setTextColor(Color.GREEN)
            binding.infoFreeSeats.text="Все места свободны"
            binding.buttonMinus.isEnabled = false
            binding.buttonReset.visibility=View.INVISIBLE
        }
    }
}