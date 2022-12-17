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
        val dice = Dice(6);
        val diceRoll = dice.roll()
        val imgUri = "@drawable/dice$diceRoll"
        val imageResource = resources.getIdentifier(imgUri, null, packageName)
        diceView.setImageResource(imageResource)
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}