package com.example.solarsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var weightOnEarth: Double = 0.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickedPlanetBtn(view: View) {
        if (checkEnteredNumber(enter_weight) != 0.0) {
            val imageBtn = view as ImageButton

            val cls = when(imageBtn.contentDescription.toString()) {
                "Earth" -> MainActivity::class.java
                "Mercury" -> MercuryActivity::class.java
                "Venus" -> VenusActivity::class.java
                "Mars" -> MarsActivity::class.java
                "Jupiter" -> JupiterActivity::class.java
                "Saturn" -> SaturnActivity::class.java
                "Uranus" -> UranusActivity::class.java
                else -> NeptuneActivity::class.java
            }

            val intent = Intent(this, cls)
            startActivity(intent)
        }
    }

    private fun checkEnteredNumber(enteredWeight: EditText): Double {
        try {
            weightOnEarth = enteredWeight.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "You need to enter number!",
                Toast.LENGTH_LONG).show()
        }
        if (weightOnEarth < 0) {
            Toast.makeText(this, "You need to enter positive number!",
                Toast.LENGTH_LONG).show()
            return 0.0
        }
        return weightOnEarth
    }

}