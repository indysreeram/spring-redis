package com.sreeram.springredis;

import com.sreeram.springredis.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private RedisTemplate<String,User> redisTemplate;

    private HashOperations hashOperations;

    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = this.redisTemplate.opsForHash();
    }


    @Override
    public void save(User user) {

        hashOperations.put("USER",user.getId(),user);

    }

    @Override
    public Map<String,User> findall() {
        return hashOperations.entries("USER");
    }

    @Override
    public User findBy(String id) {
        return (User) hashOperations.get("USER",id);
    }

    @Override
    public void update(User user) {
        save(user);

    }

    @Override
    public void delete(String id) {
        hashOperations.delete("USER",id);

    }
}
