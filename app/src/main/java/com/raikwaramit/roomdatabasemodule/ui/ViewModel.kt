package com.raikwaramit.roomdatabasemodule.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raikwaramit.roomdatabasemodule.room.User
import com.raikwaramit.roomdatabasemodule.room.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val dao: UserDao) : ViewModel() {

    private val _state: MutableState<List<User>> = mutableStateOf(emptyList())
    val state: State<List<User>> = _state

    init {
        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch {
            _state.value = dao.getAll()
        }
    }

    fun insertData(user: User) {
        viewModelScope.launch {
            dao.insert(user)
            getUserData()
        }
    }

    fun deleteData(user: User) {
        viewModelScope.launch {
            dao.delete(user)
            getUserData()
        }
    }

}