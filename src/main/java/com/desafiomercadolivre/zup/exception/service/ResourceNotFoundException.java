package com.desafiomercadolivre.zup.exception.service;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException (String msg) {
        super(msg);
    }
}
