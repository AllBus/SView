package com.kos.sview.helpers;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

/**
 * Created on 27.02.2017.
 *
 * @author Kos
 */

public class OSHelper {
	@SuppressWarnings("deprecation")
	public static Spanned fromHtml(String source){
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
		} else {
			return Html.fromHtml(source);
		}
	}
}
