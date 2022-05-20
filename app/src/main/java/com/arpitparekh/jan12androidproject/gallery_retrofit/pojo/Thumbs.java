package com.arpitparekh.jan12androidproject.gallery_retrofit.pojo;

import com.google.gson.annotations.SerializedName;

public class Thumbs{

	@SerializedName("small")
	private String small;

	@SerializedName("original")
	private String original;

	@SerializedName("large")
	private String large;

	public void setSmall(String small){
		this.small = small;
	}

	public String getSmall(){
		return small;
	}

	public void setOriginal(String original){
		this.original = original;
	}

	public String getOriginal(){
		return original;
	}

	public void setLarge(String large){
		this.large = large;
	}

	public String getLarge(){
		return large;
	}

	@Override
 	public String toString(){
		return 
			"Thumbs{" + 
			"small = '" + small + '\'' + 
			",original = '" + original + '\'' + 
			",large = '" + large + '\'' + 
			"}";
		}
}