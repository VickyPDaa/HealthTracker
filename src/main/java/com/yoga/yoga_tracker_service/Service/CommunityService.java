package com.yoga.yoga_tracker_service.Service;

import com.yoga.yoga_tracker_service.DTO.CommentDTO;
import com.yoga.yoga_tracker_service.DTO.CommunityPostDTO;
import com.yoga.yoga_tracker_service.Entity.Comment;
import com.yoga.yoga_tracker_service.Entity.CommunityPost;
import com.yoga.yoga_tracker_service.Repository.CommentRepository;
import com.yoga.yoga_tracker_service.Repository.CommunityPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommunityService {
    private final CommunityPostRepository postRepository;
    private final CommentRepository commentRepository;
    @Autowired
    public CommunityService(CommunityPostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public List<CommunityPostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(CommunityPostDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public CommunityPostDTO addNewPost(CommunityPostDTO postDTO) {
        CommunityPost post = new CommunityPost();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setCreatedAt(postDTO.getCreatedAt());

        if (postDTO.getComments() != null && !postDTO.getComments().isEmpty()) {
            CommunityPost finalPost = post;
            List<Comment> comments = postDTO.getComments().stream().map(commentDTO -> {
                Comment comment = new Comment();
                comment.setContent(commentDTO.getContent());
                comment.setUserId(commentDTO.getUserId());
                comment.setCommentedAt(commentDTO.getCommentedAt());
                comment.setPost(finalPost);  // Link comment to the post
                return comment;
            }).collect(Collectors.toList());
            post.setComments(comments);  // Set comments in post
        }

        post = postRepository.save(post);
        return CommunityPostDTO.fromEntity(post);

    }

    public CommentDTO addComment(Long postId, CommentDTO commentDTO) {
        CommunityPost post = postRepository.findById(postId).orElse(null);
        if (post == null) {
            return null;
        }

        Comment comment = new Comment();
        comment.setUserId(commentDTO.getUserId());
        comment.setContent(commentDTO.getContent());
        comment.setCommentedAt(new Date());
        comment.setPost(post);

        comment = commentRepository.save(comment);
        return CommentDTO.fromEntity(comment);
    }
}
