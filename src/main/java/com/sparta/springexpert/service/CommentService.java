package com.sparta.springexpert.service;

import com.sparta.springexpert.dto.comment.request.CommentSaveRequestDto;
import com.sparta.springexpert.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.springexpert.dto.comment.response.CommentDetailResponseDto;
import com.sparta.springexpert.dto.comment.response.CommentSaveResponseDto;
import com.sparta.springexpert.dto.comment.response.CommentSimpleResponseDto;
import com.sparta.springexpert.dto.comment.response.CommentUpdateResponseDto;
import com.sparta.springexpert.entity.Comment;
import com.sparta.springexpert.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;


    @Transactional
    public CommentSaveResponseDto saveComment(CommentSaveRequestDto commentSaveRequestDto) {
        Comment newComment = new Comment(
                commentSaveRequestDto.getContent(),
                commentSaveRequestDto.getUserName());
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(
                savedComment.getId(),
                savedComment.getContent(),
                savedComment.getUserName());

    }

    public List<CommentSimpleResponseDto> getComments() {
        List<Comment> newComments =commentRepository.findAll();
        List<CommentSimpleResponseDto> commentSimpleResponseDto = new ArrayList<>();

        for (Comment newComment : newComments) {
            commentSimpleResponseDto.add(new CommentSimpleResponseDto(
                    newComment.getContent(),
                    newComment.getUserName()));
        }
        return commentSimpleResponseDto;
    }

    public CommentDetailResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()->new NullPointerException("조회한 댓글이 없습니다."));
        return new CommentDetailResponseDto(
                comment.getId(),
                comment.getContent(),
                comment.getUserName());
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()->new NullPointerException("업데이트할 댓글이 없습니다."));
        comment.update(commentUpdateRequestDto.getContent());

        return new CommentUpdateResponseDto(
                comment.getId(),
                comment.getContent(),
                comment.getUserName());
    }
    @Transactional
    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new NullPointerException("댓글이 없습니다.");
        }
        commentRepository.deleteById(commentId);
    }
}
