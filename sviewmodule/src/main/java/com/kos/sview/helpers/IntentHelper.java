package com.kos.sview.helpers;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.StringRes;


/**
 * Created by Kos on 19.03.2017.
 */

public class IntentHelper {
	public static void shareData(Context context, String shareBody, CharSequence chooserTitle) {

		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "");
		sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
		context.startActivity(Intent.createChooser(sharingIntent,chooserTitle));
	}

	public static void copyText(Context context, String shareBody) {
		ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
		ClipData clip = ClipData.newPlainText("character", shareBody);
		cm.setPrimaryClip(clip);

	}

	public static void toast(Context context,@StringRes int stringRes){
		Toast.makeText(context, stringRes, Toast.LENGTH_SHORT).show();
	}

	public static final String GOOGLE_MARKET_SCHEME = "market://";
	public static final String GOOGLE_MARKET = GOOGLE_MARKET_SCHEME + "details?";
	public static final String GOOGLE_MARKET_ID_PARAMETER = "id=";
	public static final String GOOGLE_MARKET_HTTPS = "https://play.google.com/store/apps/details?";

	/** открыть PlayMarket или браузер для выбранного приложения
	 *
	 * @param activity
	 * @param query - Заппрос к маркету. Например:
	 *              IntentHelper.GOOGLE_MARKET_ID_PARAMETER + getPackageName   название пакета открываемогой программы
	 */
	public static  void openPlayMarket(Activity activity, String query){
		Intent googleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(GOOGLE_MARKET + query));
		try {
			activity.startActivity(googleIntent);
		}catch (ActivityNotFoundException e){
			// В случае отсутствия PlayMarket, открыть в браузере
			googleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(GOOGLE_MARKET_HTTPS + query));
			activity.startActivity(googleIntent);
		}
	}

}
