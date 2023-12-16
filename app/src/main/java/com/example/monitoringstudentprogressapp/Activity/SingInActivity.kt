package com.example.monitoringstudentprogressapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.monitoringstudentprogressapp.R
import com.example.monitoringstudentprogressapp.SaveLoad.DbHelper
import com.example.monitoringstudentprogressapp.databinding.ActivityMainBinding
import com.example.monitoringstudentprogressapp.databinding.ActivitySingInBinding

class SingInActivity : AppCompatActivity() {
    private var _binding: ActivitySingInBinding? = null
    private val binding: ActivitySingInBinding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityMain must not be null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySingInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_sing_in)

        val userLogin = binding.userLoginAuth
        val userPass = binding.userPassAuth
        val buttonLink = binding.buttonAuth

        val linkToReg = binding.linkToReg

        linkToReg.setOnClickListener()
        {
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }
        buttonLink.setOnClickListener()
        {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login.isEmpty() || pass.isEmpty())
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else
            {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if (isAuth)
                {
                    userLogin.text.clear()
                    userPass.text.clear()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "пользователь не $login авторизован", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userPass.text.clear()
            }
        }

    }
}