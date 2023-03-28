package com.myblog.blogapp.service;

import com.myblog.blogapp.payload.PostDto;
import com.myblog.blogapp.payload.PostResponse;

import java.util.List;

public interface PostService {
    public  PostDto createPost(PostDto postDto); //dto take data from api give to entity obj

    PostResponse getAllposts(int pageNo, int pageSize,String sortBy,String sortDir);

    PostDto getPostId(long id);



    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);
}
