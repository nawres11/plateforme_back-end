package com.sg.uib.service;

import com.sg.uib.model.*;
import com.sg.uib.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
@Autowired
    private UserRepository userRepository ;
@Autowired
    private RoleRepository roleRepository ;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder ;

    @Override
    public User saveUser(User user) {
        User us = userRepository.findUsersByEmail(user.getEmail());
        System.out.println("lowwweeellll");
       if(us!=null) throw new RuntimeException("User already exist");
        System.out.println("theeeniiiii");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println("theeeleethhhh");
        userRepository.save(user);
        System.out.println("eeraaabaaaaaa");
        addRoleToUser(user.getEmail(),"USER");
        return user ;

    }

    @Override
    public Role saveRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User loadUserByEmail(String email) {

        return userRepository.findUsersByEmail(email);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        User user = userRepository.findUsersByEmail(email);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);

    }
}
