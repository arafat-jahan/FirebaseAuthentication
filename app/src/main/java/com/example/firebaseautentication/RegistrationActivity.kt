package com.example.firebaseautentication

import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseautentication.databinding.ActivityRegistrationBinding
import android.content.Intent as

class RegistrationActivity : AppCompatActivity() {
    private lateinit var viewModel: AuthViewModels
    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(AuthViewModels::class.java)
        binding.registerBtn.setOnClickListener{
            val email = binding.emailEt.text.toString()
            val password = binding.passwordEt.text.toString()
            val conPass = binding.confirmPasswordEt.text.toString()
            if(email.isEmpty()|| password.isEmpty() || conPass.isEmpty()){
                Toast.makeText(this@RegistrationActivity,"Please Fill All fields",
                        Toast.LENGTH_SHORT).show()

            }else if(!password.equals((conPass))){
                Toast.makeText(this@RegistrationActivity,"Password does not match",
                    Toast.LENGTH_SHORT).show()
            }else{
                viewModel.signUp(email,conPass).observe(this,{result->
                    Toast.makeText(this@RegistrationActivity,result,Toast.LENGTH_SHORT).show()

                    if (result.equals("SignUp Success")){






                    }


                })
            }

        }
    }
}