package com.example.pruebadeingresoceiba.presentation.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebadeingresoceiba.databinding.ItemUsersBinding
import com.example.pruebadeingresoceiba.data.model.UserResponse

class UserViewHolder( view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemUsersBinding.bind(view)

    fun render (userResponse: UserResponse, onClickListener: (UserResponse) -> Unit){
        with(binding){
            nameUser.text = userResponse.name
            cellUser.text = userResponse.phone
            mailUser.text = userResponse.email

            txtSeePublications.setOnClickListener { onClickListener(userResponse) }
        }

    }
}