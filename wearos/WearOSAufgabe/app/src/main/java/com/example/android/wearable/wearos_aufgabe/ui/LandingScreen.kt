package com.example.android.wearable.wearos_aufgabe.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.wear.compose.material.*
import com.example.android.wearable.wearos_aufgabe.viewmodels.SharedViewModel
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun LandingScreen(
    viewModel: SharedViewModel,
    listState: ScalingLazyListState,
    navController: NavHostController
) {
    ScalingLazyColumn(
        modifier = Modifier.fillMaxSize(),
        autoCentering = AutoCenteringParams(itemIndex = 0),
        state = listState
    ) {
        item {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Water Intake Tracker",
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Total amount: ${viewModel.getAllWaterIntakeData().sumOf {it.amount}} ml",
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center
            )
        }
        item {
            Button(
                onClick = {
                    navController.navigate("Add")
                },
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Add",
                    color = MaterialTheme.colors.onPrimary,
                    textAlign = TextAlign.Center
                )
            }
        }
        viewModel.getAllWaterIntakeData().map {
            item {
                Chip(
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colors.onPrimary,
                            text = "Amount: ${it.amount} ml",
                            textAlign = TextAlign.Center
                        )
                    },
                    secondaryLabel = {
                        val formatter = DateTimeFormatter.ofPattern("HH:mm")
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colors.onPrimary,
                            text = "Time: ${it.time.format(formatter)}",
                            textAlign = TextAlign.Center
                        )
                    },
                    onClick = {}
                )
            }
        }
    }
}