package it.nextdevs.esercizioPomeridiano.service;

import it.nextdevs.esercizioPomeridiano.exceptions.PostNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();

    public List<Post> getAllPosts() {
        return posts;
    }

    public Optional<Post> getPostById(int id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst();
    }

    public String salvaPost(Post post) {
        posts.add(post);
        return "Post salvato con successo e id: " + post.getId();
    }

    public Post updatePost(int id, Post postUpdate) throws PostNonTrovatoException {
        Optional<Post> postOptional = getPostById(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setTitolo(postUpdate.getTitolo());
            post.setContenuto(postUpdate.getContenuto());
            post.setTempoDiLettura(postUpdate.getTempoDiLettura());
            return post;
        } else {
            throw new PostNonTrovatoException("Post non trovato");
        }
    }

    public String eliminaPost(int id) throws PostNonTrovatoException {
        Optional<Post> postOptional = getPostById(id);

        if (postOptional.isPresent()) {
            posts.remove(postOptional.get());
            return "Post eliminato con successo";
        } else {
            throw new PostNonTrovatoException("Post non trovato");
        }
    }

}
