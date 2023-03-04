package com.example.pruebadeingresoceiba.view

import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebadeingresoceiba.databinding.ActivityPostBinding
import com.example.domain.model.PostItem
import com.example.domain.model.UserItem
import com.example.pruebadeingresoceiba.view.adapters.PostAdapter
import com.example.pruebadeingresoceiba.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private val postViewModel: PostViewModel by viewModels()
    private var postList: List<PostItem> = emptyList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val getBundle = intent.extras
        var userItem: UserItem? = null

        if(getBundle != null){

            userItem  = getBundle.getSerializable("user") as UserItem?

            binding.cellUser.text = userItem?.phone
            binding.nameUser.text = userItem?.name
            binding.mailUser.text = userItem?.email
            postViewModel._idUser.value = userItem?.id
        }
        if (connectedValidate()){
            initViewModels()
        } else {
            initViewModelsWithoutConnection()
        }

    }

    private fun initViewModelsWithoutConnection() {
        postViewModel.withoutConnection()
        postViewModel.postList.observe(this, Observer {

            postList = it ?: emptyList()
            initRecyclerView()
        })
        postViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
    }

    private fun initViewModels() {
        postViewModel.onCreate()
        postViewModel.postList.observe(this, Observer {

            postList = it ?: emptyList()
            initRecyclerView()
        })
        postViewModel.isLoading.observe(this, Observer{
            binding.progress.isVisible = it
        })
    }

    private fun connectedValidate() : Boolean {
        val cm = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }

    private fun initRecyclerView() {
        binding.rcvPost.layoutManager = LinearLayoutManager(this)
        binding.rcvPost.adapter = PostAdapter(postList)

    }
}