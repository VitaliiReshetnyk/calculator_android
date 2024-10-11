package com.example.vitalii_reshetnyk_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // References to input fields, buttons, and output field
        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val result = findViewById<TextView>(R.id.result)
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        var operation: String = ""

        // Set button listeners to define the operation
        addButton.setOnClickListener { operation = "add" }
        subtractButton.setOnClickListener { operation = "subtract" }
        multiplyButton.setOnClickListener { operation = "multiply" }
        divideButton.setOnClickListener { operation = "divide" }

        // Set calculate button listener
        calculateButton.setOnClickListener {
            val number1 = num1.text.toString().toDoubleOrNull()
            val number2 = num2.text.toString().toDoubleOrNull()

            if (number1 != null && number2 != null) {
                val calcResult = when (operation) {
                    "add" -> number1 + number2
                    "subtract" -> number1 - number2
                    "multiply" -> number1 * number2
                    "divide" -> if (number2 != 0.0) number1 / number2 else "Cannot divide by zero"
                    else -> "Please select an operation"
                }
                result.text = calcResult.toString()
            } else {
                result.text = "Invalid input"
            }
        }
    }
}