package com.example.twwetApp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PostController {

    @Autowired
    private Postservice postservice;

    @PostMapping("/createPost/{userId}")
    public Post createPost(@PathVariable int userId, @RequestBody Post post) {
        return postservice.createPost(userId, post);
    }

    @GetMapping("/posts")
    public List<Post> getAllposts() {
        return postservice.getAllPosts();
    }

    @GetMapping("post/{id}")
    public Post getPostById(@PathVariable Integer id) {
        return postservice.getPostById(id);
    }

    @DeleteMapping("deletePost/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postservice.deletePostById(id);
        return ResponseEntity.noContent().build();
    }
}
