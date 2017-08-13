package com.kos.sview

import android.content.{Context, DialogInterface, Intent}
import android.support.annotation.{DimenRes, DrawableRes, IdRes, StringRes}
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.support.v7.widget.{LinearLayoutManager, RecyclerView, Toolbar}
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast

/**
  * Created by Kos on 01.04.2017.
  */

object SActivity{
	implicit class RecyclerViewExtension(val recyclerView:RecyclerView) extends AnyVal{
		@inline
		def standard(implicit ctx:Context) = {
			recyclerView.setLayoutManager(new LinearLayoutManager(ctx,LinearLayoutManager.VERTICAL,false))
		}
	}

	val KEY_ID="Key_id"
	val NONE_ID = -1
}


trait SActivity {

	self: AppCompatActivity =>

	@inline def find[T](@IdRes id: Int) = findViewById(id).asInstanceOf[T]

	@inline def snack(view: View, text: CharSequence) = if (view!=null) Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()

	@inline def snack(view: View,@StringRes resId: Int) = if (view!=null) Snackbar.make(view, resId, Snackbar.LENGTH_LONG).show()

	@inline def toast(text: CharSequence) = Toast.makeText(getApplicationContext,text, Toast.LENGTH_SHORT).show()

	def drawable(@DrawableRes id: Int) = ContextCompat.getDrawable(this,id)


	def dimension(@DimenRes id: Int) =	getResources.getDimension(id)

	def addClick(@IdRes viewId:Int,clickListener: OnClickListener): Unit ={
		findViewById(viewId) match{
			case v:View ⇒ v.setOnClickListener(clickListener)
			case _ ⇒
		}
	}

	def fragmentManager = getSupportFragmentManager

	def show(activityClass: Class[_]) = startActivity(new Intent(this,activityClass))

	def showForResult(activityClass: Class[_],code:Int) = startActivityForResult(new Intent(this,activityClass),code)

	def show(activityClass: Class[_],id:Int) ={

		val intent=new Intent(this,activityClass)
		intent.putExtra(SActivity.KEY_ID,id)
		startActivity(intent)
	}

	def setupToolBar(@IdRes toolbarId:Int): Unit ={
		val toolbar = findViewById(toolbarId).asInstanceOf[Toolbar]
		setSupportActionBar(toolbar)
	}

	def setupToolBarWithBackButton(@IdRes toolbarId:Int): Unit ={
		setupToolBar(toolbarId)

		val actionBar=getSupportActionBar
		if (actionBar!=null){
			actionBar.setDisplayHomeAsUpEnabled(true)

		}
	}

	def getID: Int ={
		val intent=getIntent
		if (intent!=null) {
			intent.getIntExtra(SActivity.KEY_ID,SActivity.NONE_ID)
		}else{
			SActivity.NONE_ID
		}
	}

	def alertYesNo(resTitle: Int, resInfo: Int, yesOperator: () => Unit, noOperator: () => Unit ): Unit = {

		val alertDialog: AlertDialog = new AlertDialog.Builder(this).create
		alertDialog.setTitle(resTitle)
		alertDialog.setMessage(getString(resInfo))
		alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(android.R.string.yes),new DialogInterface
		.OnClickListener {
			override def onClick(dialog: DialogInterface, which: Int): Unit = {
				yesOperator()
			}
		} )
		alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(android.R.string.no),new DialogInterface
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


