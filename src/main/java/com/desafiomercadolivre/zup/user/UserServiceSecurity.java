package com.desafiomercadolivre.zup.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceSecurity implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceSecurity.class);

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByLogin(s);
        if (user == null){
            logger.error("User não encontrado" + s);
            throw  new UsernameNotFoundException("Email não encontrado");
        }
        logger.info("User encontrado" + s);
        return user;
    }
}