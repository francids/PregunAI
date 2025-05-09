package com.francids.escruta.backend.services;

import com.francids.escruta.backend.dtos.BasicUser;
import com.francids.escruta.backend.entities.User;
import com.francids.escruta.backend.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public BasicUser getCurrentBasicUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User user) {
            BasicUser basicUser = new BasicUser();
            basicUser.setId(user.getId());
            basicUser.setFullName(user.getFullName());
            return basicUser;
        }
        return null;
    }

    public User getCurrentFullUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        } else if (authentication != null && authentication.getName() != null) {
            return userRepository.findByEmail(authentication.getName()).orElse(null);
        }
        return null;
    }
}
