package com.desafiomercadolivre.zup.category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CategoryRequest {

    @NotBlank
    private String name;
    @Positive
    private Long idCategoryFather;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdCategoryFather(Long idCategoryFather) {
        this.idCategoryFather = idCategoryFather;
    }

    public Category toModel(CategoryRepository categoryRepository) {
        Category cat = new Category(this.name);
        if(idCategoryFather != null){
            Category categoryFather = categoryRepository.getById(this.idCategoryFather);
            cat.setIdCategoryFather(categoryFather);
        }
        return cat;
    }
}
