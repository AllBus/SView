package com.kos.sview.textWatchers

import android.text.TextWatcher

/**
  * Created by Kos on 09.05.2017.
  */
abstract class AfterTextWatcher extends TextWatcher {
	override def beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int): Unit = {}

	override def onTextChanged(s: CharSequence, start: Int, before: Int, count: Int): Unit = {}

}


