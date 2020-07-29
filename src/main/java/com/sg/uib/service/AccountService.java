package com.sg.uib.service;

import com.sg.uib.model.*;

public interface AccountService {
  public User saveAppUser (User user, String roleName) ;
  public Role saveRole (Role role) ;
  public    User loadUserByEmail ( String email) ;
  public   void addRoleToUser (String Email , String roleName) ;
}
