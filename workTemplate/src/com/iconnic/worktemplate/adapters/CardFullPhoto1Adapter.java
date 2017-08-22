package com.iconnic.worktemplate.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.iconnic.worktemplate.ImageActivity;
import com.iconnic.worktemplate.R;
import com.iconnic.worktemplate.UserActivity;
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
																																														
public class CardFullPhoto1Adapter extends RecyclerView.Adapter<CardFullPhoto1Adapter.ViewHolder>{
	
	public static Context context; private static int width,height,gridnum,count; private int lastPosition = -1;  
	private static List<String> pic=new ArrayList<String>();  
	
	private String callingactivity; private static final int TYPE_ITEM2 = 1; private static final int TYPE_ITEM1 = 0;
    
    public static class ViewHolder extends RecyclerView.ViewHolder{
    	CardView cv; ImageView pic,pic2,pic3,pic4; HeaderTextView name; IconnicTextView text;
        
    	ViewHolder(View itemView,int viewtype){super(itemView);
            if(viewtype==TYPE_ITEM2){
            	cv = (CardView)itemView.findViewById(R.id.cardfullphoto1);
            	//cv.setMinimumWidth(width*gridnum); cv.setMinimumHeight(height);
            	}
            else{
            	cv = (CardView)itemView.findViewById(R.id.cardfullphoto1);
            	//cv.setMinimumWidth(width); cv.setMinimumHeight(height);
            	}
            
            pic = (ImageView)cv.findViewById(R.id.pic); 
            pic2 = (ImageView)cv.findViewById(R.id.pic2);
            pic3 = (ImageView)cv.findViewById(R.id.pic3);
            pic4 = (ImageView)cv.findViewById(R.id.pic4);
            name = (HeaderTextView)cv.findViewById(R.id.name);
            text = (IconnicTextView)cv.findViewById(R.id.text);
        }
    }
    
    public CardFullPhoto1Adapter(List<String> pic,int width,int height,String callingactivity,int gridnum, Context context)
    {this.pic=pic; this.width=width; this.height=height; this.callingactivity=callingactivity; this.gridnum=gridnum; this.context=context;}
    
    @Override public CardFullPhoto1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        switch(viewType){
        case TYPE_ITEM1: View zero = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardfullphoto1, parent, false);
        		ViewHolder vhzero = new ViewHolder(zero,viewType);
        		return vhzero;
        case TYPE_ITEM2: View one = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardfullphoto1, parent, false);
				ViewHolder vhone = new ViewHolder(one,viewType);
				return vhone;
        default:View def = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardfullphoto1, parent, false);
				ViewHolder vhdef = new ViewHolder(def,viewType);
				return vhdef;
        }
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position){
    	final int place=position;  
    	    	
    	if((pic.get(place)==null)){Picasso.with(context).load(R.drawable.ic_launcher).placeholder(R.drawable.profile).into(holder.pic);}
    	else{
    		if(pic.get(place).toString().equalsIgnoreCase(""))
    		{Picasso.with(context).load(R.drawable.placeholder1).placeholder(R.drawable.placeholder1).into(holder.pic);}
    		else{if(pic.get(place)==null||pic.get(place).isEmpty()){Picasso.with(context).load(R.drawable.placeholder1).placeholder(R.drawable.placeholder1).into(holder.pic);}
    		else{Picasso.with(context).load(pic.get(place)).placeholder(R.drawable.placeholder1).into(holder.pic);}}
    		}
    	
    	holder.name.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
            	Toast.makeText(context, ""+place, 5000).show();
            	startImage();
            	}
        });
        
        holder.pic.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
            	Toast.makeText(context, ""+place, 5000).show();
            	startImage();
            	}
        });
        
        holder.pic2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
            	Toast.makeText(context, ""+place, 5000).show();
            	startImage();
            	}
        });
        
        holder.pic3.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
            	Toast.makeText(context, "LIKE", 5000).show();
            	}
        });
        
        holder.pic4.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
            	Toast.makeText(context, "COMMENT", 5000).show();
            	}
        });
        
        //Animation animation = AnimationUtils.loadAnimation(context,R.anim.up_from_bottom);
        //holder.itemView.startAnimation(animation);
        //lastPosition = position;
    }

    @Override public int getItemCount(){return pic.size();}
    
    @Override public void onViewDetachedFromWindow(ViewHolder holder)
    {super.onViewDetachedFromWindow(holder); holder.itemView.clearAnimation();}
    
    //With the following method we check what type of view is being passed 
    @Override
    public int getItemViewType(int position){if((position%5)==0){return TYPE_ITEM2;}else{return TYPE_ITEM1;}}
  
    //START IMAGE ACTIVITY
  	private void startImage(){Intent intent = new Intent(context,UserActivity.class); context.startActivity(intent);}
  	
    
}

