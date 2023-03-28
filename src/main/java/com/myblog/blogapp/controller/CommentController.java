package com.myblog.blogapp.controller;

import com.myblog.blogapp.payload.CommentDto;
import com.myblog.blogapp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    //localhost:8080/api/posts/1/comments
    @PostMapping("posts/{postId}/comments")
    public ResponseEntity<Object> createComment(@Valid @PathVariable("postId") long postId, @RequestBody CommentDto commentDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {

            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
       return new ResponseEntity<>(commentService.createComment(postId,commentDto), HttpStatus.CREATED) ;

    }
    //localhost:8080/api/posts/1/comments
    @GetMapping("posts/{postId}/comments")
    public List<CommentDto> getAllCommentsByPostId(@PathVariable("postId") long postId){
        List<CommentDto> dto = commentService.getCommentByPostId(postId);
        return dto;

    }
    //localhost:8080/api/posts/1/comments/2
    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto>updateComment(@PathVariable("postId")long postId,
                                                   @PathVariable("id") long id,
                                                   @RequestBody CommentDto commentDto )
    {
        CommentDto dto = commentService.updateComment(postId, id, commentDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    //localhost:8080/api/posts/2/comments/5
    @DeleteMapping("posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("postId") long postId, @PathVariable("id")long id){
        commentService.deleteComment(postId,id);
        return new ResponseEntity<>("comment is deleted",HttpStatus.OK);
    }
}
