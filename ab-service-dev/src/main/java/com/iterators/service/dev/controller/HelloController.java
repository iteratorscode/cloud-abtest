package com.iterators.service.dev.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public String red(@PathVariable String id, @RequestHeader("tag") String tag) {

        return "Form dev service red " + id + " : " + tag;
    }

    @GetMapping("/blue/{id}")
    public String blue(@PathVariable String id) {
        return "Form dev service blue " + id;
    }
}
