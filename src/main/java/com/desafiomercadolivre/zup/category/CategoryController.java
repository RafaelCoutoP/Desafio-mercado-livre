package com.desafiomercadolivre.zup.category;

import com.desafiomercadolivre.zup.validacao.FieldUniqueValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<CategoryRequest> insertCategory(@RequestBody @Valid CategoryRequest request){
        Category category = request.toModel(categoryRepository);
        categoryRepository.save(category);
       return ResponseEntity.ok().build();
    }

    @InitBinder
    public void validated(WebDataBinder binder){
        FieldUniqueValid<CategoryRequest, String> validatedName = new FieldUniqueValid<>("name", CategoryRequest.class, categoryRepository::existsByName);
        binder.addValidators(validatedName);
    }
}