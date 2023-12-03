package com.app.roomdbgit.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val id:Long=0,
    val CName:String,
    val MiddleName:String,
    val LastName:String,
//    val date:String,
//    val quant:Int,
//    val entryPrice:Int,
//    val stopPrice:Int,
//    val targetPrice:Int,
//    val extprice:Int,
//    val fees:Int,
//    val pl:Int
)