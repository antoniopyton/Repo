package it.nextdevs.esercizioPomeridiano.controller;


import it.nextdevs.esercizioPomeridiano.DTO.PostDto;
import it.nextdevs.esercizioPomeridiano.exceptions.AutoreNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.exceptions.PostNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.model.Post;
import it.nextdevs.esercizioPomeridiano.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/api/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvaPost(@RequestBody PostDto postDto) throws AutoreNonTrovatoException {
        return postService.salvaPost(postDto);
    }

//    @GetMapping("/api/posts")
//    public Page<Post> getAllPosts(@RequestParam(defaultValue = "0") int page,
//                                  @RequestParam(defaultValue = "15") int size,
//                                  @RequestParam(defaultValue = "id") String sortBy) {
//        return postService.getAllPosts(page, size, sortBy);
//    }


    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/api/posts/{id}")
    public Post getPostById(@PathVariable int id) throws PostNonTrovatoException {
        Optional<Post> postOptional = postService.getPostById(id);

        if(postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new PostNonTrovatoException("Post non trovato con l'id: " + id);
        }
    }

    @PutMapping("/api/posts/{id}")
    public Post updatePost(@PathVariable int id, @RequestBody PostDto postDto) throws PostNonTrovatoException{
        return postService.updatePost(id, postDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public void deletePost(@PathVariable int id) throws PostNonTrovatoException {
        postService.eliminaPost(id);
    }


}
