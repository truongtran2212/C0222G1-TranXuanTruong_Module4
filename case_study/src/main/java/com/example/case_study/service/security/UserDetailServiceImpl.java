package com.example.case_study.service.security;

import com.example.case_study.model.employee.UserApp;
import com.example.case_study.repository.employee.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //Tìm đối tượng đang đăng nhập trong DB
        UserApp userApp = this.userRepository.findByUserName(userName);

        if (userApp == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        List<GrantedAuthority> grantList = new ArrayList<>();
        // ROLE_USER, ROLE_ADMIN,..
        GrantedAuthority authority = new SimpleGrantedAuthority("Admin");
        grantList.add(authority);
        UserDetails userDetails = new User(userApp.getUserName(), userApp.getPassword(), grantList);

        return userDetails;
    }
}



