package cn.jr.edu.controller;

import cn.jr.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edu/user")
@CrossOrigin    //解决跨域问题
public class LoginController {

    //login
    @PostMapping("/login")
    public R login(){

        return R.ok().data("token","admin");
    }


    //info
    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin");
    }
}
