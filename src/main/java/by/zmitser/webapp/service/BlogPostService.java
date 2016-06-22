package by.zmitser.webapp.service;

import by.zmitser.webapp.domain.BlogPost;
import by.zmitser.webapp.domain.User;

import java.util.List;


public interface BlogPostService {

    void save(BlogPost blogPost);
    void saveAsDraft(BlogPost blogPost);
    void delete(BlogPost blogPost);
    List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft);
    List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title);
    List<BlogPost> listAllBlogPosts();
    BlogPost findBlogPostById(long id);
}
