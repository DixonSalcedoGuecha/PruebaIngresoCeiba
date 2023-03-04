package com.example.infrastructure.data.database.dato

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.infrastructure.data.database.entities.PostEntity

@Dao
interface PostDao {

    @Query("SELECT * FROM post_table WHERE userId LIKE :id ")
    suspend fun getIdPost(id: Int) : List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(user: List<PostEntity>)
}