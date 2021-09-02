package com.brandovidal.cursoandroid

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.parcelize.Parcelize

class MainViewModel: ViewModel() {
    private val user = MutableLiveData<User>()

    fun setUser(userData: User) {
        user.value = userData
    }

    fun getUser(): LiveData<User> {
        return user
    }
}

@Parcelize
data class User(val name: String, val age: Int): Parcelable