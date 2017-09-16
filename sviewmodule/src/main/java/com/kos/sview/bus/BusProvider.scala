package com.kos.sview.bus

import android.os.{Handler, Looper}
import com.kos.core.bus.{Bus, IBusHandler, IBusSender}


/**
  * Created by Kos on 01.04.2017.
  */
object BusProvider {
	private[this] val bus = new Bus()
	private[this] var lastId = 1
	private[this] val mHandler = new Handler(Looper.getMainLooper)


	def generateId = synchronized {
		lastId += 1
		lastId
	}

	def getBus = bus

	def garbage() = bus.garbage()

	def post(message: IBusSender): Unit = bus.post(message)

	def register(activity: IBusHandler): Unit = bus.register(activity)

	def unregister(activity: IBusHandler): Unit = bus.unregister(activity)

	def postUI(message: IBusSender): Unit = mHandler.post(new Runnable() {
		override def run(): Unit = bus.post(message)
	})

	def onUI[T](body: => T): Unit = {
		mHandler.post(new Runnable() {
			override def run(): Unit = {
				body
			}
		})
	}
}
