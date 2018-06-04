package com.mr.service.impl;

import com.mr.mapper.UserMapper;
import com.mr.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by ${LGQ} on 2018/5/30.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
//    @Override
//    public User getList(Integer id) {
//        User user = userMapper.selectByPrimaryKey(id);
//        return user;
//    }

    @Override
    @Cacheable(value="list",key="1")//在redis中开启key为findAllUser开头的存储空间
    public List<User> queryList() {
        List<User> userList =  userMapper.queryList();
        return  userList;
    }

    @Transactional
    @Override
    @CacheEvict(value="thisredis",allEntries = true)
    /**
     * 在注解参数里面加上beforeInvocation为true，意思是说当执行这个方法之前执行清除缓存的操作，这样不管这个方法执行成功与否，该缓存都将不存在。

     当注解参数加上allEntries为true时，意思是说这个清除缓存是清除当前value值空间下的所有缓存数据
     */
    public void add(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User queryUser(@PathVariable Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    @CacheEvict(value="thisredis",allEntries = true)
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Transactional
    @Override
    @CacheEvict(value="list",allEntries = true)
    public void deleteUser(@PathVariable Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }


}













