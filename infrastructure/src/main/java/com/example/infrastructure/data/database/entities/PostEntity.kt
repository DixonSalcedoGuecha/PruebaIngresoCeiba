package com.example.infrastructure.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.PostItem
import com.example.domain.model.UserItem

@Entity(tableName = "post_table")
data class PostEntity(
    @PrimaryKey
    @ColumnInfo(name = "name")  val id: Int,
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "email") val title: String,
    @ColumnInfo(name = "phone") val body: String
)

fun PostItem.toDataBase() = PostEntity(userId = userId, id = id, title = title, body = body)