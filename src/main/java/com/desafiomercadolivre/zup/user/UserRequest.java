package com.desafiomercadolivre.zup.user;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRequest {

    @NotBlank @NotNull
    private String login;
    @Length(min = 6)
    @NotBlank @NotNull
    private String password;

    public UserRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User toModel() {
        return new User(this.login, this.password = new BCryptPasswordEncoder().encode(password));
    }
}