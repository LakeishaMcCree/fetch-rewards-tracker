package com.lakeisha.fetchrewardstracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface RewardDao {
    @Query("SELECT * FROM rewards ORDER BY id desc")
    fun getAllRewards(): Flow<List<RewardItem>>

    @Insert
    suspend fun insertReward(reward: RewardItem)

    @Update
    suspend fun updateReward(reward: RewardItem)

    @Delete
    suspend fun deleteReward(reward: RewardItem)
}