package com.lakeisha.fetchrewardstracker.data

data class RewardItem(
    val id: Int,
    val title:String,
    val points: Int,
    val isCompleted: Boolean = false
)