package com.iconnic.worktemplate;

import com.iconnic.worktemplate.views.IconnicToast;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
	public static Activity activity;
	private Switch one,two,three; private LinearLayout twoline,threeline; private RelativeLayout oneline; private ImageView close;
	
	public static IconnicToast toasty=new IconnicToast();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		activity = this;
		
		initContent();
	}
	
	private void initContent(){
		one=(Switch)findViewById(R.id.one);
		two=(Switch)findViewById(R.id.two);
		three=(Switch)findViewById(R.id.three);
		oneline=(RelativeLayout)findViewById(R.id.oneline);
		twoline=(LinearLayout)findViewById(R.id.twoline);
		threeline=(LinearLayout)findViewById(R.id.threeline);
		close=(ImageView)findViewById(R.id.close);
		
		close.setOnClickListener(new OnClickListener(){@Override public void onClick(View v){finish();}});
		
		oneline.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){Intent intent = new Intent(SettingsActivity.this,ProfileActivity.class); startActivity(intent);}
		});
		
		twoline.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){toasty.showToast(getApplicationContext(),"TWO LINE",true);}
		});
		
		threeline.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){toasty.showToast(getApplicationContext(),"THREE LINE",true);}
		});
	
		one.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(one.isChecked()){toasty.showToast(getApplicationContext(),"ONE ON",true);}
				else{toasty.showToast(getApplicationContext(),"ONE OFF",true);}
			}
		});
		
		two.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(two.isChecked()){toasty.showToast(getApplicationContext(),"TWO ON",true);}
				else{toasty.showToast(getApplicationContext(),"TWO OFF",true);}
			}
		});
		
		three.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(three.isChecked()){toasty.showToast(getApplicationContext(),"THREE ON",true);}
				else{toasty.showToast(getApplicationContext(),"THREE OFF",true);}
			}
		});
	}

}
