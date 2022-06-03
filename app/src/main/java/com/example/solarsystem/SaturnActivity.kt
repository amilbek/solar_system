package com.example.solarsystem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_saturn.*
import java.math.RoundingMode
import java.text.DecimalFormat

class SaturnActivity : AppCompatActivity() {

    companion object {
        const val descriptionText = "Saturn is the sixth planet from the Sun and the " +
                "second-largest planet in our solar system."
        const val yearLength = 29.45
        const val flightTime = 8
        const val surfaceGravityOnEarth = 9.8
        const val surfaceGravityOnSaturn = 10.44
        const val surfaceGravityOnIapetus = 0.223
        const val surfaceGravityOnTitan = 1.352
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saturn)

        val yearLengthText = "$yearLength Earth years"
        val flightTimeText = "$flightTime Earth years"

        description.text = descriptionText
        year_length.text = yearLengthText
        flight_time.text = flightTimeText

        val weightText = " ${calculateWeight(surfaceGravityOnSaturn)} kg"
        val weightOnIapetusText = " Your weight on Iapetus " +
                "${calculateWeight(surfaceGravityOnIapetus)} kg"
        val weightOnTitanText = " Your weight on Titan " +
                "${calculateWeight(surfaceGravityOnTitan)} kg"

        weight.text = weightText
        iapetus_weight.text = weightOnIapetusText
        titan_weight.text = weightOnTitanText
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

    private fun roundTwoDecimalPlaces(weightOnMars: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        return df.format(weightOnMars)
    }
}