package com.example.pruebadeingresoceiba.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebadeingresoceiba.databinding.ActivityMainBinding
import com.example.pruebadeingresoceiba.data.model.UserResponse
import com.example.pruebadeingresoceiba.domain.model.UserItem
import com.example.pruebadeingresoceiba.presentation.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val usersViewModel: UsersViewModel by viewModels()
    private var listUsers = emptyList<UserItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usersViewModel.onCreate()
        usersViewModel.usersList.observe(this, Observer {
            listUsers = it
            initRecyclerView()
        })
        usersViewModel.isLoading.observe(this, Observer{
            binding.progress.isVisible = it
        })

    }

    private fun initRecyclerView() {

        binding.rcvUsers.layoutManager = LinearLayoutManager(this)

        binding.rcvUsers.adapter = UsersAdapter(
            listUsers
        ) { userItem -> onItemSelected(userItem) }
    }

    private fun onItemSelected(userItem: UserItem){
        Toast.makeText(this, userItem.name, Toast.LENGTH_SHORT).show()
    }
}