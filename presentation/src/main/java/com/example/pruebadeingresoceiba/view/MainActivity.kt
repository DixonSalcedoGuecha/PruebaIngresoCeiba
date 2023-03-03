package com.example.pruebadeingresoceiba.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebadeingresoceiba.R
import com.example.pruebadeingresoceiba.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {

        binding.rcvUsers.layoutManager = LinearLayoutManager(this)
        binding.rcvUsers.adapter = UsersAdapter(UsersListProvider.userResponse
        ) { userResponse -> onItemSelected(userResponse) }
    }

    private fun onItemSelected(userResponse: UserResponse){
        Toast.makeText(this, userResponse.name, Toast.LENGTH_SHORT).show()
    }
}