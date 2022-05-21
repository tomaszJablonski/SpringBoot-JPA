package com.jpa.springbootjpa.model;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

//dobra praktyka żeby nazywać tak kolumny jak poniżej
@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(18)
    @Column(name = "DESCRIPYION")
    private String description;
    @Column(name = "PREP_TIME")
    private Integer prepTime;
    @Column(name = "COOK_TIME")
    private Integer cookTime;
    @Column(name = "SERVING")
    private Integer serving;
    @Column(name = "SOURCE")
    private String source;
    @Column(name = "URL")
    private String url;
    @Column(name = "DIRECTIONS", length = 1300)
    private String directions;
    @Column(name = "IMAGE")
    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    //To jest to tworzenie 3 kolumny
    @ManyToMany
    @JoinTable(name = "recipe_category",
    joinColumns = @JoinColumn (name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

}

