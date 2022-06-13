package com.example.laborautomotive.screens

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.hardware.CarHardwareManager
import androidx.car.app.hardware.common.OnCarDataAvailableListener
import androidx.car.app.hardware.info.Model
import androidx.car.app.model.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.util.concurrent.Executor

class CarInfoScreen(carContext: CarContext) : Screen(carContext) {
    var mCarHardwareExecutor: Executor? = null
    var model: Model? = null
    var mHasModelPermission = false

    var modelListener = OnCarDataAvailableListener<Model> {
        synchronized(this) {
            model = it
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
                try{
                    carInfo.fetchModel(mCarHardwareExecutor!!, modelListener)
                    mHasModelPermission = true
                }catch(e: SecurityException){
                    mHasModelPermission = false
                }
            }
        })
    }

    override fun onGetTemplate(): Template {
        val row = Row.Builder()
        row.setTitle("Car Infos")
        val rowtwo = Row.Builder()
        rowtwo.setTitle("Model")
        val pane = Pane.Builder()
        if (mHasModelPermission){
            row.addText(
                "Manufacturer: " + model?.manufacturer?.value
            )
            rowtwo.addText(
                "Year: " + model?.year?.value
            )
            rowtwo.addText("Name: "+model?.name?.value)
        }else{
            pane.setLoading(true)
        }
        pane.addRow(row.build())
        pane.addRow(rowtwo.build())
        return PaneTemplate.Builder(pane.build())
            .setTitle("Car Model")
            .setHeaderAction(Action.BACK)
            .build()
    }



}