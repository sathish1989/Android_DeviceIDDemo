/*
 * Created by Sathishkumar Durai
 * Code Help 4 You
 * Write to: sathish.codehelp4you@gmail.com
 */

package com.codehelp4you.deviceidfinder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

/***
 * 
 * @author Sathish
 *
 */

public class HomeActivity extends Activity {

	private Button getButton;
	
	private Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		getButton = (Button)findViewById(R.id.getId);
		getButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog alertDialog = new AlertDialog.Builder(context).create();
				alertDialog.setTitle("Device ID");
				alertDialog.setMessage(GetDeviceID(context));
				alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int which) {
					   dialog.dismiss();
				   }
				});
				
				alertDialog.show();
			}
		});
	}
	
	/**
	 * This function return the device ID given the context
	 * @param context
	 * @return
	 */
	public String GetDeviceID(Context context)
	{
		return Settings.Secure.getString(context.getContentResolver(),Settings.Secure.ANDROID_ID);	
	}

}
