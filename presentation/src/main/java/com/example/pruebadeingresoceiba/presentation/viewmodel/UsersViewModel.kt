package com.example.pruebadeingresoceiba.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebadeingresoceiba.domain.GetUsersUseCase
import com.example.pruebadeingresoceiba.domain.model.UserItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    var getUsersUseCase : GetUsersUseCase
) : ViewModel() {

    val usersList = MutableLiveData<List<UserItem>>()
    val isLoading = MutableLiveData<Boolean>()


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