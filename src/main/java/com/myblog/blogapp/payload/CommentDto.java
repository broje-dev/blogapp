package com.myblog.blogapp.payload;

import com.myblog.blogapp.entities.Post;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
public class CommentDto {

    private long id;

    private String body;
    private String email;

    @Size(min=3, message = "name 3+")
    private String name;

}
