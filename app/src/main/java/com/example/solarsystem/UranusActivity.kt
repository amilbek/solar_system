package com.example.solarsystem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_uranus.*

import java.math.RoundingMode
import java.text.DecimalFormat

class UranusActivity : AppCompatActivity() {

    companion object {
        const val descriptionText = "Uranus is the seventh planet from the Sun, and has the " +
                "third-largest diameter in our solar system."
        const val yearLength = 84
        const val flightTime = 9.5
        const val surfaceGravityOnEarth = 9.8
        const val surfaceGravityOnUranus = 8.87
        const val surfaceGravityOnAriel = 0.249
        const val surfaceGravityOnMiranda = 0.079
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uranus)

        val yearLengthText = "$yearLength Earth years"
        val flightTimeText = "$flightTime Earth years"

        description.text = descriptionText
        year_length.text = yearLengthText
        flight_time.text = flightTimeText

        val weightText = " ${calculateWeight(surfaceGravityOnUranus)} kg"
        val weightOnArielText = " Your weight on Ariel " +
                "${calculateWeight(surfaceGravityOnAriel)} kg"
        val weightOnMirandaText = " Your weight on Miranda " +
                "${calculateWeight(surfaceGravityOnMiranda)} kg"

        weight.text = weightText
        ariel_weight.text = weightOnArielText
        miranda_weight.text = weightOnMirandaText
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

    private fun roundTwoDecimalPlaces(weightOnUranus: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        return df.format(weightOnUranus)
    }
}