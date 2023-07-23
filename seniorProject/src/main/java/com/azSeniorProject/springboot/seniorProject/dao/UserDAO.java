package com.azSeniorProject.springboot.seniorProject.dao;

import com.azSeniorProject.springboot.seniorProject.entity.User;

public interface UserDAO {

    void save(User theUser);

    void delete(Integer id);

    int deleteAll();
}
