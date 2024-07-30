package it.softwaredoctor.angularproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "blog")
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArticle", nullable = false)
    private Long idArticle;

    @Column(name = "title_article", unique = true)
    private String titleArticle;

    @Column(name = "text_article")
    private String textArticle;

    @Column(name = "tag")
    private String tag;

}
