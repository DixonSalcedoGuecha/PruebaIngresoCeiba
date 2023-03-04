package com.example.pruebadeingresoceiba.presentation.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebadeingresoceiba.databinding.ItemPostBinding
import com.example.pruebadeingresoceiba.domain.model.PostItem

class PostViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPostBinding.bind(view)

    fun render (postItem: PostItem){
        with(binding){
            titlePost.text = postItem.title
            bodyPost.text = postItem.body

        }

    }
}