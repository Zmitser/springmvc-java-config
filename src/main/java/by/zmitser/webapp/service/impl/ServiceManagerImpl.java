package by.zmitser.webapp.service.impl;

import by.zmitser.webapp.domain.BlogPost;
import by.zmitser.webapp.service.BlogPostService;
import by.zmitser.webapp.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class ServiceManagerImpl implements ServiceManager {

    @Autowired
    @Qualifier("mediumBlogPostService")
    private BlogPostService blogPostService;

    @Override
    public void sendBlogPost(BlogPost blogPost) {
        blogPostService.save(blogPost);
    }
}
