package com.iconnic.worktemplate.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.iconnic.worktemplate.R;
import com.iconnic.worktemplate.views.CircleImageView;
import com.iconnic.worktemplate.views.HeaderTextView;
import com.iconnic.worktemplate.views.IconnicTextView;
import com.squareup.picasso.Picasso;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
																																														
public class CardFlat1Adapter extends RecyclerView.Adapter<CardFlat1Adapter.ViewHolder>{
	
	public static Context context; private static int width,height,gridnum,count; private int lastPosition = -1; 
	private static List<String> text3=new ArrayList<String>();
	private static List<String> text2=new ArrayList<String>(); 
	private static List<String> text=new ArrayList<String>(); 
	private static List<String> pic=new ArrayList<String>();  
	
	private String callingactivity; 
	private static final int TYPE_MENU = 2; private static final int TYPE_ITEM2 = 1; private static final int TYPE_ITEM1 = 0;
    
    public static class ViewHolder extends RecyclerView.ViewHolder{
    	CardView cv; ImageView pic; CircleImageView m1,m2,m3,m4,m5,m6,m7,m8; HeaderTextView text; IconnicTextView text2,text3;
        
    	ViewHolder(View itemView,int viewtype){super(itemView);
            if(viewtype==TYPE_MENU){
            	cv = (CardView)itemView.findViewById(R.id.cardflatmenu);
            	m1 = (CircleImageView)cv.findViewById(R.id.menuone);
            	m2 = (CircleImageView)cv.findViewById(R.id.menutwo);
            	m3 = (CircleImageView)cv.findViewById(R.id.menuthree);
            	m4 = (CircleImageView)cv.findViewById(R.id.menufour);
            	m5 = (CircleImageView)cv.findViewById(R.id.menufive);
            	m6 = (CircleImageView)cv.findViewById(R.id.menusix);
            	m7 = (CircleImageView)cv.findViewById(R.id.menuseven);
            	m8 = (CircleImageView)cv.findViewById(R.id.menueight);
            	}
            else if(viewtype==TYPE_ITEM2){
            	cv = (CardView)itemView.findViewById(R.id.cardflat2);
            	//cv.setMinimumWidth(width*gridnum); cv.setMinimumHeight(height);
            	pic = (ImageView)cv.findViewById(R.id.pic); 
                text=(HeaderTextView)cv.findViewById(R.id.text);
                text2=(IconnicTextView)cv.findViewById(R.id.text2);
            	}
            else{
            	cv = (CardView)itemView.findViewById(R.id.cardflat1);
            	//cv.setMinimumWidth(width); cv.setMinimumHeight(height);
            	pic = (ImageView)cv.findViewById(R.id.pic); 
                text=(HeaderTextView)cv.findViewById(R.id.text);
                text2=(IconnicTextView)cv.findViewById(R.id.text2);
            	text3=(IconnicTextView)cv.findViewById(R.id.text3);
            	}
            
        }
    }
    
    public CardFlat1Adapter(List<String> pic, List<String> text, List<String> text2, List<String> text3, int width,int height,String callingactivity,int gridnum, Context context)
    {this.pic=pic; this.text=text; this.text2=text2; this.text3=text3; this.width=width; this.height=height; this.callingactivity=callingactivity; this.gridnum=gridnum; this.context=context;}
    
    @Override public CardFlat1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        switch(viewType){
        case TYPE_ITEM1: View zero = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardflat1, parent, false);
        		ViewHolder vhzero = new ViewHolder(zero,viewType);
        		return vhzero;
        case TYPE_ITEM2: View one = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardflat2, parent, false);
				ViewHolder vhone = new ViewHolder(one,viewType);
				return vhone;
        case TYPE_MENU: View menu = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardflatmenu, parent, false);
				ViewHolder vhmenu = new ViewHolder(menu,viewType);
				return vhmenu;
        default:View def = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardflat1, parent, false);
				ViewHolder vhdef = new ViewHolder(def,viewType);
				return vhdef;
        }
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position){
    	final int place=position; int viewtype=holder.getItemViewType(); 
    	
    	switch(viewtype){
        case TYPE_ITEM1:
        	if(text.get(position)==null){holder.text.setText(context.getResources().getString(R.string.unavailable));}else{holder.text.setText(text.get(position));}
        	
        	if((pic.get(place)==null)){Picasso.with(context).load(R.drawable.ic_launcher).placeholder(R.drawable.profile).into(holder.pic);}
        	else{
        		if(pic.get(place).toString().equalsIgnoreCase(""))
        		{Picasso.with(context).load(R.drawable.placeholder1).placeholder(R.drawable.placeholder1).into(holder.pic);}
        		else{if(pic.get(place)==null||pic.get(place).isEmpty()){Picasso.with(context).load(R.drawable.placeholder1).placeholder(R.drawable.placeholder1).into(holder.pic);}
        		else{Picasso.with(context).load(pic.get(place)).placeholder(R.drawable.placeholder1).into(holder.pic);}}
        		}
        	
        	holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                	Toast.makeText(context, text.get(place)+TYPE_ITEM1, 5000).show();
                	}
            });
        	
        	break;
        case TYPE_ITEM2:
        	if(text.get(position)==null){holder.text.setText(context.getResources().getString(R.string.unavailable));}else{holder.text.setText(text.get(position));}
        	
        	if((pic.get(place)==null)){Picasso.with(context).load(R.drawable.ic_launcher).placeholder(R.drawable.profile).into(holder.pic);}
        	else{
        		if(pic.get(place).toString().equalsIgnoreCase(""))
        		{Picasso.with(context).load(R.drawable.placeholder1).placeholder(R.drawable.placeholder1).into(holder.pic);}
        		else{if(pic.get(place)==null||pic.get(place).isEmpty()){Picasso.with(context).load(R.drawable.placeholder1).placeholder(R.drawable.placeholder1).into(holder.pic);}
        		else{Picasso.with(context).load(pic.get(place)).placeholder(R.drawable.placeholder1).into(holder.pic);}}
        		}
        	
        	holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                	Toast.makeText(context, text.get(place)+TYPE_ITEM2, 5000).show();
                	}
            });
        	
        	break;
        case TYPE_MENU: 
        	
        	Picasso.with(context).load(R.drawable.img1).placeholder(R.drawable.img1).into(holder.m1);
        	Picasso.with(context).load(R.drawable.img1).placeholder(R.drawable.img1).into(holder.m2);
        	Picasso.with(context).load(R.drawable.img1).placeholder(R.drawable.img1).into(holder.m3);
        	Picasso.with(context).load(R.drawable.img1).placeholder(R.drawable.img1).into(holder.m4);
        	Picasso.with(context).load(R.drawable.img1).placeholder(R.drawable.img1).into(holder.m5);
        	Picasso.with(context).load(R.drawable.img1).placeholder(R.drawable.img1).into(holder.m6);
        	Picasso.with(context).load(R.drawable.img1).placeholder(R.drawable.img1).into(holder.m7);
        	Picasso.with(context).load(R.drawable.img1).placeholder(R.drawable.img1).into(holder.m8);
        	
        	holder.m1.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                	Toast.makeText(context, "MENU ITEM 1", 5000).show();
                	}
            });
        	holder.m2.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                	Toast.makeText(context, "MENU ITEM 2", 5000).show();
                	}
            });
        	holder.m3.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                	Toast.makeText(context, "MENU ITEM 3", 5000).show();
                	}
            });
        	holder.m4.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                	Toast.makeText(context, "MENU ITEM 4", 5000).show();
                	}
            });
        	holder.m5.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                	Toast.makeText(context, "MENU ITEM 5", 5000).show();
                	}
            });
        	holder.m6.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                	Toast.makeText(context, "MENU ITEM 6", 5000).show();
                	}
            });
        	holder.m7.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                	Toast.makeText(context, "MENU ITEM 7", 5000).show();
                	}
            });
        	holder.m8.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                	Toast.makeText(context, "MENU ITEM 8", 5000).show();
                	}
            });
        	break;
        }
        
        //Animation animation = AnimationUtils.loadAnimation(context,R.anim.up_from_bottom);
        //holder.itemView.startAnimation(animation);
        //lastPosition = position;
    }

    @Override public int getItemCount(){return text.size();}
    
    @Override public void onViewDetachedFromWindow(ViewHolder holder)
    {super.onViewDetachedFromWindow(holder); holder.itemView.clearAnimation();}
    
    //With the following method we check what type of view is being passed 
    @Override
    public int getItemViewType(int position){if(position==0){return TYPE_MENU;} if((position%5)==0){return TYPE_ITEM2;}else{return TYPE_ITEM1;}}
    
}

