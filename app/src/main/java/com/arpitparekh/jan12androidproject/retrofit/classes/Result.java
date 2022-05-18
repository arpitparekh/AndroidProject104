package com.arpitparekh.jan12androidproject.retrofit.classes;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"Result{" + 
			"results = '" + results + '\'' + 
			"}";
		}
}