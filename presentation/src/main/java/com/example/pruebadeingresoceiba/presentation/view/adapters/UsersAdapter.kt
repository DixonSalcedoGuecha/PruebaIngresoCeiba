package com.example.pruebadeingresoceiba.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebadeingresoceiba.R
import com.example.pruebadeingresoceiba.domain.model.PostItem
import com.example.pruebadeingresoceiba.domain.model.UserItem
import com.example.pruebadeingresoceiba.presentation.view.viewholders.UserViewHolder

class UsersAdapter(private val userItemList: List<UserItem>, private val onClickListener: (UserItem) -> Unit) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return UserViewHolder(layoutInflater.inflate(R.layout.item_users,parent, false))

    }

    override fun getItemCount(): Int = userItemList.size


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = userItemList[position]
        holder.render(item, onClickListener)
    }
}