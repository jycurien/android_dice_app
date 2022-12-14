package fr.jycurien.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var diceOneImg: ImageView
    private lateinit var diceTwoImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceOneImg = findViewById(R.id.dice_one)
        diceTwoImg = findViewById(R.id.dice_two)

        val rollButton = findViewById<Button>(R.id.btn_roll_dice)

        rollButton.setOnClickListener {
            rollDice(diceOneImg)
            rollDice(diceTwoImg)
        }
    }

    private fun rollDice(diceView: ImageView) {
        val randomNumber = (1..6).random()
        val imgUri = "@drawable/dice$randomNumber"
        val imageResource = resources.getIdentifier(imgUri, null, packageName)
        diceView.setImageResource(imageResource)
    }
}