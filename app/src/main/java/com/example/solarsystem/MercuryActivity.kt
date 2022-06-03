package com.example.solarsystem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_mercury.*

import java.math.RoundingMode
import java.text.DecimalFormat

class MercuryActivity : AppCompatActivity() {

    companion object {
        const val descriptionText = "Mercury is the smallest planet in " +
                "our solar system and nearest to the Sun"
        const val yearLength = 88
        const val flightTime = 3.45
        const val surfaceGravityOnEarth = 9.8
        const val surfaceGravity = 3.7
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercury)

        val yearLengthText = "$yearLength Earth days"
        val flightTimeText = "$flightTime Earth years"

        description.text = descriptionText
        year_length.text = yearLengthText
        flight_time.text = flightTimeText

        val weightOnMercury = (MainActivity.weightOnEarth / surfaceGravityOnEarth) * surfaceGravity
        val weightText = " ${roundTwoDecimalPlaces(weightOnMercury)} kg"
        weight.text = weightText
    }

    fun clickedPlanetBtn(view: View) {
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

    private fun roundTwoDecimalPlaces(weightOnMercury: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        return df.format(weightOnMercury)
    }
}