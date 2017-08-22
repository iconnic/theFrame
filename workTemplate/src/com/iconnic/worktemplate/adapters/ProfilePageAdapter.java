package com.iconnic.worktemplate.adapters;

import com.iconnic.worktemplate.fragments.*;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ProfilePageAdapter extends FragmentStatePagerAdapter {

	public ProfilePageAdapter(FragmentManager fragmentManager){super(fragmentManager);}

	@Override
	public Fragment getItem(int arg0){
		switch (arg0){
		case 0: return new Posts();
		case 1: return new Photos();
		case 2: return new Videos();
		default:
			break;
		}
		return null;
	}

	@Override public int getCount(){return 3;}

}
