package com.myblog.blogapp.repository;

import com.myblog.blogapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    //create method for findByPostId cz repositoty by default not giving me
    //this do find all coment based on post id
    //custom method this is called and return type of that List<Comment>
   List<Comment> findByPostId(long postId);
}
