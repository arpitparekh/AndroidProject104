package com.arpitparekh.jan12androidproject.gallery_retrofit.pojo;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("per_page")
	private String perPage;

	@SerializedName("total")
	private int total;

	@SerializedName("seed")
	private Object seed;

	@SerializedName("last_page")
	private int lastPage;

	@SerializedName("query")
	private String query;

	@SerializedName("current_page")
	private int currentPage;

	public void setPerPage(String perPage){
		this.perPage = perPage;
	}

	public String getPerPage(){
		return perPage;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setSeed(Object seed){
		this.seed = seed;
	}

	public Object getSeed(){
		return seed;
	}

	public void setLastPage(int lastPage){
		this.lastPage = lastPage;
	}

	public int getLastPage(){
		return lastPage;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getQuery(){
		return query;
	}

	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}

	public int getCurrentPage(){
		return currentPage;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"per_page = '" + perPage + '\'' + 
			",total = '" + total + '\'' + 
			",seed = '" + seed + '\'' + 
			",last_page = '" + lastPage + '\'' + 
			",query = '" + query + '\'' + 
			",current_page = '" + currentPage + '\'' + 
			"}";
		}
}