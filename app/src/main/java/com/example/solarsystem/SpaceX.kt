package com.example.solarsystem

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_spacex.*

class SpaceX : AppCompatActivity() {

    companion object {
        const val elonMuskText = "Elon Reeve Musk is an entrepreneur and business magnate. " +
                "He is the founder, CEO, and Chief Engineer at SpaceX; early-stage investor, " +
                "CEO, and Product Architect of Tesla, Inc.; founder of The Boring Company; and " +
                "co-founder of Neuralink and OpenAI. "

        const val spaceXText = "Space Exploration Technologies Corp. is " +
                "an American aerospace manufacturer, a provider of space transportation services, " +
                "and a communications corporation headquartered in Hawthorne, California. " +
                "SpaceX was founded in 2002 by Elon Musk with the goal of reducing space" +
                " transportation costs to enable the colonization of Mars."

        const val falconText = "Falcon 9 is a partially reusable two-stage-to-orbit medium-lift " +
                "launch vehicle designed and manufactured by SpaceX in the United States. " +
                "The latest version of the first stage can return to Earth and be flown " +
                "again multiple times."
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spacex)

        elon_musk_text.text = elonMuskText
        spacex_text.text = spaceXText
        falcon_text.text = falconText

        back_btn.setOnClickListener {
            val intent = Intent(this, MarsActivity::class.java)
            startActivity(intent)
        }

        main_btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}