package com.myblog.blogapp.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data

public class PostDto {
    private long id;
    @NotNull(message = "post title should have minimum 2 characte")
    @Size(min=2,message = "post title should have minimum 2 character")
    private String title;
    @NotNull(message = "post description should have minimum 10 character ")
    @Size(min=10,message = "post description should have minimum 10 character ")
    private String description;
    @NotNull
    @NotEmpty
    private String content;
}
