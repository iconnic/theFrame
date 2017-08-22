package com.iconnic.worktemplate.models;

import java.io.Serializable;

public class cardround1 implements Serializable{
	String text; String pic;
	
	public cardround1(){}
	
	public cardround1(String pic, String text){
		this.pic = pic; this.text = text;
	}
	
	public String getPic(){return pic;}
	
	public void setPic(String pic){this.pic=pic;}
	
	public String getText(){return text;}
	
	public void setText(String text){this.text=text;}

}
