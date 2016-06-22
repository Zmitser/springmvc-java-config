package by.zmitser.webapp.dao;

import by.zmitser.webapp.domain.BlogPost;
import by.zmitser.webapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BlogPostDAO extends JpaRepository<BlogPost, Long> {

    List<BlogPost> findAllBlogPostsByUserAndTitleContaining(User user, String title);
    List<BlogPost> findAllBlogPostsByUserAndDraft(User user, boolean draft);
}
