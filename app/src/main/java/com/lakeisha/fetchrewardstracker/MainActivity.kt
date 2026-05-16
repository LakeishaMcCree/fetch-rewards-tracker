package com.lakeisha.fetchrewardstracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lakeisha.fetchrewardstracker.data.RewardDatabase
import com.lakeisha.fetchrewardstracker.data.RewardRepository
import com.lakeisha.fetchrewardstracker.ui.RewardListScreen
import com.lakeisha.fetchrewardstracker.ui.theme.FetchRewardsTrackerTheme
import com.lakeisha.fetchrewardstracker.viewmodel.RewardViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchRewardsTrackerTheme {
                val database = RewardDatabase.getDatabase(applicationContext)
                val repository = RewardRepository(database.rewardDao())
                val viewModel = RewardViewModel(repository)
                RewardListScreen(viewModel = viewModel)
                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FetchRewardsTrackerTheme {
        Greeting("Android")
    }
}