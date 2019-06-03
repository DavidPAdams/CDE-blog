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
	private String name;
	private String author;
	private String body;
	
	public BlogPost(){};

	public BlogPost(String name, String author, String body)
	{
		this.name = name;
		this.author = author;
		this.body = body;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "BlogPost [postId=" + postId + ", name=" + name
						+ ", author=" + author + ", body=" + body + "]";
	}
	
}
