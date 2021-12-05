package org.hankyu.myhome.repository;

import org.hankyu.myhome.model.User;

import java.util.List;

public interface CustomizedUserRepository {
    List<User> findByUsernameCustom(String username);
    List<User> findByUsernameJDBC(String username);
}
