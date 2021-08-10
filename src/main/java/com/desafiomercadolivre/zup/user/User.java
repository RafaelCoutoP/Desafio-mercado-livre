package com.desafiomercadolivre.zup.user;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.Instant;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    @Column(unique = true)
    private String login;
    private String password;

    @Deprecated
    public User(){
    }

    public User(String login, String password) {
        moment = Instant.now();
        this.login = login;
        this.password = password;
    }
}