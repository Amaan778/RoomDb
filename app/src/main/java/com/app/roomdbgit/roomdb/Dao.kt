package com.app.roomdbgit.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface Dao {
    @Query("SELECT * FROM data")
    fun getAllTrade(): LiveData<List<Data>>

    @Insert
    fun insertTrade(data: Data)

    @Update
    fun updateTrade(data: Data)

    @Delete
    fun deleteTrade(data: Data)
}