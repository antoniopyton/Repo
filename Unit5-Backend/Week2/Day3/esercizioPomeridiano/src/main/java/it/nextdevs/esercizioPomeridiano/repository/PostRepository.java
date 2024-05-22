package it.nextdevs.esercizioPomeridiano.repository;

import it.nextdevs.esercizioPomeridiano.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
