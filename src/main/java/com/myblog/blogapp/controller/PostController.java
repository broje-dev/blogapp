package com.myblog.blogapp.controller;

import com.myblog.blogapp.payload.PostDto;
import com.myblog.blogapp.payload.PostResponse;
import com.myblog.blogapp.service.PostService;
import com.myblog.blogapp.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    //http://localhost:8080/api/posts
    private PostService postService;
    //controller interact with service layer cz postman request came here
    public PostController(PostService postService) { //same as @autowired
        this.postService = postService;
    }
    //whhen i use postman json object store in postdto and method also return dto object
    //how//
@PreAuthorize("hasRole('ADMIN')")
    @PostMapping

    public ResponseEntity<Object> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {

            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
      return new  ResponseEntity <>(postService.createPost(postDto) ,HttpStatus.CREATED);//status code 201
    }
    //get all record by pagination concept//i want per page 10 record
    //http://localhost:8080/api/posts?pageNo=0&pageSize=10

    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value="pageNo",defaultValue= AppConstants.DEFAULT_PAGE_NUMBER,required=false)int pageNo,
            @RequestParam(value="pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false)int pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false) String sortBy,
            @RequestParam(value="sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIR ,required = false) String sortDir
            )
    {
        return postService.getAllposts(pageNo,pageSize,sortBy,sortDir);

    }
    //getbyid and give return type response entity
    //http://localhost:8080/api/posts/1
    @GetMapping ("/{id}")
    public ResponseEntity<PostDto> grtPostById(@PathVariable("id")long id){

        return ResponseEntity.ok(postService.getPostId(id)) ;//give response id 200 ok
    }
    //update
    @PutMapping("/{id}")//for updating u need unique id
    public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@PathVariable("id") long  id){
        PostDto dto = postService.updatePost(postDto, id);
        return  new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteost(@PathVariable("id")long id){
        postService.deletePost(id);
        return new ResponseEntity<>("post entity deleted succesfully",HttpStatus.OK);

    }


}
