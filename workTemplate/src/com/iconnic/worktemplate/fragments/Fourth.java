package com.iconnic.worktemplate.fragments;

import java.util.ArrayList;
import java.util.List;

import com.iconnic.worktemplate.MainActivity;
import com.iconnic.worktemplate.R;
import com.iconnic.worktemplate.adapters.CardFullPhoto1Adapter;
import com.iconnic.worktemplate.adapters.CardPhoto1Adapter;
import com.iconnic.worktemplate.others.NpaGridLayoutManager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fourth extends Fragment{
	private static Activity activity; private static Context context; private static View view;
	 
	private static List<String> pic=new ArrayList<String>();
	
	private static RecyclerView recycler; public static RecyclerView.Adapter adapter; 
	private static SwipeRefreshLayout swiperefresh;
	final static int gridnum=1;
	
	@Override
	public View onCreateView(LayoutInflater inflator,ViewGroup container,Bundle savedInstanceState){
		view = inflator.inflate(R.layout.fourth,container,false);
		activity=MainActivity.activity; context=MainActivity.context;  
		
		clear();
		fakeData();
		initOthers();
		initcontent();
		initRecycler();
		
		return view;
	}
	
private void clear(){pic.clear();}
	
	private void initcontent(){}
	
	private void initOthers(){
		swiperefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);  
        swiperefresh.setColorSchemeResources(R.color.black,R.color.view);        
        swiperefresh.setOnRefreshListener(new OnRefreshListener(){@Override public void onRefresh(){refreshByPull();}});
	}
	
	private void refreshByPull(){clear(); fakeData(); refreshRecyclerAll(); swiperefresh.setRefreshing(false);}
	
	public void initRecycler(){	
		double viewwidth=((float)(MainActivity.thewidth))/gridnum; int thewidth=(int) viewwidth;
		double viewheight=((float)(MainActivity.theheight))/gridnum; int theheight=(int) viewheight;
			
		recycler=(RecyclerView)view.findViewById(R.id.recycler); 
        final NpaGridLayoutManager mLayoutManager = new NpaGridLayoutManager(getActivity(),gridnum);
        recycler.setLayoutManager(mLayoutManager); recycler.setHasFixedSize(true);
                
        adapter = new CardFullPhoto1Adapter(pic,thewidth,theheight,"Photos",gridnum,context); recycler.setAdapter(adapter);
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener(){
        	@Override public void onScrollStateChanged(RecyclerView recyclerView, int newState){super.onScrollStateChanged(recyclerView, newState);}
        	
        	@Override
        	public void onScrolled(RecyclerView recyclerView, int dx, int dy){super.onScrolled(recyclerView, dx, dy);
        		//if(!loading && mLayoutManager.getItemCount()-visibleThreshold<=mLayoutManager.findLastVisibleItemPosition()){
        			//loading=true; if(done==true){return;} currentposition=mLayoutManager.findFirstCompletelyVisibleItemPosition();
        			//dontload=0; loadMoreData();
        			//}
        	}
        });
	}
	
	private static void refreshRecyclerAll(){
		double viewwidth=((float)(MainActivity.thewidth))/gridnum; int thewidth=(int) viewwidth;
		double viewheight=((float)(MainActivity.theheight))/gridnum; int theheight=(int) viewheight;
		
		adapter = new CardFullPhoto1Adapter(pic,thewidth,theheight,"Photos",gridnum,context);
        recycler.setAdapter(adapter); adapter.notifyDataSetChanged();
    }
    
    private void refreshRecycler(){adapter.notifyItemRangeInserted(adapter.getItemCount(), pic.size() - 1);}
	
	private void fakeData(){
		for(int i=0;i<MainActivity.temptext.length;i++){
			pic.add("Picture "+MainActivity.temppic[i]); 
		}
	}
	
}