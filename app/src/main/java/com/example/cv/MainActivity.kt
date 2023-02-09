package com.example.cv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var fullname: EditText
    lateinit var age: EditText
    lateinit var email: EditText
    lateinit var reset: Button
    lateinit var next: Button
    lateinit var android: SeekBar
    lateinit var ios: SeekBar
    lateinit var flutter: SeekBar
    lateinit var radioGroup: RadioGroup
    lateinit var homme: RadioButton
    lateinit var femme: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fullname = findViewById(R.id.fullname)
        age = findViewById(R.id.age)
        email = findViewById(R.id.email)
        reset =  findViewById(R.id.reset)
        next =  findViewById(R.id.next)
        android =  findViewById(R.id.androidSeek)
        ios =  findViewById(R.id.iosSeek)
        flutter = findViewById(R.id.flutterSeek)
        homme = findViewById(R.id.homme)
        femme = findViewById(R.id.femme)
        radioGroup = findViewById(R.id.radioGroup)


        fun compareSeekBarValues() {
            val iosValue = ios.progress
            val flutterValue = flutter.progress
            val androidValue = android.progress

            if (androidValue > 80 && androidValue > iosValue && androidValue > flutterValue) {
                Toast.makeText(this, "Vous etes excellent en Android !", Toast.LENGTH_SHORT).show()
            }
            else if (flutterValue > 80 && flutterValue > iosValue && flutterValue > androidValue) {
                Toast.makeText(this, "Vous etes excellent en Flutter !", Toast.LENGTH_SHORT).show()
            }
            else if (iosValue > 80 && iosValue > androidValue && iosValue > flutterValue) {
                Toast.makeText(this, "Vous etes excellent en iOS !", Toast.LENGTH_SHORT).show()
            }
            else if (androidValue <= 30 && iosValue <= 30 && flutterValue <= 30) {
                Toast.makeText(this, "Vous devez travailler vos skills", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Vous avez de bons skills !", Toast.LENGTH_SHORT).show()
            }
        }
        next.setOnClickListener{
            val Fullname = fullname.text.toString()
            val Email = email.text.toString()
            val Age = age.text.toString()

            if( Fullname.isEmpty() || Email.isEmpty() || Age.isEmpty() )
            {
                Toast.makeText(this, "Check your input !", Toast.LENGTH_SHORT).show()
            }
            else {
              if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                  Toast.makeText(this, "Check your email !", Toast.LENGTH_SHORT).show()
                  }
                else {
                 compareSeekBarValues()

                }
            }
        }

       reset.setOnClickListener{
           fullname.setText("")
           age.setText("")
           email.setText("")
           radioGroup.check(R.id.homme)
           flutter.progress = 0
           android.progress = 0
           ios.progress = 0
       }


    }
}