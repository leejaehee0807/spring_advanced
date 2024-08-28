package com.sparta.springexpert.controller;

import com.sparta.springexpert.dto.comment.request.CommentSaveRequestDto;
import com.sparta.springexpert.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.springexpert.dto.comment.response.CommentDetailResponseDto;
import com.sparta.springexpert.dto.comment.response.CommentSaveResponseDto;
import com.sparta.springexpert.dto.comment.response.CommentSimpleResponseDto;
import com.sparta.springexpert.dto.comment.response.CommentUpdateResponseDto;
import com.sparta.springexpert.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public CommentSaveResponseDto saveComment(@RequestBody CommentSaveRequestDto commentSaveRequestDto){
        return commentService.saveComment(commentSaveRequestDto);
    }

    @GetMapping("/comments")
    public List<CommentSimpleResponseDto> getComments(){
        return commentService.getComments();
    }

    @GetMapping("/comments/{commentId}")
    public CommentDetailResponseDto getComment(@PathVariable Long commentId){
        return commentService.getComment(commentId);
    }

    @PutMapping("/comments/{commentId}")
    public CommentUpdateResponseDto updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDto commentUpdateRequestDto){
        return commentService.updateComment(commentId, commentUpdateRequestDto);
    }
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }


}
