package com.yoga.yoga_tracker_service.Controller;

import com.yoga.yoga_tracker_service.DTO.CommentDTO;
import com.yoga.yoga_tracker_service.DTO.CommunityPostDTO;
import com.yoga.yoga_tracker_service.Service.CommunityService;
import com.yoga.yoga_tracker_service.Utility.AuthenticatedUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community")
public class CommunityController {

    private final CommunityService communityService;

     @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Application is running!";
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CommunityPostDTO>> getAllPosts() {
        List<CommunityPostDTO> posts = communityService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/posts")
    public ResponseEntity<CommunityPostDTO> addNewPost(@RequestBody CommunityPostDTO postDTO) {
        CommunityPostDTO savedPost = communityService.addNewPost(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> addComment(@PathVariable Long postId, @RequestBody CommentDTO commentDTO) {
        Long userId = AuthenticatedUserUtil.getLoggedInUserId();
        commentDTO.setUserId(userId);
        CommentDTO savedComment = communityService.addComment(postId, commentDTO);
        return savedComment != null ? ResponseEntity.status(HttpStatus.CREATED).body(savedComment)
                : ResponseEntity.notFound().build();
    }
}

