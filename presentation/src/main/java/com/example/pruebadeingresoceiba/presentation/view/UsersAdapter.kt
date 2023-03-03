package com.example.pruebadeingresoceiba.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebadeingresoceiba.R
import com.example.pruebadeingresoceiba.data.model.UserResponse

class UsersAdapter(private val usersListProvider: List<UserResponse>, private val onClickListener: (UserResponse) -> Unit) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return UserViewHolder(layoutInflater.inflate(R.layout.item_users,parent, false))

    }

    override fun getItemCount(): Int = usersListProvider.size


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = usersListProvider[position]
        holder.render(item, onClickListener)
    }
}