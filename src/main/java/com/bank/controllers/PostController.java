package com.bank.controllers;

import com.bank.dto.PostDTO;
import com.bank.models.Post;
import com.bank.service.PostService;
import com.bank.utils.enums.PostType;
import com.bank.utils.mappers.impl.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/posts")
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping
    public ResponseEntity<Object> getAllPosts(){
        return new ResponseEntity<>(postMapper.toDTOs(postService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<Object> getById(@PathVariable("post_id") Long id){
        return new ResponseEntity<>(postMapper.toDTO(postService.getById(id)), HttpStatus.OK);
    }

    //TODO preauthorized
    @DeleteMapping("/{post_id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("post_id") Long id){
        postService.deleteById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPost(@RequestBody PostDTO postDTO){
        Post post = postMapper.fromDTO(postDTO);
        return new ResponseEntity<>(postMapper.toDTO(postService.save(post)), HttpStatus.CREATED);
    }

    @PatchMapping("/{post_id}/update")
    public ResponseEntity<Object> updatePost(
            @PathVariable("post_id") Long post_id,
            @RequestBody PostDTO postDTO){
        postDTO.setId(post_id);
        Post post = postMapper.fromDTO(postDTO);
        return new ResponseEntity<>(postMapper.toDTO(postService.update(post)), HttpStatus.OK);
    }

    @GetMapping("/events")
    public ResponseEntity<Object> getAllEvents(){
        return new ResponseEntity<>(postMapper.toDTOs(postService.getAllByType(PostType.EVENT)), HttpStatus.OK);
    }

    @GetMapping("/landmarks")
    public ResponseEntity<Object> getAllLandmarks(){
        return new ResponseEntity<>(postMapper.toDTOs(postService.getAllByType(PostType.LANDMARK)), HttpStatus.OK);
    }

}
