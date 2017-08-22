package com.iconnic.worktemplate.adapters;

import java.util.ArrayList;
import java.util.List;

import com.iconnic.worktemplate.MainActivity;
import com.iconnic.worktemplate.R;
import com.iconnic.worktemplate.Vault;
import com.iconnic.worktemplate.views.CircleImageView;
import com.iconnic.worktemplate.views.HeaderTextView;
import com.iconnic.worktemplate.views.IconnicTextView;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NavMenuAdapter extends RecyclerView.Adapter<NavMenuAdapter.ViewHolder> {
	private static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
	private static final int TYPE_ITEM = 1; // IF the view under inflation and population is header or Item
	
	private String name; //profile name
	private int profile; //add to set profile picture image from url
	private static int choice;
	private String[] mNavTitles; 
	private Integer[] mIcons; 

	public static class ViewHolder extends RecyclerView.ViewHolder {
        
		int Holderid; IconnicTextView textView; ImageView imageView,close; CircleImageView profile; HeaderTextView Name; 
        
        public ViewHolder(View itemView,int ViewType){super(itemView);
            if(ViewType == TYPE_ITEM){
                textView = (IconnicTextView) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                
                itemView.setOnClickListener(new View.OnClickListener()
                {@Override public void onClick(View v){
                	MainActivity.setChoice(textView.getText().toString()); 
                	MainActivity.toggleNav();
                }});
                Holderid = 1;                                               
            }
            else{
                Name = (HeaderTextView) itemView.findViewById(R.id.headText);  
                //Name.setOnClickListener(new View.OnClickListener()
                //{@Override public void onClick(View v){MainActivity.setChoice(textView.getText().toString());}});
                profile = (CircleImageView) itemView.findViewById(R.id.headIcon2);
                close=(ImageView)itemView.findViewById(R.id.headIcon);
                close.setOnClickListener(new View.OnClickListener()
                {@Override public void onClick(View v){MainActivity.toggleNav();}});
                Holderid = 0;                                                
         }}    
    }//end view holder

	public NavMenuAdapter(String[] Titles,Integer [] Icons,String Name, int Profile,int choice)
		{mNavTitles=Titles; mIcons=Icons; name = Name; profile = Profile; this.choice=choice;}
	
	@Override public int getItemCount(){return mNavTitles.length+1;}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position){
		 int indy=MainActivity.activity.getResources().getColor(R.color.black);
			if(holder.Holderid ==1)
			{                        
				holder.textView.setText(mNavTitles[position - 1]); holder.imageView.setImageResource(mIcons[position - 1]);
				if(holder.textView.getText().equals(mNavTitles[choice]))
				{holder.textView.setTextColor(MainActivity.activity.getResources().getColor(R.color.black)); holder.textView.setTextSize(12); MainActivity.toggleNav();} 
			}
			else{holder.profile.setImageResource(profile); holder.Name.setText(name);}
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
		if (viewType == TYPE_ITEM){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.navrow,parent,false); 
            ViewHolder vhItem = new ViewHolder(v,viewType); return vhItem;
        } else if(viewType == TYPE_HEADER){
        	View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.navheader,parent,false); 
        	ViewHolder vhHeader = new ViewHolder(v,viewType); return vhHeader;
        }
        return null;
	}
	
	// With the following method we check what type of view is being passed 
    @Override
    public int getItemViewType(int position){if(isPositionHeader(position))return TYPE_HEADER; return TYPE_ITEM;}
    
    private boolean isPositionHeader(int position){return position == 0;}

}
