package it.nextdevs.esercizioPomeridiano.contrller;


import it.nextdevs.esercizioPomeridiano.exceptions.AutoreNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.exceptions.PostNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.model.Autore;
import it.nextdevs.esercizioPomeridiano.model.Post;
import it.nextdevs.esercizioPomeridiano.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

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

    @PostMapping("/api/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvaPost(@RequestBody Post post) {
        postService.salvaPost(post);
        return "Post salvato con successo con matricola: " + post.getId();
    }


    @PutMapping("/api/posts/{id}")
    public Post updatePost(@PathVariable int id, @RequestBody Post post) throws PostNonTrovatoException{
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/api/posts/{id}")
    public void deletePost(@PathVariable int id) throws PostNonTrovatoException {
        postService.eliminaPost(id);
    }


}
