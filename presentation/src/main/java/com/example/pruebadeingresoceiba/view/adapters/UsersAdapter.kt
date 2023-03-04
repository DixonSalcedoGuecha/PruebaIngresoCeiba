package com.example.pruebadeingresoceiba.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebadeingresoceiba.R
import com.example.domain.model.PostItem
import com.example.domain.model.UserItem
import com.example.pruebadeingresoceiba.view.viewholders.UserViewHolder

class UsersAdapter(private var userItemList: List<UserItem>, private val onClickListener: (UserItem) -> Unit) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return UserViewHolder(layoutInflater.inflate(R.layout.item_users,parent, false))

    }

    override fun getItemCount(): Int = userItemList.size


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = userItemList[position]
        holder.render(item, onClickListener)
    }

    fun updateUsers(userList: List<UserItem>){
        this.userItemList = userList
        notifyDataSetChanged()
    }
}