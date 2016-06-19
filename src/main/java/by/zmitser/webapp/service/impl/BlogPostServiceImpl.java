package by.zmitser.webapp.service.impl;

import by.zmitser.webapp.domain.BlogPost;
import by.zmitser.webapp.domain.DataSource;
import by.zmitser.webapp.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class BlogPostServiceImpl implements BlogPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    @Autowired
    private DataSource source;

    @Override
    public void save(BlogPost blogPost) {

        LOGGER.debug("blah-blah-blah! " + source.getUrl());
        LOGGER.debug("BlogPostServiceImpl: save() method is called!");
    }
}
