package com.desafiomercadolivre.zup.validacao;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.reflect.Field;
import java.util.function.Function;

@Component
public class FieldUniqueValid<T, P> implements Validator {

    private String field;
    private Class<? extends T> classForValid;
    private Function<P, Boolean> bankAccess;

    public FieldUniqueValid(){
    }

    public FieldUniqueValid(String field, Class<? extends T> classForValid, Function<P, Boolean> bankAccess) {
        this.field = field;
        this.classForValid = classForValid;
        this.bankAccess = bankAccess;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return this.classForValid.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        try{
            Field declaredField = classForValid.getDeclaredField(this.field);
            declaredField.setAccessible(true);
            Object objectToSearched = declaredField.get(o);
            Boolean existName = bankAccess.apply((P) objectToSearched);

                if (existName){
                    errors.rejectValue(field, "fieldUnique", "O campo deve ser unico");
                }

        }catch (IllegalAccessException | NoSuchFieldException e){
            e.printStackTrace();
        }
    }
}
