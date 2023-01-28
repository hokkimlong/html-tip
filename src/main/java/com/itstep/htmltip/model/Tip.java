package com.itstep.htmltip.model;

public class Tip {

	public int id;
	public String title;
	public String description;
	public String exampleHtmlEscape;
	
	public Tip(int id, String title, String description, String exampleHtmlEscape) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.exampleHtmlEscape = exampleHtmlEscape;
	}
	
	public Tip( String title, String description, String exampleHtmlEscape) {
		super();
		this.title = title;
		this.description = description;
		this.exampleHtmlEscape = exampleHtmlEscape;
	}
	
	

}
