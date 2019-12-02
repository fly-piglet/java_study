package com.wlh.remote.debug.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    private static final AtomicInteger num = new AtomicInteger(0);

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        num.incrementAndGet();
        log.info("访问次数为：{}", num);
        return "success";
    }
}
