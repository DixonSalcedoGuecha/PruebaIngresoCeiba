package com.example.pruebadeingresoceiba.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebadeingresoceiba.domain.GetPostUseCase
import com.example.pruebadeingresoceiba.domain.GetUsersUseCase
import com.example.pruebadeingresoceiba.domain.model.PostItem
import com.example.pruebadeingresoceiba.domain.model.UserItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    var getPostUseCase: GetPostUseCase
) : ViewModel() {

    private val _postList = MutableLiveData<List<PostItem>?>()
    val postList : MutableLiveData<List<PostItem>?> get() = _postList
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading
    val _idUser = MutableLiveData<Int>()


    fun onCreate() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val result = _idUser.value?.let { getPostUseCase(it) }
            if (!result.isNullOrEmpty()) {
                _postList.postValue(result)
                _isLoading.postValue(false)
            }

        }

    }

    fun setIdUser(id: Int) {
        _idUser.postValue(id)
    }
}