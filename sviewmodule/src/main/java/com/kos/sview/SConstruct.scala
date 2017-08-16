package com.kos.sview

import android.view.View

/**
 * Created by Kos on 11.09.2015.
 */
trait SConstruct {
	@inline def find[T <: View](rootView: View, resourceId: Int): T = {
		rootView.findViewById(resourceId).asInstanceOf[T]
	}

	@inline def find[T <: View](resourceId: Int)(implicit rootView: View): T = {
		rootView.findViewById(resourceId).asInstanceOf[T]
	}
}
