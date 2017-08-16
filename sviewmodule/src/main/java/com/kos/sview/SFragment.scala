package com.kos.sview

import android.support.v4.app.Fragment
import android.view.View

/**
  * Created by Kos on 16.08.2017.
  */
trait SFragment extends SWindow{
	self: Fragment =>

	def find[T <: View](resId: Int) = getView.findViewById(resId).asInstanceOf[T]

	def context = getActivity


}
