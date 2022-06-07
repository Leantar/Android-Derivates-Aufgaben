package com.example.android.wearable.wearos_aufgabe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.wear.compose.material.*
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.android.wearable.wearos_aufgabe.theme.WearAppTheme
import com.example.android.wearable.wearos_aufgabe.ui.AddScreen
import com.example.android.wearable.wearos_aufgabe.ui.LandingScreen
import com.example.android.wearable.wearos_aufgabe.ui.StepperScreen
import com.example.android.wearable.wearos_aufgabe.viewmodels.SharedViewModel
import com.google.android.horologist.composables.ExperimentalHorologistComposablesApi
import com.google.android.horologist.composables.TimePicker

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            navController = rememberSwipeDismissableNavController()

            WearApp(
                navController = navController,
            )
        }
    }
}


@OptIn(ExperimentalHorologistComposablesApi::class)
@Composable
fun WearApp(navController: NavHostController) {
    val vm: SharedViewModel = viewModel()

    WearAppTheme {
        val listState = rememberScalingLazyListState()

        Scaffold(
            timeText = {
                if (!listState.isScrollInProgress) {
                    TimeText()
                }
            },
            vignette = {
                Vignette(vignettePosition = VignettePosition.TopAndBottom)
            },
            positionIndicator = {
                PositionIndicator(
                    scalingLazyListState = listState
                )
            }
        ) {
            SwipeDismissableNavHost(
                navController = navController,
                startDestination = "Landing",
                modifier = Modifier.background(MaterialTheme.colors.background)
            ) {
                composable("Landing") {
                    LandingScreen(
                        vm,
                        listState,
                        navController
                    )
                }

                composable("Add") {
                    AddScreen(
                        vm,
                        listState,
                        navController
                    )
                }

                composable("Stepper") {
                    StepperScreen(
                        vm,
                    )
                }

                composable("TimePicker") {
                    TimePicker(
                        onTimeConfirm = {
                            vm.setTime(it.atDate(vm.getTime().value.toLocalDate()))
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}
