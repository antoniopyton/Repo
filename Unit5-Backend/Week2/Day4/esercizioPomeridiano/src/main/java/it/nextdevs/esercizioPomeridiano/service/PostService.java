package it.nextdevs.esercizioPomeridiano.service;

import com.cloudinary.Cloudinary;
import it.nextdevs.esercizioPomeridiano.DTO.PostDto;
import it.nextdevs.esercizioPomeridiano.exceptions.AutoreNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.exceptions.PostNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.model.Autore;
import it.nextdevs.esercizioPomeridiano.model.Post;
import it.nextdevs.esercizioPomeridiano.repository.AutoreRepository;
import it.nextdevs.esercizioPomeridiano.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    public String salvaPost(PostDto postDto) throws AutoreNonTrovatoException {
        Post post = new Post();
        post.setTitolo(postDto.getTitolo());
        post.setContenuto(postDto.getContenuto());
        post.setTempoDiLettura(postDto.getTempoDiLettura());
        post.setCategoria(postDto.getCategoria());
        post.setCover("https://picsum.photos/200/300");

        Optional<Autore> autoreOptional = autoreRepository.findById(postDto.getAutoreId());

        if (autoreOptional.isPresent()) {
            Autore autore = autoreOptional.get();
            post.setAutore(autore);
            postRepository.save(post);
            return "Post salvato con successo e id: " + post.getId();
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato con id: " + postDto.getAutoreId());
        }

    }

//    public Page<Post> getAllPosts(int page, int size, String sortBy) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//        return postRepository.findAll(pageable);
//    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(int id) {
        return postRepository.findById(id);
    }

    public Post updatePost(int id, PostDto postDto) throws PostNonTrovatoException {
        Optional<Post> postOptional = getPostById(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setTitolo(postDto.getTitolo());
            post.setContenuto(postDto.getContenuto());
            post.setTempoDiLettura(postDto.getTempoDiLettura());
            return postRepository.save(post);

        } else {
            throw new PostNonTrovatoException("Post non trovato con id: " + id);
        }
    }

    public String patchCoverPost(int id, MultipartFile foto) throws IOException, PostNonTrovatoException {
        Optional<Post> postOptional = postRepository.findById(id);

        if (postOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Post post = postOptional.get();
            post.setCover(url);
            postRepository.save(post);
            return "Post aggiornato correttamente e Cover inviata con matricola: " + id;
        } else {
            throw new PostNonTrovatoException("Post non trovato con matricola: " + id);
        }
    }

    public String eliminaPost(int id) throws PostNonTrovatoException {
        Optional<Post> postOptional = getPostById(id);

        if (postOptional.isPresent()) {
            postRepository.delete(postOptional.get());
            return "Post eliminato con successo con id: " + id;
        } else {
            throw new PostNonTrovatoException("Post non trovato con id: " + id);
        }
    }

}
