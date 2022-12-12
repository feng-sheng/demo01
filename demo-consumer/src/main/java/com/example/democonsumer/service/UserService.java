package com.example.democonsumer.service;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.democonsumer.cache.CacheTest;
import com.example.democonsumer.entity.User;
import com.example.democonsumer.entity.UserEntity;
import com.example.democonsumer.feign.UserApi;
import com.example.democonsumer.mapper.UserMapper;
import com.example.democonsumer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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
    private UserMapper userMapper;

    @Resource
    private CacheTest cacheTest;

    @Resource
    private UserRepository userRepository;

    public List<UserEntity> testReturn() {
        // 没有记录，返回了一个空集合，不是null，打印为0
        // System.out.println(list.size());
        return userRepository.list(new LambdaQueryWrapper<UserEntity>()
                .eq(UserEntity::getAge, 1000));
    }

    public List<UserEntity> testReturn2() {
        // 报错：sql语句异常。。。
        return userRepository.list(new LambdaQueryWrapper<UserEntity>()
                .in(UserEntity::getAge, new ArrayList<Integer>()));
    }

    public List<UserEntity> testReturn3() {
        return userRepository.getBaseMapper().selectBatchIds(Arrays.asList(1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3));
    }


    public List<UserEntity> testReturn4() {
        return userRepository.list(new LambdaQueryWrapper<UserEntity>()
                .ne(UserEntity::getUsername, "hello kit"));
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
        return userRepository.update(new LambdaUpdateWrapper<UserEntity>()
                .eq(UserEntity::getPassword, "qwe")
                .in(UserEntity::getId, Arrays.asList(5, 6, 7, 100))
                .set(UserEntity::getUsername, "qop"));
    }

    // 框架插入
    @Transactional
    public void saveBatch() {
        UserEntity user = new UserEntity();

        // 表字段age类型：int not null, 实体类类型：integer,
        // 如果表age字段未设置默认值会报错：Field 'age' doesn't have a default value，设置默认值后就不会报错
        user.setUsername("lfs");
        userRepository.saveBatch(List.of(user));
    }

    // 手写sql方式插入
    public void addUser() {
        UserEntity user = new UserEntity();

        // 表字段age类型：int not null, 实体类类型：integer,
        // 如果sql中指定了该列，不管表字段age有没有指定默认值都会报错
        user.setUsername("lfs2");

        userMapper.addUser(user);
    }
    // 总结:列显式指定的默认值不代表该列显式赋值为NULL时的值，而是代表如果该列被忽略时的值(INSERT时未指定该列)
    // 如果列被定义为NOT NULL，不管有没有显式的指定默认值，当执行INSERT语句且指定该列时，报错：Column 'age' cannot be null
    // 如果列被定义为NOT NULL，并且没有显式的指定默认值，当执行INSERT语句且未指定该列时，在严格模式与非严格模式下处理方式不同。
    // 前者是报错：Field 'age' doesn't have a default value，后者是赋值为隐式的默认值，即列数据类型的默认值

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
