package by.zmitser.webapp.service;

import by.zmitser.webapp.config.WebConfig;
import by.zmitser.webapp.domain.BlogPost;
import by.zmitser.webapp.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class}, loader = AnnotationConfigWebContextLoader.class)
public class BlogPostServiceTest {

    @Autowired
    private BlogPostService service;

    @Autowired UserService userService;

    @Test
    public void save() throws Exception {
        User user = userService.findWithBlogPostsByUsername("user");
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("title 1");
        blogPost.setContent("test content 1");
        blogPost.setUser(user);
        service.save(blogPost);
    }

    @Test
    public void saveAsDraft() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void listAllBlogPostsByUserAndDraftStatus() throws Exception {

    }

    @Test
    public void listAllBlogPostsByUserAndTitleLike() throws Exception {

    }

    @Test
    public void listAllBlogPosts() throws Exception {

    }

    @Test
    public void findBlogPostById() throws Exception {

    }

}