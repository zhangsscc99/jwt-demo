package top.lukeewin.jwtdemo2.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lukeewin.jwtdemo2.annotation.Auth;
import top.lukeewin.jwtdemo2.utils.R;

@RestController
@RequestMapping("/test")
public class TestController {

    @Auth
    @PostMapping("/hello")
    public R<?> hello() {
        return R.ok("登录成功");
    }

    @PostMapping("/hi")
    public R<?> hi() {
        return R.ok("登录成功");
    }
}
