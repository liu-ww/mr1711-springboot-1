package com.mr.controller;

import com.mr.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ${LGQ} on 2018/5/30.
 */
@Controller
//@RestController//全类返回json
public class UserController {

    @Autowired
    private UserService userService;

//    @ResponseBody
//    @GetMapping("list/{id}")
//    public User getList(@PathVariable("id") Integer id){
//        User user = userService.getList(id);
//        return user;
//    }

    /**
     * 查询所有User
     * @return
     */
    @GetMapping("queryList")

    public String queryList(ModelMap map){
        // 查询User全部对象
        List<User> usersList = userService.queryList();
        map.put("usersList",usersList);
        return "list";
    }

    /**
     * 跳转add页面
     * @return
     */
    @GetMapping("/addUser")
    public String addUser(){
        return "add";
    }

    /**
     * 新增数据
     * @param user
     * @return
     */
    @PostMapping("/user")
    public String add(User user){
        userService.add(user);
        return "redirect:/queryList";
    }

    /**
     *跳转修改页面
     * @return
     */
    @GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable Integer id,ModelMap map){
        User user = userService.queryUser(id);
        map.put("user",user);
        return "update";
    }

    /**
     * 修改数据
     * @param user
     * @return
     */
    @PutMapping("user")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/queryList";
    }

    /**
     * post方式删除
     * @param id
     * @return
     */

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "redirect:/queryList";
    }
}
