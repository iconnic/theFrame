package com.iconnic.worktemplate.adapters;

import com.iconnic.worktemplate.fragments.*;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class OnePageAdapter extends FragmentStatePagerAdapter {
	
	public OnePageAdapter(FragmentManager fm){super(fm);}

	@Override
	public Fragment getItem(int arg0){
		switch (arg0){
		case 0: return new FirstONE();
		case 1: return new FirstTWO();
		case 2: return new FirstTHREE();
		default: break;
		}return null;
	}

	@Override public int getCount(){return 3;}

}
