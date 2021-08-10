package com.desafiomercadolivre.zup.category;

import javax.persistence.*;

@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToOne
    private Category idCategoryFather;

    @Deprecated
    public Category(){
    }

    public Category(String name) {
        this.name = name;
    }

    public void setIdCategoryFather(Category idCategoryFather) {
        this.idCategoryFather = idCategoryFather;
    }
}