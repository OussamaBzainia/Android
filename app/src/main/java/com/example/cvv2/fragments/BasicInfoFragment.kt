package com.example.cvv2.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cvv2.R


private const val NAME_ARG = "name"
private const val GENDER_ARG = "gender"
private const val AGE_ARG = "age"
private const val EMAIL_ARG = "email"


class BasicInfoFragment : Fragment() {

    private lateinit var name: TextView
    private lateinit var age: TextView
    private lateinit var gender: TextView
    private lateinit var email: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_info, container, false)

        name = v.findViewById(R.id.name)!!
        age = v.findViewById(R.id.age)!!
        gender = v.findViewById(R.id.gender)!!
        email = v.findViewById(R.id.email)!!

        arguments?.apply {
            name.text = "Hello my name is ${getString(NAME_ARG)}"
            age.text = "I'am ${getString(AGE_ARG)} years old"
            gender.text = "and I am a ${getString(GENDER_ARG)}"
            email.text = getString(EMAIL_ARG)
        }

        return v
    }

    companion object {

        @JvmStatic
        fun new(name: String, gender: String, age: String?, email: String) =
            BasicInfoFragment().apply {
                arguments = Bundle().apply {

                    putString(NAME_ARG, name)
                    putString(GENDER_ARG, gender)
                    putString(AGE_ARG, age)
                    putString(EMAIL_ARG, email)
                }
            }
    }
}