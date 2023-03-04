package com.example.pruebadeingresoceiba.presentation.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebadeingresoceiba.databinding.ItemUsersBinding
import com.example.pruebadeingresoceiba.domain.model.UserItem

class UserViewHolder( view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemUsersBinding.bind(view)

    fun render (userItem: UserItem, onClickListener: (UserItem) -> Unit){
        with(binding){
            nameUser.text = userItem.name
            cellUser.text = userItem.phone
            mailUser.text = userItem.email

            txtSeePublications.setOnClickListener { onClickListener(userItem) }
        }

    }
}