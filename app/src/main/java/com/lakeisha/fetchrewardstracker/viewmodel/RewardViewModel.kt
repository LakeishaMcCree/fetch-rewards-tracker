package com.lakeisha.fetchrewardstracker.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lakeisha.fetchrewardstracker.data.RewardItem
import com.lakeisha.fetchrewardstracker.data.RewardRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RewardViewModel(
    private val repository: RewardRepository
) : ViewModel() {
    val rewards = repository.allRewards.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    fun addReward(title: String, points: Int) {
        if (title.isBlank() || points <=0) return
        viewModelScope.launch {
            repository.insertReward(

                RewardItem(
                    title = title,
                    points = points,
                    isCompleted = false
                )
            )
        }
    }

    fun toggleReward(reward: RewardItem) {
        viewModelScope.launch {
            repository.updateReward(
                reward.copy(isCompleted = !reward.isCompleted)
            )
        }
    }

    fun deleteReward(reward: RewardItem) {
        viewModelScope.launch {
            repository.deleteReward(reward)
        }
    }

    fun totalCompletedPoints(): Int {
        return rewards.value
            .filter { it.isCompleted }
            .sumOf { it.points }
    }
}