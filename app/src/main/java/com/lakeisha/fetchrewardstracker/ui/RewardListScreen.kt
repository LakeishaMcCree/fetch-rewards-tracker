package com.lakeisha.fetchrewardstracker.ui

import android.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lakeisha.fetchrewardstracker.data.RewardItem
import com.lakeisha.fetchrewardstracker.viewmodel.RewardViewModel

@Composable
fun RewardListScreen(viewModel: RewardViewModel) {
    var title by remember { mutableStateOf("") }
    var pointsText by remember { mutableStateOf("") }

    val totalPoints = viewModel.totalCompletedPoints()

    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Fetch Rewards Tracker",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Completed Points: $totalPoints",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Reward Activity") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = pointsText,
            onValueChange = { pointsText = it },
            label = { Text("Points") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                val points = pointsText.toIntOrNull() ?: 0
                viewModel.addReward(title, points)

                title = ""
                pointsText = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Reward")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(viewModel.rewards) { reward ->
                RewardCard(
                    reward = reward,
                    onToggle = { viewModel.toggleReward(reward.id) },
                    onDelete = { viewModel.deleteReward(reward.id)}
                )
            }
        }
    }
}

@Composable
fun RewardCard(
    reward: RewardItem,
    onToggle: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = reward.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(text = "${reward.points} points")

                Text(
                    text = if (reward.isCompleted) "Completed" else "Not Completed"
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Button(onClick = onToggle) {
                        Text(
                            if (reward.isCompleted) "Undo" else "Complete"
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    OutlinedButton(onClick = onDelete) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}


