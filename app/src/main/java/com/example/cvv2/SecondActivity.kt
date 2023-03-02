package com.example.cvv2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider

class SecondActivity : AppCompatActivity() {

    private lateinit var androidSlider: Slider
    private lateinit var iosSlider: Slider
    private lateinit var flutterSlider: Slider
    private lateinit var arabicCheckBox: CheckBox
    private lateinit var frenchCheckBox: CheckBox
    private lateinit var englishCheckBox: CheckBox
    private lateinit var sportsCheckBox: CheckBox
    private lateinit var gamesCheckBox: CheckBox
    private lateinit var musicCheckBox: CheckBox
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        supportActionBar?.title = "Create Your Resume"

        androidSlider = findViewById(R.id.slider)
        iosSlider = findViewById(R.id.slider2)
        flutterSlider = findViewById(R.id.slider3)
        arabicCheckBox = findViewById(R.id.arabic)
        frenchCheckBox = findViewById(R.id.french)
        englishCheckBox = findViewById(R.id.english)
        sportsCheckBox = findViewById(R.id.sport)
        gamesCheckBox = findViewById(R.id.games)
        musicCheckBox = findViewById(R.id.music)

        submitButton = findViewById(R.id.SubmitButton)

        submitButton.setOnClickListener {
            val fullName = intent.getStringExtra("fullname").toString()
            val email = intent.getStringExtra("email").toString()
            val age = intent.getStringExtra("age").toString()
            val gender = intent.getStringExtra("gender").toString()
            val profile = intent.getStringExtra("profile").toString()

            val intent2 = Intent(this, ResultActivity2::class.java)

            intent2.putExtra("fullname", fullName)
            intent2.putExtra("email", email)
            intent2.putExtra("age", age)
            intent2.putExtra("gender", gender)
            intent2.putExtra("android", androidSlider.value)
            intent2.putExtra("ios", iosSlider.value)
            intent2.putExtra("flutter", flutterSlider.value)
            intent2.putExtra("french", frenchCheckBox.isChecked)
            intent2.putExtra("arabic", arabicCheckBox.isChecked)
            intent2.putExtra("english", englishCheckBox.isChecked)
            intent2.putExtra("sports", sportsCheckBox.isChecked)
            intent2.putExtra("games", gamesCheckBox.isChecked)
            intent2.putExtra("music", musicCheckBox.isChecked)
            intent2.putExtra("profile", profile)

            startActivity(intent2)
        }
    }
}
