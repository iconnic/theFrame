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
																																														
public class CardBanner1Adapter extends RecyclerView.Adapter<CardBanner1Adapter.ViewHolder>{
	
	public static Context context; private static int width,height,gridnum,count; private int lastPosition = -1;
	private static List<String> text2=new ArrayList<String>();
	private static List<String> text=new ArrayList<String>(); 
	private static List<String> pic=new ArrayList<String>();  
	
	private String callingactivity; private static final int TYPE_ITEM2 = 1; private static final int TYPE_ITEM1 = 0;
    
    public static class ViewHolder extends RecyclerView.ViewHolder{
    	CardView cv; ImageView pic; CircleImageView pic2; HeaderTextView text; IconnicTextView text2,text3;
        
    	ViewHolder(View itemView,int viewtype){super(itemView);
            if(viewtype==TYPE_ITEM2){
            	cv = (CardView)itemView.findViewById(R.id.cardbanner2);
            	//cv.setMinimumWidth(width*gridnum); cv.setMinimumHeight(height);
            	text3=(IconnicTextView)cv.findViewById(R.id.text3);
            	}
            else{
            	cv = (CardView)itemView.findViewById(R.id.cardbanner1);
            	//cv.setMinimumWidth(width); cv.setMinimumHeight(height);
            	pic2 = (CircleImageView)cv.findViewById(R.id.pic2);
            	}
            
            pic = (ImageView)cv.findViewById(R.id.pic); 
            text=(HeaderTextView)cv.findViewById(R.id.text);
            text2=(IconnicTextView)cv.findViewById(R.id.text2);
        }
    }
    
    public CardBanner1Adapter(List<String> pic, List<String> text, List<String> text2, int width,int height,String callingactivity,int gridnum, Context context)
    {this.pic=pic; this.text=text; this.text2=text2; this.width=width; this.height=height; this.callingactivity=callingactivity; this.gridnum=gridnum; this.context=context;}
    
    @Override public CardBanner1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        switch(viewType){
        case TYPE_ITEM1: View zero = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardbanner1, parent, false);
        		ViewHolder vhzero = new ViewHolder(zero,viewType);
        		return vhzero;
        case TYPE_ITEM2: View one = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardbanner2, parent, false);
				ViewHolder vhone = new ViewHolder(one,viewType);
				return vhone;
        default:View def = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardbanner1, parent, false);
				ViewHolder vhdef = new ViewHolder(def,viewType);
				return vhdef;
        }
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position){
    	final int place=position;  
    	
    	if(text.get(position)==null){holder.text.setText(context.getResources().getString(R.string.unavailable));}else{holder.text.setText(text.get(position));}
    	
    	if((pic.get(place)==null)){Picasso.with(context).load(R.drawable.ic_launcher).placeholder(R.drawable.profile).into(holder.pic);}
    	else{
    		if(pic.get(place).toString().equalsIgnoreCase(""))
    		{Picasso.with(context).load(R.drawable.placeholder1).placeholder(R.drawable.placeholder1).into(holder.pic);}
    		else{if(pic.get(place)==null||pic.get(place).isEmpty()){Picasso.with(context).load(R.drawable.placeholder1).placeholder(R.drawable.placeholder1).into(holder.pic);}
    		else{Picasso.with(context).load(pic.get(place)).placeholder(R.drawable.placeholder1).into(holder.pic);}}
    		}
    	
    	if(holder.pic2!=null){
    		if(pic.get(place)==null||pic.get(place).isEmpty()){Picasso.with(context).load(R.drawable.placeholder1).placeholder(R.drawable.placeholder1).into(holder.pic2);}
    	}
        
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v){
            	Toast.makeText(context, text.get(place), 5000).show();
            	}
        });
        
        //Animation animation = AnimationUtils.loadAnimation(context,R.anim.up_from_bottom);
        //holder.itemView.startAnimation(animation);
        //lastPosition = position;
    }

    @Override public int getItemCount(){return text.size();}
    
    @Override public void onViewDetachedFromWindow(ViewHolder holder)
    {super.onViewDetachedFromWindow(holder); holder.itemView.clearAnimation();}
    
    //With the following method we check what type of view is being passed 
    @Override
    public int getItemViewType(int position){if((position)==0){return TYPE_ITEM1;}if((position%5)==0){return TYPE_ITEM2;}else{return TYPE_ITEM1;}}
    
}

