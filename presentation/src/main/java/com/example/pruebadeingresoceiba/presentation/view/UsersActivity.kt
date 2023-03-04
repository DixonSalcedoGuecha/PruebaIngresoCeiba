package com.example.pruebadeingresoceiba.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebadeingresoceiba.databinding.ActivityUsersBinding
import com.example.pruebadeingresoceiba.domain.model.UserItem
import com.example.pruebadeingresoceiba.presentation.view.adapters.UsersAdapter
import com.example.pruebadeingresoceiba.presentation.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsersBinding
    private val usersViewModel: UsersViewModel by viewModels()
    private var listUsers = emptyList<UserItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUsersBinding.inflate(layoutInflater)
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
        val intent = Intent(this, PostActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("user", userItem)
        intent.putExtras(bundle)
        startActivity(intent)

    }
}