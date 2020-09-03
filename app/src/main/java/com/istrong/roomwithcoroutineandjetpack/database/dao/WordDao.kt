package com.istrong.roomwithcoroutineandjetpack.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.istrong.roomwithcoroutineandjetpack.database.entity.Word

@Dao
interface WordDao {

    @Query("select * from world_table order by word asc")
    fun getWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Delete(entity = Word::class)
    suspend fun delete(word: Word)

}