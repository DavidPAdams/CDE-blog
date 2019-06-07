package com.dojo.miyagiOne.blogPost;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class BlogPostController {
	
	@Autowired
  private BlogPostRepository blogPostRepository;
	private static List<BlogPost> posts = new ArrayList<>();

	@GetMapping(value = "/blogpost")
	public String index(BlogPost blogPost, Model model) {
	  DateFormat dateFormat = new SimpleDateFormat("yyyy-Mmm-dd HHmm");
	  model.addAttribute("serverTime", dateFormat.format(new Date()));
	  model.addAttribute("posts", posts);
	  return "blogpost/windex";
	}
	
	@PostMapping(value = "/blogpost")
	public String create(BlogPost blogPost, Model model) {
	  blogPostRepository.save(blogPost);
	  posts.add(blogPost);
	  model.addAttribute("postId", blogPost.getPostId());
	  model.addAttribute("title", blogPost.getTitle());
	  model.addAttribute("author", blogPost.getAuthor());
	  model.addAttribute("body", blogPost.getBody());
	  return "blogpost/result";
	  }
	
	@GetMapping(value= "/blogpost/new")
  public String newPost(BlogPost blogPost, Model model) {
    model.addAttribute("posts", posts);
	  return "blogpost/new";
	}
	
	public void delete(long id) {
	  for(BlogPost post : posts) {
	    if(post.getPostId() == id) {
	      posts.remove(posts.indexOf(post));
	      break;
	    }
	  }
	}
	
	@RequestMapping(value="/blogpost/{id}", method = RequestMethod.DELETE)
	public RedirectView deleteBlogpostWithId(@PathVariable long id, BlogPost blogpost) {
	  delete(id);
	  blogPostRepository.deleteById(id);
	  return new RedirectView("/blogpost");
	}
	
  public BlogPost updateBlogPost(long id, String title, String author, String body) {
    for(BlogPost post : posts) {
      if(post.getPostId() == id) {
        int postIndex = posts.indexOf(post);
        post.setTitle(title);
        post.setAuthor(author);
        post.setBody(body);
        posts.set(postIndex, post);
        return post;
      }
    }
    return null;
  }	
	
	@PutMapping("/blog/{id}")
	public BlogPost update(@PathVariable String id, @RequestBody Map<String, String> blogPost){
    long postId = Long.parseLong(id);
    String title = blogPost.get("title");
    String author = blogPost.get("author");
    String body = blogPost.get("body");
    return updateBlogPost(postId, title, author, body);
	  }
	  

	
}
