package com.iconnic.worktemplate.views;
/*
 * 
 * Coded by Joseph "iconnic" Mpyana 2/16/2017
 * 
 */

import com.iconnic.worktemplate.R;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class IconnicToast {
	private static IconnicToast iconnicToast;
	private static Toast toast;
	
	public static IconnicToast getInstance(){if(iconnicToast == null){return new IconnicToast();} return iconnicToast;}
	
	public IconnicToast(){}
	
	public void showToast(Context context ,String text,boolean isShort){
		LayoutInflater inflater = LayoutInflater.from(context);
		//LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.iconnictoastlayout, null);
		CardView layout = (CardView)inflater.inflate(R.layout.iconnictoastlayout, null);
		TextView tv = (TextView)layout.findViewById(R.id.msg); tv.setText(text);
		
		toast = new Toast(context); toast.setView(layout); toast.setGravity(Gravity.CENTER, 0, 0);
		if(isShort){toast.setDuration(Toast.LENGTH_SHORT);}else{toast.setDuration(5000);}
		
		toast.show();
	}
	
	public void cancelToast(){toast.cancel();}
}
