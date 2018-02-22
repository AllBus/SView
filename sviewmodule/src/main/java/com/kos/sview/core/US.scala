package com.kos.sview.core

import android.content.Context
import android.text.method.LinkMovementMethod
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.{ImageView, TextView}
import com.kos.sview.helpers.OSHelper

/**
  * Created by Kos on 03.03.2016.
  */
object US {

	def enable(view: View, enabled: Boolean): Unit = view.setEnabled(enabled)


	def gone(rootView: View, viewId: Int, isVisible: Boolean = false) = {
		val p = rootView.findViewById[View](viewId)
		if (p != null)
			p.setVisibility(if (isVisible) View.VISIBLE else View.GONE)
	}

	def gone(view: View, isVisible: Boolean) = {
		if (view != null)
			view.setVisibility(if (isVisible) View.VISIBLE else View.GONE)
	}

	def visible(trueView:View,falseView:View,state:Boolean): Unit ={
		if (state){
			trueView.setVisibility(View.VISIBLE)
			falseView.setVisibility(View.INVISIBLE)
		}else{
			trueView.setVisibility(View.INVISIBLE)
			falseView.setVisibility(View.VISIBLE)
		}
	}

	def visible_?(trueView:View,falseView:View,state:Boolean): Unit ={
		if (state){
			if (trueView!=null) trueView.setVisibility(View.VISIBLE)
			if (falseView!=null) falseView.setVisibility(View.INVISIBLE)
		}else{
			if (trueView!=null) trueView.setVisibility(View.INVISIBLE)
			if (falseView!=null) falseView.setVisibility(View.VISIBLE)
		}
	}


	def visible(rotView:View,trueView:Int,falseView:Int,state:Boolean): Unit ={
		if (state){
			rotView.findViewById[View](trueView).setVisibility(View.VISIBLE)
			rotView.findViewById[View](falseView).setVisibility(View.INVISIBLE)
		}else{
			rotView.findViewById[View](trueView).setVisibility(View.INVISIBLE)
			rotView.findViewById[View](falseView).setVisibility(View.VISIBLE)
		}
	}

	def visibleText(textView: TextView, text: String): Unit = if (textView ne null) {
		textView.setVisibility(if (text.isEmpty) View.GONE else View.VISIBLE)
		textView.setText(text)
	}

	def text(textView: TextView, text: String) = if (textView ne null) textView.setText(text)


	def text(view:TextView): String ={
		view.getText.toString
	}

	def text(textView: TextView, stringRes: Int) {
		if (textView ne null) textView.setText(stringRes)
	}


	def text(rootView: View, id: Int, element: String) {
		val textView=rootView.findViewById[TextView](id)
		if (textView ne null) textView.setText(element)
	}

	def text(rootView: View, id: Int, textResId: Int) {
		val textView=rootView.findViewById[TextView](id)
		if (textView ne null) textView.setText(textResId)
	}

	def textHide(rootView: View, id: Int, element: String) {
		val textView=rootView.findViewById[TextView](id)
		if (textView ne null) {
			if (element.isEmpty)
				textView.setVisibility(View.GONE)
			else {
				textView.setVisibility(View.VISIBLE)
				textView.setText(element)
			}
		}
	}

	//================= Html text ============

	def htmlHide(rootView: View, id: Int, element: String) = {
		val  textView=rootView.findViewById[TextView](id)
		if (textView ne null) {
			if (element.isEmpty)
				textView.setVisibility(View.GONE)
			else {
				textView.setVisibility(View.VISIBLE)
				textView.setText(OSHelper.fromHtml(element))
			}
		}
	}

	def htmlHide(textView: TextView, id: Int, element: String) = {
		if (textView ne null) {
			if (element.isEmpty)
				textView.setVisibility(View.GONE)
			else {
				textView.setVisibility(View.VISIBLE)
				textView.setText(OSHelper.fromHtml(element))
			}
		}
	}

	def html(rootView: View, id: Int, element: String) = {
		val  textView=rootView.findViewById[TextView](id)
		if (textView ne null) {
			if (element.isEmpty)
				textView.setText("")
			else {
				textView.setText(OSHelper.fromHtml(element)	)
			}
		}
	}

	def html(textView: TextView, element: String) = {
		if (textView ne null) {
			if (element.isEmpty)
				textView.setText("")
			else {
				textView.setText(OSHelper.fromHtml(element)	)

			}
		}
	}

	//=========Linked html=========

	def htmlLinkHide(rootView: View, id: Int, element: String) = {
		val  textView=rootView.findViewById[TextView](id)
		if (textView ne null) {
			if (element.isEmpty)
				textView.setVisibility(View.GONE)
			else {
				textView.setVisibility(View.VISIBLE)
				textView.setText(OSHelper.fromHtml(element))
				textView.setMovementMethod(LinkMovementMethod.getInstance());
			}
		}
	}

	def htmlLinkHide(textView: TextView, id: Int, element: String) = {
		if (textView ne null) {
			if (element.isEmpty)
				textView.setVisibility(View.GONE)
			else {
				textView.setVisibility(View.VISIBLE)
				textView.setText(OSHelper.fromHtml(element))
				textView.setMovementMethod(LinkMovementMethod.getInstance());
			}
		}
	}

	def htmlLink(rootView: View, id: Int, element: String) = {
		val  textView=rootView.findViewById[TextView](id)
		if (textView ne null) {
			if (element.isEmpty)
				textView.setText("")
			else {
				textView.setText(OSHelper.fromHtml(element)	)
				textView.setMovementMethod(LinkMovementMethod.getInstance())
			}
		}
	}

	def htmlLink(textView: TextView, element: String) = {
		if (textView ne null) {
			if (element.isEmpty)
				textView.setText("")
			else {
				textView.setText(OSHelper.fromHtml(element)	)
				textView.setMovementMethod(LinkMovementMethod.getInstance())
			}
		}
	}

//	//==============Images ===
//
//
//
//	//	def date(textView: TextView, date: Long) = if (textView ne null) U.date(textView, date)
//	//
//	//	def longDate(textView: TextView, date: Long) = if (textView ne null) textView.setText(Utils.getLongDateText(date))
//	//
//	//	def time(textView: TextView, date: Long) = if (textView ne null) textView.setText(Utils.getTimeText(date))
//
//	def image(imageView: ImageView, imageUri: String) =
//		if (imageView ne null) {
//			Glide.`with`(imageView.getContext).load(imageUri).fitCenter().into(imageView)
//		}
//
//	def image(imageView: ImageView, imageUri: String,placeHolderRes:Int) =
//		if (imageView ne null) {
//			Glide.`with`(imageView.getContext).load(imageUri).placeholder(placeHolderRes).fitCenter().dontAnimate().into(imageView)
//		}
//
//	def image(root:View, resId:Int,imageUri: String,placeHolderRes:Int) = {
//		val imageView = root.findViewById(resId).asInstanceOf[ImageView]
//		if (imageView ne null) {
//			Glide.`with`(imageView.getContext).load(imageUri).placeholder(placeHolderRes).fitCenter().dontAnimate().into(imageView)
//		}
//	}
//
//	def imageHide(root:View, resId:Int, imageUri: String,placeHolderRes:Int) = {
//		val imageView = root.findViewById(resId).asInstanceOf[ImageView]
//		if (imageView ne null) {
//
//			if (imageUri.isEmpty){
//				imageView.setVisibility(View.GONE)
//			}else {
//				imageView.setVisibility(View.VISIBLE)
//				Glide.`with`(imageView.getContext).load(imageUri).placeholder(placeHolderRes).fitCenter().dontAnimate().into(imageView)
//			}
//		}
//	}
//
//	def imageHide(root:View, resId:Int, imageUri: String) = {
//		val imageView = root.findViewById(resId).asInstanceOf[ImageView]
//		if (imageView ne null) {
//
//			if (imageUri.isEmpty){
//				imageView.setVisibility(View.GONE)
//			}else {
//				imageView.setVisibility(View.VISIBLE)
//				Glide.`with`(imageView.getContext).load(imageUri).fitCenter().into(imageView)
//			}
//		}
//	}

	def clearImage(imageView:ImageView): Unit ={
		if (imageView ne null) {
			imageView.setImageDrawable(null)
		}
	}

	def image(imageView:ImageView,imageRes:Int): Unit ={
		if (imageView ne null) {
			imageView.setImageResource(imageRes)
		}
	}

//	def image(root:View, resId:Int,imageUri: String) = {
//		val imageView = root.findViewById(resId).asInstanceOf[ImageView]
//		if (imageView ne null) {
//			Glide.`with`(imageView.getContext).load(imageUri).fitCenter().into(imageView)
//		}
//	}

	def image(root:View, resId:Int, imageRes: Int) = {
		val imageView = root.findViewById(resId).asInstanceOf[ImageView]
		if (imageView ne null) {
			imageView.setImageResource(imageRes)
		}
	}

	def hideKeyboard(view: View) {
		if (view != null) {
			val imm: InputMethodManager = view.getContext.getSystemService(Context.INPUT_METHOD_SERVICE).asInstanceOf[InputMethodManager]
			imm.hideSoftInputFromWindow(view.getWindowToken, 0)
		}
	}

	def showKeyboard(view: View) {
		if (view != null) {
			val imm: InputMethodManager = view.getContext.getSystemService(Context.INPUT_METHOD_SERVICE).asInstanceOf[InputMethodManager]
			imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
		}
	}
}


