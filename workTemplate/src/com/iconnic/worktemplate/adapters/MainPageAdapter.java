package com.iconnic.worktemplate.adapters;

import com.iconnic.worktemplate.fragments.*;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MainPageAdapter extends FragmentStatePagerAdapter {
	
	public MainPageAdapter(FragmentManager fm){super(fm);}

	@Override
	public Fragment getItem(int arg0){
		switch (arg0){
		case 0: return new First();
		case 1: return new Second();
		case 2: return new Third();
		case 3: return new Fourth();
		case 4: return new Fifth();
		default: break;
		}return null;
	}

	@Override public int getCount(){return 5;}

}
