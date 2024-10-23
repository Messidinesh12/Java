package com.example.twwetApp.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentService {
    @Autowired
    private Commentrepository commentrepository;

    @Autowired
    private PostRepository postRepository;

    public Comment createComment(int postId, Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        comment.setPost(post);
        // comment.setPost(post);
        return commentrepository.save((comment));
    }

    public List<Comment> getAllComments() {
        return commentrepository.findAll();
    }

    public Comment getCommentById(Integer id) {
        return commentrepository.findById(id).orElse(null);
    }

    public void deleteComentById(Integer id) {
        if (commentrepository.existsById(id)) {
            commentrepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Comment not found");
        }
    }
}
