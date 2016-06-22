package by.zmitser.webapp.service.impl;

import by.zmitser.webapp.dao.BlogPostDAO;
import by.zmitser.webapp.domain.BlogPost;
import by.zmitser.webapp.domain.User;
import by.zmitser.webapp.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class BlogPostServiceImpl implements BlogPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);


    @Autowired
    private BlogPostDAO blogPostDAO;

    @Override
    public void save(BlogPost blogPost) {

        blogPost.setPublishDate(new Date());
        blogPost.setDraft(false);
        blogPostDAO.save(blogPost);
        LOGGER.debug("BlogPostServiceImpl: save() method is called!");
    }

    @Override
    public void saveAsDraft(BlogPost blogPost) {
        blogPost.setPublishDate(new Date());
        blogPost.setDraft(true);
        blogPostDAO.save(blogPost);
    }

    @Override
    public void delete(BlogPost blogPost) {
        blogPostDAO.delete(blogPost);
    }

    @Override
    public List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft) {
        return blogPostDAO.findAllBlogPostsByUserAndDraft(user, draft);
    }

    @Override
    public List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title) {
        return blogPostDAO.findAllBlogPostsByUserAndTitleContaining(user, title);
    }

    @Override
    public List<BlogPost> listAllBlogPosts() {
        return blogPostDAO.findAll();
    }

    @Override
    public BlogPost findBlogPostById(long id) {
        return blogPostDAO.findOne(id);
    }
}
