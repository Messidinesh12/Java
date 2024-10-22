package com.example.twwetApp.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(columnDefinition = "UUID")
    private int id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "FK_comment_post"))
    @JsonBackReference
    private Post post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostId() {
        return post != null ? post.getId() : null;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
