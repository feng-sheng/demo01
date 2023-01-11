package com.example.demo01.service;

import com.example.demo01.entity.UserEntity;
import com.example.demo01.mapper.UserTestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description
 * @Date 2022/9/23
 * @Author lifengsheng
 */
@Slf4j
@Service
public class UserTestService {
    //@Autowired
    @Resource
    private UserTestMapper userTestMapper;

    public List<UserEntity> getUserList() {
        return userTestMapper.getUserList();
    }

    public UserEntity getUserById(Long id) {
        log.info("######### id is: {}", id);
        return userTestMapper.getUserById(id);
    }

    public boolean addUser(UserEntity user) {
        return userTestMapper.addUser(user) > 0;
    }

    public String getHeaders() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(requestAttributes)) {
            log.error("######### requestAttributes is null.");
            throw new RuntimeException("######### requestAttributes is null.");
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        List<String> headers = new ArrayList<>();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.add(headerName + ":" + headerValue);
        }
        String collect = headers.stream().collect(Collectors.joining(System.lineSeparator()));
        log.info("###############333 :\n\r{}", collect);
        return "true";
    }
}
