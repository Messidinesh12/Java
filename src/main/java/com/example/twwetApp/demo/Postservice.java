package com.example.twwetApp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.twwetApp.demo.users.User;
import com.example.twwetApp.demo.users.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Postservice {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post createPost(int userId, Post post) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        post.setUser(user);
        return postRepository.save((post));
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    public void deletePostById(Integer id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Post not found");
        }
    }
}
