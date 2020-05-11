package com.nero.dinerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val foodList = arrayListOf("Chinese", "Hamburger", "Burger King", "Pizza", "McDonalds", "Barrows")

    private fun generateSelectedFood() {
        val random = Random()
        val randomFood = random.nextInt(foodList.count())
        selectedFoodTxt.text = foodList[randomFood]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateSelectedFood()
        decideBtn.setOnClickListener {
            println("You clicked me!!")
            generateSelectedFood()
        }

        addFoodBtn.setOnClickListener() {
            val addedFood = addFoodTxt.text.toString()
            if(addedFood.isEmpty()) {
                println("Food added is empty")
                return@setOnClickListener
            }
            foodList.add(addedFood)
            addFoodTxt.text.clear()
            println(foodList)
        }
    }
}
