package com.api.report.model;

public class ArticleOutput {
    
	private int articlenum ; 
	private String articlesubject;
	private String articlecontent;
	private String writedate;
	private String viewyn;
	/*ID mapping*/
	private String username;
	private int providernumber;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProvidernumber() {
		return providernumber;
	}
	public void setProvidernumber(int providernumber) {
		this.providernumber = providernumber;
	}
	/*ID mapping*/
	
	
	public int getArticlenum() {
		return articlenum;
	}
	public void setArticlenum(int articlenum) {
		this.articlenum = articlenum;
	}
	public String getArticlesubject() {
		return articlesubject;
	}
	public void setArticlesubject(String articlesubject) {
		this.articlesubject = articlesubject;
	}
	public String getArticlecontent() {
		return articlecontent;
	}
	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getViewyn() {
		return viewyn;
	}
	public void setViewyn(String viewyn) {
		this.viewyn = viewyn;
	}
	
	
	
}
