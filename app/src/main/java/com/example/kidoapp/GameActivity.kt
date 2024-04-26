package com.example.kidoapp

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.google.android.material.color.utilities.Score

class GameActivity : AppCompatActivity() {
    lateinit var  imageGame:ImageView
    lateinit var answerTxt:EditText
    lateinit var random:imageList
    lateinit var test:TextView
    lateinit var scoreTxt:TextView
    var score=0

    val animalList = listOf(
        imageList("Lion", R.drawable.lion),
        imageList("Bear", R.drawable.bear),
        imageList("Cow", R.drawable.cow),
        imageList("panther", R.drawable.panther),
        imageList("Cat", R.drawable.cat)

    )
    val fvList = listOf(
        imageList("Berry", R.drawable.berry),
        imageList("Mango", R.drawable.mango),
        imageList("Carrot", R.drawable.carrot),
        imageList("watermelon", R.drawable.watermelon),
        imageList("grapes", R.drawable.grapes)

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        imageGame=findViewById(R.id.imageGame)
        answerTxt=findViewById(R.id.answerTxt)
        scoreTxt=findViewById(R.id.scoreTxt)
        val categorys=intent.getStringExtra("category")
        this.plays("$categorys")

    }
    fun plays(category:String) {
        random = when (category) {
            "animal" -> animalList.random()
            "fvc" -> fvList.random()
            else -> imageList("Error", R.drawable.error) // Default image if category is unknown
        }
        imageGame.setImageResource(random.imageResId)
    }


    fun checkan(view: View) {
        if (answerTxt.text.isEmpty())
            YoYo.with(Techniques.Shake).duration(1500).playOn(answerTxt)
        else {
            if (random.name.equals(answerTxt.text.toString(), ignoreCase = true)) {
                score++
                scoreTxt.text = "Score: $score"
                val categorys = intent.getStringExtra("category")
                plays("$categorys")
                answerTxt.text.clear()
            } else

                Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show()

        }
    }
}