package com.kos.sview

import android.content.{Context, DialogInterface}
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

/**
  * Created by Kos on 16.08.2017.
  */
trait SWindow {
	@inline def snack(view: View, text: CharSequence) = if (view!=null) Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()

	@inline def snack(view: View,@StringRes resId: Int) = if (view!=null) Snackbar.make(view, resId, Snackbar.LENGTH_LONG).show()

	@inline def find[T <: View](view: View, resId: Int) = view.findViewById[T](resId)

	def alertYesNo(resTitle: Int, resInfo: Int, yesOperator: () => Unit, noOperator: () => Unit )(implicit ctx:Context): Unit = {

		val alertDialog: AlertDialog = new AlertDialog.Builder(ctx).create
		alertDialog.setTitle(resTitle)
		alertDialog.setMessage(ctx.getString(resInfo))
		alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, ctx.getString(android.R.string.yes),new DialogInterface
		.OnClickListener {
			override def onClick(dialog: DialogInterface, which: Int): Unit = {
				yesOperator()
			}
		} )
		alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, ctx.getString(android.R.string.no),new DialogInterface
		.OnClickListener{
			override def onClick(dialog: DialogInterface, which: Int): Unit = {
				noOperator()
			}
		})

		alertDialog.show

		//		val dialog= new DialogFragment{
		//			override def onCreateDialog(savedInstanceState:Bundle):Dialog = {
		//				// Use the Builder class for convenient dialog construction
		//				val builder = new AlertDialog.Builder(getActivity())
		//				builder.setTitle(resTitle)
		//				builder.setMessage(getString(resInfo))
		//					.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		//						override def onClick(dialog:DialogInterface, id:Int) {
		//							yesOperator()
		//						}
		//					})
		//					.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
		//						override def onClick(dialog :DialogInterface, id: Int) {
		//							noOperator()
		//						}
		//					})
		//				// Create the AlertDialog object and return it
		//				builder.create()
		//			}
		//		}
		//		dialog.

	}


}
