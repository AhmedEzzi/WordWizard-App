package com.example.kidoapp

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class DetailsActivity : AppCompatActivity() {
    lateinit var wmTxt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContentView(R.layout.activity_details)
        wmTxt=findViewById(R.id.wmTxt)
        val name=intent.getStringExtra("name")
        wmTxt.setText("Welcome $name")

    }
var name:String =""
    fun animStart(view: View) {
        name="animal"
        val jump = Intent(this,GameActivity::class.java)
        jump.putExtra("category",name)
        startActivity(jump)
    }

    fun fvcStart(view: View) {
        name="fvc"
        val jump = Intent(this,GameActivity::class.java)
        jump.putExtra("category",name)
        startActivity(jump)
    }
}