package com.arpitparekh.jan12androidproject.gallery_retrofit.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("favorites")
	private int favorites;

	@SerializedName("purity")
	private String purity;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("dimension_x")
	private int dimensionX;

	@SerializedName("source")
	private String source;

	@SerializedName("resolution")
	private String resolution;

	@SerializedName("url")
	private String url;

	@SerializedName("file_size")
	private int fileSize;

	@SerializedName("colors")
	private List<String> colors;

	@SerializedName("short_url")
	private String shortUrl;

	@SerializedName("path")
	private String path;

	@SerializedName("dimension_y")
	private int dimensionY;

	@SerializedName("file_type")
	private String fileType;

	@SerializedName("id")
	private String id;

	@SerializedName("category")
	private String category;

	@SerializedName("views")
	private int views;

	@SerializedName("ratio")
	private String ratio;

	@SerializedName("thumbs")
	private Thumbs thumbs;

	public void setFavorites(int favorites){
		this.favorites = favorites;
	}

	public int getFavorites(){
		return favorites;
	}

	public void setPurity(String purity){
		this.purity = purity;
	}

	public String getPurity(){
		return purity;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDimensionX(int dimensionX){
		this.dimensionX = dimensionX;
	}

	public int getDimensionX(){
		return dimensionX;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setResolution(String resolution){
		this.resolution = resolution;
	}

	public String getResolution(){
		return resolution;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setFileSize(int fileSize){
		this.fileSize = fileSize;
	}

	public int getFileSize(){
		return fileSize;
	}

	public void setColors(List<String> colors){
		this.colors = colors;
	}

	public List<String> getColors(){
		return colors;
	}

	public void setShortUrl(String shortUrl){
		this.shortUrl = shortUrl;
	}

	public String getShortUrl(){
		return shortUrl;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setDimensionY(int dimensionY){
		this.dimensionY = dimensionY;
	}

	public int getDimensionY(){
		return dimensionY;
	}

	public void setFileType(String fileType){
		this.fileType = fileType;
	}

	public String getFileType(){
		return fileType;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setViews(int views){
		this.views = views;
	}

	public int getViews(){
		return views;
	}

	public void setRatio(String ratio){
		this.ratio = ratio;
	}

	public String getRatio(){
		return ratio;
	}

	public void setThumbs(Thumbs thumbs){
		this.thumbs = thumbs;
	}

	public Thumbs getThumbs(){
		return thumbs;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"favorites = '" + favorites + '\'' + 
			",purity = '" + purity + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",dimension_x = '" + dimensionX + '\'' + 
			",source = '" + source + '\'' + 
			",resolution = '" + resolution + '\'' + 
			",url = '" + url + '\'' + 
			",file_size = '" + fileSize + '\'' + 
			",colors = '" + colors + '\'' + 
			",short_url = '" + shortUrl + '\'' + 
			",path = '" + path + '\'' + 
			",dimension_y = '" + dimensionY + '\'' + 
			",file_type = '" + fileType + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",views = '" + views + '\'' + 
			",ratio = '" + ratio + '\'' + 
			",thumbs = '" + thumbs + '\'' + 
			"}";
		}
}