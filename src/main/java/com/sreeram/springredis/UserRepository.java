package com.sreeram.springredis;

import com.sreeram.springredis.model.User;

import java.util.Map;

public interface UserRepository {

    void save(User user);

    Map<String,User> findall();

    User findBy(String id);

    void update(User user);

    void delete(String id);
}
