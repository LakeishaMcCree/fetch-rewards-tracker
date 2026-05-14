package com.lakeisha.fetchrewardstracker.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lakeisha.fetchrewardstracker.data.RewardItem

class RewardViewModel  : ViewModel() {
    private var nextId = 1
    val rewards = mutableStateListOf<RewardItem>()

    fun addReward(title: String, points: Int) {
        if (title.isBlank() || points <= 0) return

        rewards.add(
            RewardItem(
                id = nextId++,
                title = title,
                points = points
            )
        )
    }

    fun toggleReward(id: Int) {
        val index = rewards.indexOfFirst { it.id == id }

        if (index != -1) {
            val reward = rewards[index]
            rewards[index] = reward.copy(
                isCompleted = !reward.isCompleted
            )
        }
    }

    fun deleteReward(id: Int) {
        rewards.removeIf { it.id == id }
    }

    fun totalCompletedPoints(): Int {
        return rewards
            .filter { it.isCompleted }
            .sumOf { it.points }
    }
}