package com.example.blog_ajax.repository.security;

import com.example.blog_ajax.model.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}
