package com.example.pruebadeingresoceiba.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebadeingresoceiba.data.model.UserResponse
import com.example.pruebadeingresoceiba.domain.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor() : ViewModel() {

    val usersList = MutableLiveData<List<UserResponse>>()
    val isLoading = MutableLiveData<Boolean>()

    var getUsersUseCase = GetUsersUseCase()
    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getUsersUseCase()
            if (result.isNotEmpty()){
                usersList.postValue(result)
                isLoading.postValue(false)
            }
        }

    }
}