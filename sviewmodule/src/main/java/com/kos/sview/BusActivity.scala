package com.kos.sview

import android.support.v7.app.AppCompatActivity
import com.kos.core.bus.{Bus, IBusHandler, IBusSender}
import com.kos.sview.bus.BusProvider

/**
  * Created by Kos on 01.04.2017.
  */
class BusActivity extends AppCompatActivity with SActivity with IBusHandler{


	override def onStart(): Unit = {
		super.onStart()
		BusProvider.register(this)
	}


	override def onStop(): Unit = {
		super.onStop()
		BusProvider.unregister(this)
	}

	override def busFlags(): Int = Bus.FLAG_ALL

	override def busUpdate(updater: IBusSender): Unit = {

	}

	override lazy val busId: Int = BusProvider.generateId
}
