package com.oneshow.user.controller;

import com.oneshow.commom.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    // 系统首页
    @GetMapping("/index")
    public R index()
    {
        return R.ok("首页");
    }
}
