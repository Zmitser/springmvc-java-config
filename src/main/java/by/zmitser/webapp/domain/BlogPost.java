package by.zmitser.webapp.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BlogPost {


    private Long id;

    private String title;

    private String content;

    private Date publishDate;

    private Boolean draft;

}
