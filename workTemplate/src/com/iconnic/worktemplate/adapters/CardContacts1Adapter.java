package com.iconnic.worktemplate.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;
import com.iconnic.worktemplate.R;
import com.iconnic.worktemplate.UserActivity;
import com.iconnic.worktemplate.views.CircleImageView;
import com.iconnic.worktemplate.views.HeaderTextView;
import com.iconnic.worktemplate.views.IconnicTextView;
import com.squareup.picasso.Picasso;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.Intent;
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
																								//FAST SCROLL
public class CardContacts1Adapter extends RecyclerView.Adapter<CardContacts1Adapter.ViewHolder>implements SectionTitleProvider{
	
	public static Context context; private static int width,height,gridnum,count; private int lastPosition = -1; 
	private static List<String> text3=new ArrayList<String>();
	private static List<String> text2=new ArrayList<String>(); 
	private static List<String> text=new ArrayList<String>(); 
	private static List<String> pic=new ArrayList<String>();  
	
	private String callingactivity; 
	private static final int TYPE_ITEM2 = 1; private static final int TYPE_ITEM1 = 0;
    
    public static class ViewHolder extends RecyclerView.ViewHolder{
    	CardView cv; ImageView pic; HeaderTextView text; IconnicTextView text2,text3;
        
    	ViewHolder(View itemView,int viewtype){super(itemView);
          	if(viewtype==TYPE_ITEM2){
            	cv = (CardView)itemView.findViewById(R.id.cardcontact1);
            	//cv.setMinimumWidth(width*gridnum); cv.setMinimumHeight(height);
            	pic = (ImageView)cv.findViewById(R.id.pic); 
                text=(HeaderTextView)cv.findViewById(R.id.text);
                text2=(IconnicTextView)cv.findViewById(R.id.text2);
                text3=(IconnicTextView)cv.findViewById(R.id.text3);
            	}
            else{
            	cv = (CardView)itemView.findViewById(R.id.cardcontact1);
            	//cv.setMinimumWidth(width); cv.setMinimumHeight(height);
            	pic = (ImageView)cv.findViewById(R.id.pic); 
                text=(HeaderTextView)cv.findViewById(R.id.text);
                text2=(IconnicTextView)cv.findViewById(R.id.text2);
            	text3=(IconnicTextView)cv.findViewById(R.id.text3);
            	}
            
        }
    }
    
    public CardContacts1Adapter(List<String> pic, List<String> text, List<String> text2, List<String> text3, int width,int height,String callingactivity,int gridnum, Context context)
    {this.pic=pic; this.text=text; this.text2=text2; this.text3=text3; this.width=width; this.height=height; this.callingactivity=callingactivity; this.gridnum=gridnum; this.context=context;}
    
    @Override public CardContacts1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        switch(viewType){
        case TYPE_ITEM1: View zero = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardcontact1, parent, false);
        		ViewHolder vhzero = new ViewHolder(zero,viewType);
        		return vhzero;
        case TYPE_ITEM2: View one = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardcontact1, parent, false);
				ViewHolder vhone = new ViewHolder(one,viewType);
				return vhone;
        default:View def = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardcontact1, parent, false);
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
                	startProfile();
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
                	startProfile();
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
    public int getItemViewType(int position){if(position==0){} if((position%5)==0){return TYPE_ITEM2;}else{return TYPE_ITEM1;}}
    
    //FAST SCROLL
    private String getNames(int position) {return text.get(position);}
    //FAST SCROLL
	@Override public String getSectionTitle(int position){return getNames(position).substring(0, 1);}
	
	//START USER PROFILE
	private void startProfile(){Intent intent = new Intent(context,UserActivity.class); context.startActivity(intent);}
	
}

