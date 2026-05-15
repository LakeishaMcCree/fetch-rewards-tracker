package com.lakeisha.fetchrewardstracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lakeisha.fetchrewardstracker.ui.RewardListScreen
import com.lakeisha.fetchrewardstracker.ui.theme.FetchRewardsTrackerTheme
import com.lakeisha.fetchrewardstracker.viewmodel.RewardViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchRewardsTrackerTheme {
                val rewardViewModel: RewardViewModel = viewModel()
                RewardListScreen(viewModel = rewardViewModel)
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