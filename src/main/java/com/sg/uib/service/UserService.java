package com.sg.uib.service;

import com.sg.uib.model.*;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void updateUser(User user, Long id);
    public void deleteUser(Long id);
    public User addUser(User user);
    public User getUserById(Long id);
    public List<User> getTypeUsers(String type);
    public User getUserByEmail(String email);
}
