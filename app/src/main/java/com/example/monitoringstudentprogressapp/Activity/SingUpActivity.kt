package com.example.monitoringstudentprogressapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.monitoringstudentprogressapp.R
import com.example.monitoringstudentprogressapp.SaveLoad.DbHelper
import com.example.monitoringstudentprogressapp.SaveLoad.User
import com.example.monitoringstudentprogressapp.databinding.ActivitySingInBinding
import com.example.monitoringstudentprogressapp.databinding.ActivitySingUpBinding

class SingUpActivity : AppCompatActivity() {
    private var _binding: ActivitySingUpBinding? = null
    private val binding: ActivitySingUpBinding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityMain must not be null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userLogin = binding.userLogin
        val userEmail = binding.userEmail
        val userPass = binding.userPass
        val buttonReg = binding.buttonReg
        val regToLink = binding.regToLink

        regToLink.setOnClickListener()
        {
            val intent = Intent(this, SingInActivity::class.java)
            startActivity(intent)
        }

        buttonReg.setOnClickListener()
        {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login.isEmpty() || email.isEmpty() || pass.isEmpty())
                Toast.makeText(this,  getString(R.string.fieldsAreEmpty), Toast.LENGTH_LONG).show()
            else
            {
                val user = User(login, email, pass)
                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, getString(R.string.userAdded), Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
    }
}