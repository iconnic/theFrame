package com.iconnic.worktemplate;

import com.iconnic.worktemplate.adapters.ProfilePageAdapter;
import com.iconnic.worktemplate.views.IconnicTextView;
import com.iconnic.worktemplate.views.IconnicToast;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ProfileActivity extends AppCompatActivity {
	public static Activity activity; public static Context context; public static IconnicToast toasty=new IconnicToast();
	
	private TabLayout tabLayout; private static LinearLayout frame; 
	private static ProfilePageAdapter pager; private static ViewPager viewpager;
	
	private IconnicTextView function; private Button edit; private ImageView close;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		activity=this; context=getApplicationContext();
		
		initComponents();
		initTabComponents();
	}
	
	private void initComponents(){
		function=(IconnicTextView)findViewById(R.id.function);
		close=(ImageView)findViewById(R.id.close);
		edit=(Button)findViewById(R.id.edit);
		
		close.setOnClickListener(new OnClickListener(){@Override public void onClick(View v){finish();}});
		
		function.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				toasty.showToast(context,function.getText().toString(),true);
			}});
		
		edit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				toasty.showToast(context,edit.getText().toString(),true);
			}});
	}
	
	private void initTabComponents(){
		frame=(LinearLayout)findViewById(R.id.mainframe);
		tabLayout = (TabLayout)findViewById(R.id.tab_layout);
		viewpager=(ViewPager)findViewById(R.id.pager);
		pager=new ProfilePageAdapter(getSupportFragmentManager());
		
		tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.posts)));
		tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.photos)));
        tabLayout.addTab(tabLayout.newTab().setText(this.getResources().getString(R.string.videos)));
        
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL); int indy=this.getResources().getColor(R.color.black);
        tabLayout.setSelectedTabIndicatorColor(indy);
        
        viewpager.setOffscreenPageLimit(3); viewpager.setAdapter(pager); 
		viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override public void onTabSelected(TabLayout.Tab tab){function.setText("Upload new "+tab.getText()); viewpager.setCurrentItem(tabLayout.getSelectedTabPosition());}
            @Override public void onTabUnselected(TabLayout.Tab tab){}
            @Override public void onTabReselected(TabLayout.Tab tab){}
        });
        function.setText("Upload new "+this.getResources().getString(R.string.posts)); //initialize text on upload button
	}	

}
