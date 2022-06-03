package com.example.solarsystem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_jupiter.*

import java.math.RoundingMode
import java.text.DecimalFormat

class JupiterActivity : AppCompatActivity() {

    companion object {
        const val descriptionText = "Fifth in line from the Sun, Jupiter is, by far, the" +
                " largest planet in the solar system – more than twice as massive as all the " +
                "other planets combined."
        const val yearLength = 11.9
        const val flightTime = 6
        const val surfaceGravityOnEarth = 9.8
        const val surfaceGravityOnJupiter = 24.79
        const val surfaceGravityOnIo = 1.796
        const val surfaceGravityOnEuropa = 1.315
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jupiter)

        val yearLengthText = "$yearLength Earth years"
        val flightTimeText = "$flightTime Earth years"

        description.text = descriptionText
        year_length.text = yearLengthText
        flight_time.text = flightTimeText

        val weightOnJupiterText = " ${calculateWeight(surfaceGravityOnJupiter)} kg"
        val weightOnIoText = " Your weight on Io " +
                "${calculateWeight(surfaceGravityOnIo)} kg"
        val weightOnEuropaText = " Your weight on Europa" +
                " ${calculateWeight(surfaceGravityOnEuropa)} kg"
        weight.text = weightOnJupiterText
        io_weight.text = weightOnIoText
        europa_weight.text = weightOnEuropaText
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

    private fun calculateWeight(surfaceGravity: Double): String {
        return roundTwoDecimalPlaces(
            (MainActivity.weightOnEarth / surfaceGravityOnEarth) * surfaceGravity)
    }

    private fun roundTwoDecimalPlaces(weightOnJupiter: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        return df.format(weightOnJupiter)
    }
}