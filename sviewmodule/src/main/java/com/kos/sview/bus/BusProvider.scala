package com.kos.sview.bus

import com.kos.core.bus.{Bus, IBusHandler, IBusSender}


/**
  * Created by Kos on 01.04.2017.
  */
object BusProvider {
	private[this] val bus = new Bus()
	private[this] var lastId = 1

	def generateId = synchronized {
		lastId += 1
		lastId
	}

	def post(message: IBusSender) = bus.post(message)

	def register(activity: IBusHandler) = bus.register(activity)

	def unregister(activity: IBusHandler) = bus.unregister(activity)

}
