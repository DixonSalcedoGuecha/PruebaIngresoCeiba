package com.example.pruebadeingresoceiba.view

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebadeingresoceiba.databinding.ActivityUsersBinding
import com.example.domain.model.UserItem
import com.example.infrastructure.Constants.KEY_SEND_OBJECT
import com.example.pruebadeingresoceiba.view.adapters.UsersAdapter
import com.example.pruebadeingresoceiba.viewmodel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsersBinding
    private val usersViewModel: UsersViewModel by viewModels()
    private lateinit var adapter: UsersAdapter
    private var listUsers = emptyList<UserItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (connectedValidate()){
            initViewModels()
        } else {
            initViewModelsWithoutConnection()
        }
        binding.txtConection.isVisible = !connectedValidate()


        binding.searchUsers.addTextChangedListener { nameUser ->
            if (connectedValidate()) {
                val usersFiltered = listUsers.filter { userFilter ->
                    userFilter.name.lowercase().contains(nameUser.toString().lowercase())
                }
                viewEmptyList(usersFiltered.isEmpty())
                adapter.updateUsers(usersFiltered)
            }
        }

    }

    private fun connectedValidate() : Boolean {
        val cm = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }

    private fun initViewModels() {
        usersViewModel.onCreate()
        usersViewModel.usersList.observe(this, Observer {
            listUsers = it
            initRecyclerView()
        })
        usersViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
    }

    private fun initViewModelsWithoutConnection() {
        usersViewModel.withoutConnection()
        usersViewModel.usersList.observe(this, Observer {
            listUsers = it
            initRecyclerView()
        })
        usersViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
    }

    private fun viewEmptyList(empty: Boolean){
        binding.imgEmpty.isVisible = empty
        binding.txtEmpty.isVisible = empty

    }

    private fun initRecyclerView() {

        viewEmptyList(listUsers.isEmpty())
        adapter = UsersAdapter(listUsers) { userItem -> onItemSelected(userItem) }
        binding.rcvUsers.layoutManager = LinearLayoutManager(this)
        binding.rcvUsers.adapter = adapter
    }

    private fun onItemSelected(userItem: UserItem) {
        val intent = Intent(this, PostActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable(KEY_SEND_OBJECT, userItem)
        intent.putExtras(bundle)
        startActivity(intent)

    }
}