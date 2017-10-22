package com.kos.sview.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.View;

import java.util.List;

/**
 * Created by Kos on 15.10.2017.
 */

public class VoiceHelper {


	public static int goneRecognizer(Context context){

		return checkVocieRecognizer(context) ? View.VISIBLE : View.GONE;
	}

	public static boolean checkVocieRecognizer(Context context){
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		return (intent.resolveActivity(context.getPackageManager()) != null) ;
	}


	/** Create an intent that can start the Speech Recognizer activity
	 *
	 * @param context activity
	 * @param requestCode code for result
	 */
	public static void displaySpeechRecognizer(Activity context, int requestCode) {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		if (intent.resolveActivity(context.getPackageManager()) != null) {
			try {
				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,	RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
				context.startActivityForResult(intent, requestCode);// Start the activity, the intent will be populated with the speech text
			}catch (Exception ignored){

			}
		}
	}

	public static List<String> extractResultText(Intent data){
		return  data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	}
}
