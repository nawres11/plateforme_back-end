package com.sg.uib.service;

import com.sg.uib.model.*;
import com.sg.uib.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User userDetails, Long id) {
        User user = userRepository.findById(id).get();
        user.setDateOfBirth(userDetails.getDateOfBirth());
        user.setEmail(userDetails.getEmail());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setGender(userDetails.getGender());
        user.setPassword(userDetails.getPassword());
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }
    @Override
    public List<User> getTypeUsers(String type) {
        
        return userRepository.findUsers(type);
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
    public User getUserByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }
}
