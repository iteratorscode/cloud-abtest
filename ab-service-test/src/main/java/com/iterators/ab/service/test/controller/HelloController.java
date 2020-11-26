package com.iterators.ab.service.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author zhanghui
 * @date 2020/11/25 下午4:21
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @GetMapping("/red/{id}")
    public String red(@PathVariable String id) {

        return "Form test service red " + id;
    }

    @GetMapping("/blue/{id}")
    public String blue(@PathVariable String id) {
        return "Form test service blue " + id;
    }
}
