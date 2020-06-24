package com.sg.uib.service;

import com.sg.uib.model.*;

public interface AccountService {
  public User saveUser (User user) ;
  public Role saveRole (Role role) ;
  public    User loadUserByEmail ( String email) ;
  public   void addRoleToUser (String Email , String roleName) ;
}
