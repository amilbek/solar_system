package com.example.solarsystem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_venus.*

import java.math.RoundingMode
import java.text.DecimalFormat

class VenusActivity : AppCompatActivity() {

    companion object {
        const val descriptionText = "Venus is the second planet from the Sun and" +
                " is Earth’s closest planetary neighbor"
        const val yearLength = 225
        const val flightTime = 0.3
        const val surfaceGravityOnEarth = 9.8
        const val surfaceGravity = 8.87
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venus)

        val yearLengthText = "$yearLength Earth days"
        val flightTimeText = "$flightTime Earth years"

        description.text = descriptionText
        year_length.text = yearLengthText
        flight_time.text = flightTimeText

        val weightOnVenus = (MainActivity.weightOnEarth / surfaceGravityOnEarth) * surfaceGravity
        val weightText = " ${roundTwoDecimalPlaces(weightOnVenus)} kg"
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

    private fun roundTwoDecimalPlaces(weightOnVenus: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        return df.format(weightOnVenus)
    }
}