package com.dojo.miyagiOne.blogPost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BlogPostController {

	@GetMapping(value="/blogpost")
	public String index(BlogPost blogPost) {
		return "blogpost/index";
	}
}