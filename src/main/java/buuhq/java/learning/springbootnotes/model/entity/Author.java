package buuhq.java.learning.springbootnotes.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    private String id;
    private String name;
    private String email;
    private String url;
}
