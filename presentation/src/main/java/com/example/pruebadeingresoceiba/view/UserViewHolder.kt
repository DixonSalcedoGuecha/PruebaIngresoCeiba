package com.example.pruebadeingresoceiba.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebadeingresoceiba.databinding.ItemUsersBinding

class UserViewHolder( view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemUsersBinding.bind(view)

    fun render (userResponse: UserResponse, onClickListener: (UserResponse) -> Unit){
        with(binding){
            nameUser.text = userResponse.name
            cellUser.text = userResponse.cell
            mailUser.text = userResponse.email

            txtSeePublications.setOnClickListener { onClickListener(userResponse) }
        }

    }
}