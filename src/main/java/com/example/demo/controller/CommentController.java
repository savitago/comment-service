package com.example.demo.controller;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.CommentRequest;
import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping()
    public ResponseEntity<List<Comment>> getComments(@PathVariable("postId") String postId){
        return new ResponseEntity<>(commentService.getComments(postId), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<CommentDto> createComment(@PathVariable("postId") String postId,@Valid @RequestBody CommentRequest commentRequest){
        return new ResponseEntity<>(commentService.createComment(postId,commentRequest), HttpStatus.CREATED);
    }
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable("postId") String postId,@PathVariable("commentId") String commentId,@Valid @RequestBody CommentRequest commentRequest){
        return new ResponseEntity<>(commentService.updateComment(postId,commentRequest,commentId), HttpStatus.OK);
    }



    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getCommentDetails(@PathVariable("postId") String postId, @PathVariable("commentId") String commentId){
        return new ResponseEntity<>(commentService.getCommentDetails(postId,commentId), HttpStatus.OK);
    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable("postId") String postId,@PathVariable("commentId") String commentId){
        return new ResponseEntity<>(commentService.deleteComment(postId,commentId), HttpStatus.OK);
    }
    @GetMapping("/count")
    public Integer getCommentsCount(@PathVariable("postId") String postId){
        return commentService.getCommentsCount(postId);
    }

}