package com.example.demo.model;

public class Suser_ville {
	private long count ;
	private String gouvernerat;
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getGouvernerat() {
		return gouvernerat;
	}
	public void setGouvernerat(String gouvernerat) {
		this.gouvernerat = gouvernerat;
	}
	public Suser_ville(long count, String gouvernerat) {
		super();
		this.count = count;
		this.gouvernerat = gouvernerat;
	}
	
	

}
