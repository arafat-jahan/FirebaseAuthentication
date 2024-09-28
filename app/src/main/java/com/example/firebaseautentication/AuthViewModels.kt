package com.example.firebaseautentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModels : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    // Sign up function
    fun signUp(email: String, password: String): LiveData<String> {
        val result = MutableLiveData<String>()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    result.value = "SignUp Success"
                } else {
                    result.value = it.exception?.message
                }
            }
        return result
    }

    // Sign in function
    fun signIn(email: String, password: String): LiveData<String> {
        val result = MutableLiveData<String>()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    result.value = "Signin Success"
                } else {
                    result.value = it.exception?.message
                }
            }
        return result
    }



    fun signout(){
        auth.signOut()
    }
}