package com.lakeisha.fetchrewardstracker.data

import kotlinx.coroutines.flow.Flow

class RewardRepository(private val rewardDao: RewardDao) {

    val allRewards: Flow<List<RewardItem>> = rewardDao.getAllRewards()

    suspend fun insertReward(reward: RewardItem) {
        rewardDao.insertReward(reward)
    }

    suspend fun updateReward(reward: RewardItem) {
        rewardDao.updateReward(reward)
    }

    suspend fun deleteReward(reward: RewardItem) {
        rewardDao.deleteReward(reward)
    }
}