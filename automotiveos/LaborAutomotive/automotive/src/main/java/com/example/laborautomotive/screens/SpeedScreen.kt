package com.example.laborautomotive.screens

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.hardware.CarHardwareManager
import androidx.car.app.hardware.common.OnCarDataAvailableListener
import androidx.car.app.hardware.info.Speed
import androidx.car.app.model.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.util.concurrent.Executor

class SpeedScreen(carContext: CarContext) : Screen(carContext) {
    var mCarHardwareExecutor: Executor? = null
    var s: Speed? = null
    var mHasSpeedAPIPermission = false

    var speedListener = OnCarDataAvailableListener<Speed> {
        synchronized(this) {
            s = it
            invalidate()
        }
    }

    init {
        mCarHardwareExecutor = ContextCompat.getMainExecutor(carContext)
        val lifecycle = lifecycle
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                val carHardwareManager = carContext.getCarService(
                    CarHardwareManager::class.java
                )
                val carInfo = carHardwareManager.carInfo
                try {
                    carInfo.addSpeedListener(mCarHardwareExecutor!!, speedListener)
                    mHasSpeedAPIPermission = true
                } catch (e: SecurityException) {
                    System.out.println(e)
                    mHasSpeedAPIPermission = false
                }
            }
        })
    }

    override fun onGetTemplate(): Template {
        val pane = Pane.Builder()
        if (mHasSpeedAPIPermission){
            val row = Row.Builder()
            row.setTitle("Speed in m/s")
            val speedVal = s?.rawSpeedMetersPerSecond?.value
            row.addText(
                    "Raw Speed " +
                            speedVal + " m/s. "
                )
            pane.addRow(row.build())
        }else{
            pane.setLoading(true)
        }
        return PaneTemplate.Builder(pane.build())
            .setTitle("Speed")
            .setHeaderAction(Action.BACK)
            .build()
    }



}