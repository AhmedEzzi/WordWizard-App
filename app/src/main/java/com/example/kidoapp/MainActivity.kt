package com.example.kidoapp

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class MainActivity : AppCompatActivity() {
    lateinit var nameTxt:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        nameTxt=findViewById(R.id.nameTxt)

    }

    fun startBtn(view: View) {
if (nameTxt.text.isEmpty())
    YoYo.with(Techniques.Shake).duration(1500).playOn(nameTxt)
        else {
    val a = Intent(this, DetailsActivity::class.java)
    a.putExtra("name", nameTxt.text.toString())
    startActivity(a)
}
    }
}