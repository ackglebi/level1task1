package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLoweActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()

        /*listeners */
        lowerButton.setOnClickListener {
            onLowerClick()
        }

        higherButton.setOnClickListener {
            onHigherClick()
        }

        equalsButton.setOnClickListener {
            onEqualClick()
        }
        updateUI()
    }

    private fun initViews() {
        updateUI()
    }

    private fun updateUI() {

        lastThrowsString.text = getString(R.string.last_throws, lastThrow)

        when (currentThrow) {
            1 -> diceImageView.setImageResource(R.drawable.dice1)
            2 -> diceImageView.setImageResource(R.drawable.dice2)
            3 -> diceImageView.setImageResource(R.drawable.dice3)
            4 -> diceImageView.setImageResource(R.drawable.dice4)
            5 -> diceImageView.setImageResource(R.drawable.dice5)
            6 -> diceImageView.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    /***
     * Class [rollDice] and checks if answer is higher
     */
    private fun onHigherClick() {

        rollDice()

        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /***
     * Class [rollDice] and checks if answer is lower
     */
    private fun onLowerClick() {
        rollDice()

        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /***
     * Class [rollDice] and checks if answer is the same
     */
    private fun onEqualClick() {
        rollDice()

        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    /***
     * Displays a successful Toast message.
     */
    private fun onAnswerCorrect() {
        Toast.makeText(this, "That is correct!", Toast.LENGTH_SHORT).show()
    }

    /***
     * Displays a incorrect  Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, "Oh NOO, That is incorrect!", Toast.LENGTH_SHORT).show()
    }
}
