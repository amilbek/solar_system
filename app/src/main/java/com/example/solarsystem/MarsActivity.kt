package com.example.solarsystem

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mars.*
import kotlinx.android.synthetic.main.activity_spacex.*

import java.math.RoundingMode
import java.text.DecimalFormat

class MarsActivity : AppCompatActivity() {

    companion object {
        const val descriptionText = "Mars is the fourth planet from the Sun – a dusty, " +
                "cold, desert world with a very thin atmosphere."
        const val yearLength = 687
        const val flightTime = 0.8
        const val surfaceGravityOnEarth = 9.8
        const val surfaceGravityOnMars = 3.721
        const val surfaceGravityOnDeimos = 0.003
        const val surfaceGravityOnPhobos = 0.0057
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mars)

        val yearLengthText = "$yearLength Earth days"
        val flightTimeText = "$flightTime Earth years"

        description.text = descriptionText
        year_length.text = yearLengthText
        flight_time.text = flightTimeText

        val weightOnMarsText = " ${calculateWeight(surfaceGravityOnMars)} kg"
        val weightOnDeimosText = " Your weight on Deimos:" +
                " ${calculateWeight(surfaceGravityOnDeimos)} kg"
        val weightOnPhobosText = " Your weight on Phobos:" +
                " ${calculateWeight(surfaceGravityOnPhobos)} kg"

        weight.text = weightOnMarsText
        deimos_weight.text = weightOnDeimosText
        phobos_weight.text = weightOnPhobosText

        spacex.setOnClickListener {
            val intent = Intent(this, SpaceX::class.java)
            startActivity(intent)
        }
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