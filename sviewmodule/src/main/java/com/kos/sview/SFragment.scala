package com.kos.sview


import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

/**
  * Created by Kos on 16.08.2017.
  */
trait SFragment extends SWindow{
	self: Fragment =>

	def find[T <: View](resId: Int) = getView.findViewById[T](resId)

	def context = getActivity

	@inline def toast(text: CharSequence) = Toast.makeText(getActivity.getApplicationContext,text, Toast.LENGTH_SHORT).show()

	@inline def toast(@StringRes textId: Int) = Toast.makeText(getActivity.getApplicationContext,textId, Toast.LENGTH_SHORT).show()


}
