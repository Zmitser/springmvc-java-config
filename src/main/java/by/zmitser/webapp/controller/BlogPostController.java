package by.zmitser.webapp.controller;

import by.zmitser.webapp.domain.BlogPost;
import by.zmitser.webapp.domain.User;
import by.zmitser.webapp.service.BlogPostService;
import by.zmitser.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService service;

    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/save-post", method = RequestMethod.POST)
    public ModelAndView saveBlogPost(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "draft", required = false) boolean draft,
            Locale locale,
            Principal principal
    ) {

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(title);
        blogPost.setContent(content);
        blogPost.setUser(userService.findWithBlogPostsByUsername("user"));
        if (draft) {
            service.saveAsDraft(blogPost);
        } else {
            service.save(blogPost);
        }

        return new ModelAndView("newblogpost", "message", messageSource.getMessage("blogpost.saved", null, locale ));
    }

    @RequestMapping(value = "/blogposts", method = RequestMethod.GET)
    public ModelAndView blogPosts(Principal principal) {
        List<BlogPost> blogPosts = service.listAllBlogPosts();
        return new ModelAndView("blogposts", "blogposts", blogPosts);
    }

    @RequestMapping(value = "/draft-blogposts", method = RequestMethod.GET)
    public ModelAndView draftBlogPosts(Principal principal) {
        User user = userService.findWithBlogPostsByUsername(principal.getName());
        List<BlogPost> draftBlogPosts = service.listAllBlogPostsByUserAndDraftStatus(user, true);
        return new ModelAndView("blogposts", "blogposts", draftBlogPosts);
    }

    @RequestMapping(value = "/search-by-title", method = RequestMethod.POST)
    public ModelAndView draftByTitle(@RequestParam(value = "title") String title, Principal principal) {
        User user = userService.findWithBlogPostsByUsername(principal.getName());
        List<BlogPost> blogPosts = service.listAllBlogPostsByUserAndTitleLike(user, title);
        return new ModelAndView("blogposts", "blogposts", blogPosts);
    }

    @RequestMapping(value = "/get-blogpost-by-id/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody BlogPost blogPostById(@PathVariable(value = "id") long id) {
        return service.findBlogPostById(id);
    }

}
