package com.example.democonsumer.cache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.*;
import com.example.democonsumer.entity.User;
import com.example.democonsumer.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lifengsheng
 * @Date: 2022/10/19 19:15
 * @Desc:
 */
@Slf4j
@Component
public class CacheTest {
    @Resource
    private CacheTest cacheTest;

    @CreateCache(name = "demo:user", expire = 30, cacheType = CacheType.LOCAL, localLimit = 3)
    private Cache<Integer, User> userCacheMap;

    public void cacheUsers() {
        // 这里虽然添加了5个，但是只有最后3个可以被缓存在本地
        for (int i = 0; i < 5;) {
            userCacheMap.put(++i, new User(i, "kit-" + i));
        }
    }
    // 根据id从缓存实例获取对应的缓存user
    public User getUserByMap(Integer id) {
        return userCacheMap.get(id);
    }

    @Cached(name="demo:user:id:", key="#id", expire = 30, cacheType=CacheType.BOTH, localLimit = 3)
    public User getUserById(Integer id) {
        log.info("##### Begin to get user: {} from database.", id);
        return new User(id, "kit-" + id);
    }

    public User getUserByInternalMethod(Integer id) {
        // 1.可以通过自注入来调用自己的方法，实现代理调用
        // User user = cacheTest.getUserById(id);
        // 2.也可以通过暴露当前代理对象实现内部缓存方法调用，启动类要加注解：
        // @EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
        return ((CacheTest) AopContext.currentProxy()).getUserById(id);
    }

    @CacheInvalidate(name = "demo:user:id:", key = "#id")
    public void removeCacheUser(Integer id) {
        log.info("##### Remove cache user: {}", id);
    }

    @Cached(name = "demo:user:id:", key = "#id", cacheType=CacheType.BOTH)
    @CacheRefresh(refresh = 10, stopRefreshAfterLastAccess = 20)
    public User getUserById2(Integer id) {
        log.info("##### Get user info from database: {}", id);
        long timeMillis = System.currentTimeMillis();
        return new User(1, "now time is: " + timeMillis);
    }
}
