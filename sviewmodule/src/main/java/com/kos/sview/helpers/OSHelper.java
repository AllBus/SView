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

	/** получить версию Аndroid
	 *
	 * @return версия Аndroid
	 */
	public static String androidVersion() {
		return Build.VERSION.RELEASE;
	}

	/** получить название устройства
	 *
	 * @return название устройства
	 */
	public static String deviceName() {
		String manufacturer = Build.MANUFACTURER;
		String model = Build.MODEL;
		if (model.startsWith(manufacturer)) {
			return capitalize(model);
		} else {
			return capitalize(manufacturer) + " " + model;
		}
	}

	public static String capitalize(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		char first = s.charAt(0);
		if (Character.isUpperCase(first)) {
			return s;
		} else {
			return Character.toUpperCase(first) + s.substring(1);
		}
	}
}
