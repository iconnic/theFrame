package com.iconnic.worktemplate;

import com.iconnic.worktemplate.views.IconnicToast;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends Activity {
	public static Activity activity; public static Context context; public static IconnicToast toasty=new IconnicToast();
	
	private ImageView close,heart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		activity=this; context=getApplicationContext();
		
		initComponents();
	}
	
	private void initComponents(){
		close=(ImageView)findViewById(R.id.close);
		heart=(ImageView)findViewById(R.id.heart);
		
		close.setOnClickListener(new OnClickListener(){@Override public void onClick(View v){finish();}});
		
		heart.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				toasty.showToast(context,"LIKE",true);
			}});
	}

}
