package com.iconnic.worktemplate.fragments;

import com.iconnic.worktemplate.MainActivity;
import com.iconnic.worktemplate.R;
import com.iconnic.worktemplate.adapters.OnePageAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class First extends Fragment{
	private static Activity activity; private static View view;
	
	private ViewPager pages; private static OnePageAdapter ft; private TabLayout tabLayout; private final int NUM=3;
	
	@Override
	public View onCreateView(LayoutInflater inflator,ViewGroup container,Bundle savedInstanceState){
		view = inflator.inflate(R.layout.first,container,false);
		activity=MainActivity.activity; 
		
		initcontent();
		
		return view;
	}
	
	private void initcontent(){
		pages = (ViewPager)view.findViewById(R.id.pager);
		tabLayout = (TabLayout)view.findViewById(R.id.tab);
		ft = new OnePageAdapter(getChildFragmentManager());
		
        tabLayout.addTab(tabLayout.newTab().setText("first"));
        tabLayout.addTab(tabLayout.newTab().setText("second"));
        tabLayout.addTab(tabLayout.newTab().setText("third"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        int indy=this.getResources().getColor(R.color.black);
        tabLayout.setSelectedTabIndicatorColor(indy);
      
    	pages.setOffscreenPageLimit(NUM); pages.setAdapter(ft); 
		pages.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
		tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override public void onTabSelected(TabLayout.Tab tab){pages.setCurrentItem(tabLayout.getSelectedTabPosition());}
            @Override public void onTabUnselected(TabLayout.Tab tab){}
            @Override public void onTabReselected(TabLayout.Tab tab){}
        });
	}
	
}