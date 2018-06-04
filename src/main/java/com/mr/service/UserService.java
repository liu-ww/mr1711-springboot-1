package com.mr.service;

import com.mr.model.User;

import java.util.List;

/**
 * Created by ${LGQ} on 2018/5/30.
 */
public interface UserService {

    List<User> queryList();

    void add(User user);

    User queryUser(Integer id);

    void updateUser(User user);

    void deleteUser(Integer id);
}
