package com.namu.data.dao

import androidx.room.*
import com.example.entity.local.LocalDataPostModel
import io.reactivex.Single

@Dao
interface PostDao {
     @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun savePost(item:LocalDataPostModel): Single<Long>

     @Query("SELECT * FROM localdatapostmodel WHERE id =:id")
     fun getPostEach(id: Int):  Single<LocalDataPostModel>

     @Query("SELECT * FROM localdatapostmodel ")
     fun getPostListAll(): Single<List<LocalDataPostModel>>

     @Delete
     fun deletePostEach(item:LocalDataPostModel):Single<Int>
}