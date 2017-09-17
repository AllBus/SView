package com.kos.sview

import android.content.{Context, DialogInterface, Intent}
import android.support.annotation.{DimenRes, DrawableRes, IdRes, StringRes}
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.{AlertDialog, AppCompatActivity}
import android.support.v7.widget.{LinearLayoutManager, RecyclerView, Toolbar}
import android.text.{Editable, TextWatcher}
import android.view.View
import android.view.View.OnClickListener
import android.widget.{TextView, Toast}

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

	implicit class TextViewOps(val a:TextView) extends AnyVal{
		@inline def text:String =a.getText.toString
		@inline def text_=(newValue:CharSequence):Unit = a.setText(newValue)
	}

	implicit class ViewOps(val view:View) extends AnyVal{
		@inline def gone:Unit = view.setVisibility(View.GONE)
		@inline def visible:Unit = view.setVisibility(View.VISIBLE)
		@inline def invisible:Unit = view.setVisibility(View.INVISIBLE)

		@inline def click(body: () => Unit): Unit =
			view.setOnClickListener(new OnClickListener {
				override def onClick(v: View): Unit = {
					body()
				}
			})
	}


	@inline implicit def textWatcherImpl(bodyTextChanged: Editable => Unit): TextWatcher = {
		new TextWatcher {
			override def beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int): Unit = {}

			override def onTextChanged(s: CharSequence, start: Int, before: Int, count: Int): Unit = {}

			override def afterTextChanged(s: Editable): Unit = {
				bodyTextChanged(s)
			}
		}
	}

	@inline implicit def clickListenerImpl(body: () => Unit): OnClickListener = {
		new OnClickListener {
			override def onClick(v: View): Unit = {
				body()
			}
		}
	}


	val KEY_ID="Key_id"
	val NONE_ID = -1
}


trait SActivity  extends SWindow{

	self: AppCompatActivity =>

	@inline def find[T](@IdRes id: Int) = findViewById(id).asInstanceOf[T]

	@inline def toast(text: CharSequence) = Toast.makeText(getApplicationContext,text, Toast.LENGTH_SHORT).show()

	@inline def toast(@StringRes textId: Int) = Toast.makeText(getApplicationContext,textId, Toast.LENGTH_SHORT).show()

	def drawable(@DrawableRes id: Int) = ContextCompat.getDrawable(this,id)


	def dimension(@DimenRes id: Int) =	getResources.getDimension(id)

	def addClick(@IdRes viewId:Int,clickListener: OnClickListener): Unit ={
		findViewById(viewId) match{
			case v:View ⇒ v.setOnClickListener(clickListener)
			case _ ⇒
		}
	}

	def addClick(viewIds:Array[Int],clickListener: OnClickListener): Unit ={
		viewIds.foreach(findViewById(_) match{
			case v:View ⇒ v.setOnClickListener(clickListener)
			case _ ⇒
		})
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



}


