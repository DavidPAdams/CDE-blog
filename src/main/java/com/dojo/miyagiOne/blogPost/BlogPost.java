package com.dojo.miyagiOne.blogPost;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long postId;
	private String title;
	private String author;
	private String body;
	
	public BlogPost(){};

	public BlogPost(String title, String author, String body)
	{
		this.title = title;
		this.author = author;
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getPostId() {
		return postId;
	}

	@Override
	public String toString() {
		return "BlogPost [postId=" + postId + ", title=" + title + ", author=" + author + ", body=" + body + "]";
	}
	
}
