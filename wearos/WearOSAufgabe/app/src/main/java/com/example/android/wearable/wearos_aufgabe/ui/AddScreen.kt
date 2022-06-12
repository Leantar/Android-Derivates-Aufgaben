package com.example.android.wearable.wearos_aufgabe.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.wear.compose.material.*
import com.example.android.wearable.wearos_aufgabe.data.WaterIntakeData
import com.example.android.wearable.wearos_aufgabe.viewmodels.SharedViewModel
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun AddScreen(
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
            Chip(
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Set Amount",
                        color = MaterialTheme.colors.onPrimary,
                        textAlign = TextAlign.Center
                    )
                },
                secondaryLabel = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "${viewModel.getAmount().value} ml",
                        color = MaterialTheme.colors.onPrimary,
                        textAlign = TextAlign.Center
                    )
                },
                onClick = {
                    //TODO Navigate to Stepper Screen
                }
            )
        }
        item {
            Chip(
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Pick Time",
                        color = MaterialTheme.colors.onPrimary,
                        textAlign = TextAlign.Center
                    )
                },
                secondaryLabel = {
                    val formatter =
                        remember { DateTimeFormatter.ofPattern("HH:mm") }
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = viewModel.getTime().value.format(formatter),
                        color = MaterialTheme.colors.onPrimary,
                        textAlign = TextAlign.Center
                    )
                },
                onClick = { navController.navigate("TimePicker") }
            )
        }
        item {
            Button(
                onClick = {
                    viewModel.addWaterIntakeData(
                        WaterIntakeData(viewModel.getAmount().value, viewModel.getTime().value)
                    )

                    navController.popBackStack()
                },
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Save Input",
                    color = MaterialTheme.colors.onPrimary,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
