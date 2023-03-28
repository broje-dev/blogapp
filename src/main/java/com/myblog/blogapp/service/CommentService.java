package com.myblog.blogapp.service;

import com.myblog.blogapp.payload.CommentDto;

import java.util.List;

public interface CommentService {
    //post comment
    CommentDto createComment(long postId,CommentDto commentdto);
    List<CommentDto> getCommentByPostId(long postId);

    CommentDto updateComment(long postId, long id, CommentDto commentDto);

    void deleteComment(long postId, long id);
}
