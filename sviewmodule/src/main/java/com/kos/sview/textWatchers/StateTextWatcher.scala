package com.kos.sview.textWatchers

import android.text.{Editable, TextWatcher}

/**
  * Created on 09.03.2017.
  *
  * @author Kos
  */
class StateTextWatcher extends TextWatcher{
	var bChange=false
	override def beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int): Unit = {}

	override def onTextChanged(s: CharSequence, start: Int, before: Int, count: Int): Unit = {
		bChange=true
	}

	override def afterTextChanged(s: Editable): Unit = {}
}
