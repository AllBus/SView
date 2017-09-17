package com.kos.sview

import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast

/**
  * Created by Kos on 16.08.2017.
  */
trait SFragment extends SWindow{
	self: Fragment =>

	def find[T <: View](resId: Int) = getView.findViewById(resId).asInstanceOf[T]

	def context = getActivity

	@inline def toast(text: CharSequence) = Toast.makeText(getActivity.getApplicationContext,text, Toast.LENGTH_SHORT).show()

	@inline def toast(@StringRes textId: Int) = Toast.makeText(getActivity.getApplicationContext,textId, Toast.LENGTH_SHORT).show()
}
