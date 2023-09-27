package com.example.sept272023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginUsername = findViewById<EditText>(R.id.loginUsername)
        val loginPassword = findViewById<EditText>(R.id.loginPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val regFullName = findViewById<EditText>(R.id.regFullName)
        val regSection = findViewById<EditText>(R.id.regSection)
        val regUsername = findViewById<EditText>(R.id.regUsername)
        val regPassword = findViewById<EditText>(R.id.regPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val login = Intent(this, SecondActivity::class.java)

        var accountList = ArrayList<String>()
        var passwordList = ArrayList<String>()
        var nameList = ArrayList<String>()
        var sectionList = ArrayList<String>()

        btnLogin.setOnClickListener {
            try {

                if(accountList.contains(loginUsername.text.toString())){
                    if(passwordList[accountList.indexOf(loginUsername.text.toString())] != loginPassword.text.toString()) {
                        Toast.makeText(this,"Incorrect Password.", Toast.LENGTH_SHORT).show()
                    }

                    else {
                        var index = accountList.indexOf(loginUsername.text.toString())
                        login.putExtra("name", accountList[index])
                        login.putExtra("section", sectionList[index])
                        startActivity(login)
                    }
                }

                else {
                    Toast.makeText(this,"Incorrect Username or Password", Toast.LENGTH_SHORT).show()
                }

                loginUsername.text.clear()
                loginPassword.text.clear()
            }

            catch (a: ArrayIndexOutOfBoundsException) {
                Toast.makeText(this, "Account not found!", Toast.LENGTH_SHORT).show()
            }

            catch (e: Exception) {
                Log.e("exception", e.message.toString())
            }
        }

        btnRegister.setOnClickListener {
            try {

                    if (regFullName.text.toString().isBlank()  || regSection.text.toString().isBlank() || regUsername.text.toString().isBlank() || regPassword.text.toString().isBlank()) {
                        Toast.makeText(this,"All fields must be filled.", Toast.LENGTH_SHORT).show()
                    }

                    else {
                        if(accountList.contains(regUsername.text.toString())) {
                            Toast.makeText(this,"Account already exists.", Toast.LENGTH_SHORT).show()
                        }
                        else {
                            accountList.add(regUsername.text.toString())
                            passwordList.add(regPassword.text.toString())
                            nameList.add(regFullName.text.toString())
                            sectionList.add(regSection.text.toString())
                            Toast.makeText(this,"Account Registered", Toast.LENGTH_SHORT).show()
                        }
                    }

                regFullName.text.clear()
                regSection.text.clear()
                regUsername.text.clear()
                regPassword.text.clear()
            }

            catch (e: Exception) {
                Log.e("exception", e.message.toString())
            }
        }
    }
}

