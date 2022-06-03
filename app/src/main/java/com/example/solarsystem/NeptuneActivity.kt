package com.example.solarsystem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_neptune.*
import java.math.RoundingMode
import java.text.DecimalFormat

class NeptuneActivity : AppCompatActivity() {

    companion object {
        const val descriptionText = "Dark, cold, and whipped by supersonic winds, ice giant" +
                " Neptune is the eighth and most distant planet in our solar system."
        const val yearLength = 164.8
        const val flightTime = 12
        const val surfaceGravityOnEarth = 9.8
        const val surfaceGravityOnNeptune = 11.15
        const val surfaceGravityOnTriton = 0.779
        const val surfaceGravityOnProteus = 0.07
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neptune)

        val yearLengthText = "$yearLength Earth years"
        val flightTimeText = "$flightTime Earth years"

        description.text = descriptionText
        year_length.text = yearLengthText
        flight_time.text = flightTimeText

        val weightText = " ${calculateWeight(surfaceGravityOnNeptune)} kg"
        val weightOnTritonText = " Your weight on Triton " +
                "${calculateWeight(surfaceGravityOnTriton)} kg"
        val weightOnProteusText = " Your weight on Proteus " +
                "${calculateWeight(surfaceGravityOnProteus)} kg"

        weight.text = weightText
        triton_weight.text = weightOnTritonText
        proteus_weight.text = weightOnProteusText
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

    private fun roundTwoDecimalPlaces(weightOnNeptune: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        return df.format(weightOnNeptune)
    }
}