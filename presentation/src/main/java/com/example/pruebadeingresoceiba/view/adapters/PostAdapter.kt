package com.example.pruebadeingresoceiba.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebadeingresoceiba.R
import com.example.domain.model.PostItem
import com.example.pruebadeingresoceiba.view.viewholders.PostViewHolder
import com.example.pruebadeingresoceiba.view.viewholders.UserViewHolder

class PostAdapter(private val postItemList: List<PostItem>) : RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return PostViewHolder(layoutInflater.inflate(R.layout.item_post,parent, false))

    }

    override fun getItemCount(): Int = postItemList.size


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = postItemList[position]
        holder.render(item)
    }
}