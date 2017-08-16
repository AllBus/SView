package com.kos.sview.textWatchers

import android.text.{Editable, TextWatcher}

/**
  * Created by Kos on 09.05.2017.
  */
abstract class ChangedTextWatcher extends TextWatcher {
	override def beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int): Unit = {}

	override def afterTextChanged(s: Editable): Unit = {}
}


