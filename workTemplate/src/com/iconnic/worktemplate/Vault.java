package com.iconnic.worktemplate;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Util;

/*
 * 
 *Coded by Joseph "Iconnic" Mpyana 2/15/2017 
 * 
 */
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.view.Display;

public class Vault extends Application{	  
	//Exoplayer stuff
		 protected String userAgent;

		  public DataSource.Factory buildDataSourceFactory(DefaultBandwidthMeter bandwidthMeter) {
		    return new DefaultDataSourceFactory(this, bandwidthMeter, buildHttpDataSourceFactory(bandwidthMeter));
		  }

		  public HttpDataSource.Factory buildHttpDataSourceFactory(DefaultBandwidthMeter bandwidthMeter) {
		    return new DefaultHttpDataSourceFactory(userAgent, bandwidthMeter);
		  }
	//other stuff 
	private static final String ICONNIC_PATH = "fonts/iconnic.otf",HEADER_PATH = "fonts/header.otf"; 
	public static Typeface iconnic,header; 
    
	//constructor
    @Override public void onCreate(){super.onCreate(); initTypeface(); initHeaderTypeface(); userAgent = Util.getUserAgent(this, "ExoPlayer");}
  
    //initialise fonts for Custom TextViews
    private void initTypeface(){iconnic = Typeface.createFromAsset(getAssets(), ICONNIC_PATH);}
    private void initHeaderTypeface(){header = Typeface.createFromAsset(getAssets(), HEADER_PATH);}

    //EXTRA
    private static Activity activity; private static Context context; 
    
    public Activity getActivity(){return activity;} public void setActivity(Activity activity){this.activity = activity;}
    
    public Context getContext(){return context;} public void setContext(Context context){this.context = context;}
    
}
