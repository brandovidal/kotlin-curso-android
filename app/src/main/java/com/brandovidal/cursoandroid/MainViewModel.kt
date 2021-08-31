package com.brandovidal.cursoandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val user = MutableLiveData<User>()

    fun setUser(userData: User) {
        user.value = userData
    }

    fun getUser(): LiveData<User> {
        return user
    }
}

data class User(val name: String, val age: Int)