package it.nextdevs.esercizioPomeridiano.controller;


import it.nextdevs.esercizioPomeridiano.DTO.PostDto;
import it.nextdevs.esercizioPomeridiano.exceptions.AutoreNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.exceptions.BadRequestException;
import it.nextdevs.esercizioPomeridiano.exceptions.PostNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.model.Post;
import it.nextdevs.esercizioPomeridiano.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/api/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvaPost(@RequestBody @Validated PostDto postDto, BindingResult bindingResult) throws AutoreNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s +s2)));
        }
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
    public Post updatePost(@PathVariable int id, @RequestBody @Validated PostDto postDto, BindingResult bindingResult) throws PostNonTrovatoException{
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s +s2)));
        }

        return postService.updatePost(id, postDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public void deletePost(@PathVariable int id) throws PostNonTrovatoException {
        postService.eliminaPost(id);
    }


}
