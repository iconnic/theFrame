package com.iconnic.worktemplate;

import com.iconnic.worktemplate.adapters.MainPageAdapter;
import com.iconnic.worktemplate.adapters.NavMenuAdapter;
import com.iconnic.worktemplate.views.HeaderTextView;
import com.iconnic.worktemplate.views.IconnicToast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
	public static Activity activity; public static Context context;
	
	private static ImageView left,right; private static HeaderTextView title; private int NUM=5; long backbtn;
	
	private static ViewPager pages; private static MainPageAdapter ft; private static TabLayout tabLayout;
	private static LinearLayout frame; 
	
	private static RecyclerView mRecycler; private static RecyclerView.LayoutManager mLayoutManager; private static DrawerLayout Drawer; 
	private static ActionBarDrawerToggle mDrawerToggle; private static RecyclerView.Adapter mAdapter; private Toolbar toolbar;
	
	private static String NAME="Iconnic User"; private static int PROFILE=R.drawable.img1; private static int choice=0;
	
	private static String[] tabs={"One","Two","Three","Four","Five"};
	private static String[] menunames={"Option One","Option Two","Option Three","Option Four","Option Five","Option Six","About Us"};
	private static Integer[] menuicons={R.drawable.settings,R.drawable.settings,R.drawable.settings,R.drawable.settings,R.drawable.settings,R.drawable.settings,R.drawable.settings};

	public static int theheight,thewidth;
	
	public static IconnicToast toasty=new IconnicToast();
	
	public static String[] temptext={"one","two","three","four","five","six"};
	public static String[] temppic={"one","two","three","four","five","six"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		activity=this; context=getApplicationContext();
		
		theLengths();
		initToolbar();
		initPages();
		initNavMenu();
	}
	
	public static void theLengths(){
		Display display = activity.getWindowManager().getDefaultDisplay();
		int width = display.getWidth();	int height=display.getHeight();
		theheight=height; thewidth=width;
	}
	
	private void initToolbar(){
		title=(HeaderTextView)findViewById(R.id.title);
		left=(ImageView)findViewById(R.id.left); left.setBackgroundResource(R.drawable.menu);
		right=(ImageView)findViewById(R.id.right); right.setBackgroundResource(R.drawable.settings);
		
		left.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View v){left();}});
		right.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View v){right();}});
	}
	
	private void initPages(){
		pages = (ViewPager)findViewById(R.id.pager);
		tabLayout = (TabLayout)findViewById(R.id.tab_layout);
		ft = new MainPageAdapter(getSupportFragmentManager());
		
        for(int i=0;i<tabs.length;i++){tabLayout.addTab(tabLayout.newTab().setText(tabs[i]));}
        
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        int indy=this.getResources().getColor(R.color.black);
        tabLayout.setSelectedTabIndicatorColor(indy);
      
    	pages.setOffscreenPageLimit(NUM); pages.setAdapter(ft); 
		pages.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
		tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override public void onTabSelected(TabLayout.Tab tab)
            {int pos=tab.getPosition(); pages.setCurrentItem(tabLayout.getSelectedTabPosition());}
            @Override public void onTabUnselected(TabLayout.Tab tab){int pos=tab.getPosition();}
            @Override public void onTabReselected(TabLayout.Tab tab){}
        });
	}
	
	private void initNavMenu(){
		toolbar = (Toolbar) findViewById(R.id.toolbar); setSupportActionBar(toolbar);
		frame=(LinearLayout)findViewById(R.id.mainframe);
		mRecycler = (RecyclerView)findViewById(R.id.RecyclerView);
		Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
		mAdapter = new NavMenuAdapter(menunames,menuicons,NAME,PROFILE,choice);
		mRecycler.setAdapter(mAdapter); mLayoutManager = new LinearLayoutManager(this); mRecycler.setLayoutManager(mLayoutManager);
		mAdapter.notifyDataSetChanged();
		
		float setme=thewidth*0.75f;
		
	    DrawerLayout.LayoutParams dl = new DrawerLayout.LayoutParams((int)setme, LinearLayout.LayoutParams.MATCH_PARENT);
	    dl.gravity=Gravity.LEFT;
	    mRecycler.setLayoutParams(dl);
	    mRecycler.setHasFixedSize(true);
	    
	    mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,R.string.openDrawer,R.string.closeDrawer)
	    {
            @Override public void onDrawerOpened(View drawerView){super.onDrawerOpened(drawerView);}
            @Override public void onDrawerClosed(View drawerView){super.onDrawerClosed(drawerView);}
	    };Drawer.setDrawerListener(mDrawerToggle); mDrawerToggle.syncState();    
	    
	    toggleNav();
	}
	
	public static void setChoice(String name){
		for(int i=0;i<menunames.length;i++){if(menunames[i].equalsIgnoreCase(name)){choice=i; reloadNavMenu();}}
	}
	
	private static void reloadNavMenu(){mAdapter = new NavMenuAdapter(menunames,menuicons,NAME,PROFILE,choice); mRecycler.setAdapter(mAdapter); mAdapter.notifyDataSetChanged();}
	
	//toasty.showToast(context,MainActivity.activity.getResources().getString(R.string.pleaselogin),true);
	
	private void left(){toggleNav();}
	
	private void right(){Intent intent = new Intent(MainActivity.this,SettingsActivity.class); startActivity(intent);}
	
	public static void toggleNav(){if(Drawer.isDrawerOpen(Gravity.LEFT)){Drawer.closeDrawer(Gravity.LEFT);}else{Drawer.openDrawer(Gravity.LEFT);}}

	@Override public void onBackPressed(){if(backbtn+2000>System.currentTimeMillis())super.onBackPressed(); else toasty=new IconnicToast(); toasty.showToast(this,MainActivity.activity.getResources().getString(R.string.backpress),true); backbtn=System.currentTimeMillis();}
}
