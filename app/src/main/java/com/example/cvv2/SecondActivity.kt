package com.example.cvv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import com.google.android.material.slider.Slider

class SecondActivity : AppCompatActivity() {

    private lateinit var android : Slider
    private lateinit var ios : Slider
    private lateinit var flutter : Slider
    private lateinit var arabic : CheckBox
    private lateinit var french : CheckBox
    private lateinit var games : CheckBox
    private lateinit var music : CheckBox
    private lateinit var english : CheckBox
    private lateinit var sports : CheckBox
    private lateinit var submit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        supportActionBar?.title = "Create your Resume"

        android = findViewById(R.id.slider)
        ios = findViewById(R.id.slider2)
        flutter = findViewById(R.id.slider3)
        arabic = findViewById(R.id.arabic)
        french = findViewById(R.id.french)
        english = findViewById(R.id.english)
        sports = findViewById(R.id.sport)
        games = findViewById(R.id.games)
        music = findViewById(R.id.music)

        submit = findViewById(R.id.SubmitButton)

        submit.setOnClickListener {
            var  fullname = intent.getStringExtra("fullname").toString()
            var  email = intent.getStringExtra("email").toString()
            var  age = intent.getStringExtra("email").toString()
            var  gender = intent.getStringExtra("gender").toString()

            val intent2 = Intent( this, ResultActivity::class.java)

            intent2.putExtra("fullname",fullname)
            intent2.putExtra("email",email)
            intent2.putExtra("age",age)
            intent2.putExtra("gender",gender)
            intent2.putExtra("android",android.value.toString())
            intent2.putExtra("ios",ios.value.toString())
            intent2.putExtra("flutter",flutter.value.toString())

            var lang = ""
            if(french.isChecked) {
                lang += "French "
            }
            if(english.isChecked) {
                lang += "English "
            }
            if(arabic.isChecked) {
                lang += "Arabic "
            }
            var hobby = ""
            if(sports.isChecked) {
                hobby += "Sports "
            }
            if(games.isChecked) {
                hobby += "Games "
            }
            if(music.isChecked) {
                hobby += "Music "
            }
            intent2.putExtra("languages",lang)
            intent2.putExtra("hobbies",hobby)

            startActivity(intent2)

        } }
    }
