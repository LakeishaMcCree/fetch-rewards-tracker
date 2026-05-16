package com.lakeisha.fetchrewardstracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "rewards")
data class RewardItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title:String,
    val points: Int,
    val isCompleted: Boolean = false
)
