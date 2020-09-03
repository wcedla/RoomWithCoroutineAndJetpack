package com.istrong.roomwithcoroutineandjetpack.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "world_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val world: String)