package cn.tedu.boot33.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AxiosController {
    @RequestMapping("/helloAxios")
    public String helloAxios(){

        return "测试成功!";
    }
}
