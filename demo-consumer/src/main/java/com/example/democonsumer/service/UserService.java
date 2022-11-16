package com.example.democonsumer.service;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.democonsumer.cache.CacheTest;
import com.example.democonsumer.entity.User;
import com.example.democonsumer.entity.UserEntity;
import com.example.democonsumer.feign.UserApi;
import com.example.democonsumer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: lifengsheng
 * @Date: 2022/9/27 17:50
 * @Desc:
 */
@Slf4j
@Service
public class UserService {
    @Resource
    private UserApi userApi;

    @Resource
    private CacheTest cacheTest;

    @Resource
    private UserRepository userRepository;

    public List<UserEntity> testReturn() {
        // 没有记录，返回了一个空集合，不是null，打印为0。
        // System.out.println(list.size());
        return userRepository.list(new LambdaQueryWrapper<UserEntity>()
                .eq(UserEntity::getAge, 1000));
    }

    public List<UserEntity> testReturn2() {
        // 报错：sql语句异常。。。
        return userRepository.list(new LambdaQueryWrapper<UserEntity>()
                .in(UserEntity::getAge, new ArrayList<Integer>()));
    }

    @Transactional
    public boolean updateOne() {
        UserEntity user = new UserEntity();
        user.setUsername("hello kit");
        user.setId(8L);
        userRepository.updateById(user);
        updateTwo();
        return true;
    }

    public boolean updateTwo() {
        UserEntity user = new UserEntity();
        user.setUsername("hello kit");
        user.setId(9L);
        userRepository.updateById(user);
        return true;
    }

    public List<UserEntity> getAll() {
        List<UserEntity> userEntities = userRepository.getBaseMapper().selectBatchIds(Collections.singletonList(null));
        System.out.println(userEntities);
        return userEntities;
        //return userRepository.getAll();
    }

    public UserEntity getById(Integer id) {
        UserEntity byId = userRepository.getBaseMapper().selectById(null);
        System.out.println("eeeee=" + byId);
        return byId;
    }

    @Transactional
    public boolean updateBatchById() {
        UserEntity byId = userRepository.getById(1);
        UserEntity byId2 = userRepository.getById(2);
        UserEntity byId3 = userRepository.getById(3);
        byId.setAge(100);
        byId2.setAge(200);
        byId3.setAge(300);
        List<UserEntity> userEntities = Arrays.asList(byId, byId2, byId3);
        return userRepository.updateBatchById(userEntities);
    }

    @Transactional
    public boolean updateBatch() {
        UserEntity user = new UserEntity();
        user.setUsername("hello kit");
        return userRepository.update(user, new LambdaUpdateWrapper<UserEntity>()
                .eq(UserEntity::getPassword, "qwe"));
    }

    @Transactional
    public boolean updateBatch2() {
        UserEntity user = new UserEntity();
        return userRepository.update(new LambdaUpdateWrapper<UserEntity>()
                .eq(UserEntity::getPassword, "qwe")
                .in(UserEntity::getId, Arrays.asList(5, 6, 7))
                .set(UserEntity::getUsername, "hello!"));
    }

    @Transactional
    public void saveBatch() {
        UserEntity user = new UserEntity();
        UserEntity user2 = new UserEntity();
        UserEntity user3 = new UserEntity();
        user.setId(8L);
        user.setUsername("lfs");
        user.setAge(10);
        user2.setId(9L);
        user2.setUsername("lfs2");
        user2.setAge(12);
        user3.setId(10L);
        user3.setUsername("lfs3");
        user3.setAge(13);
        userRepository.saveBatch(Arrays.asList(user, user2, user3));
    }

    public UserEntity logUserById(Long userId) {
        return userApi.getUserById(userId);
    }

    public void cacheUser() {
        cacheTest.cacheUsers();
    }

    public User getCacheUser(Integer userId) {
        return cacheTest.getUserByMap(userId);
    }

    public User getUserById(Integer userId) {
        return cacheTest.getUserById(userId);
    }

    public User getUserById2(Integer userId) {
        return cacheTest.getUserById2(userId);
    }

    public void removeCache(Integer userId) {
        cacheTest.removeCacheUser(userId);
    }

    public User getUserByInternalMethod(Integer id) {
        return cacheTest.getUserByInternalMethod(id);
    }
}
