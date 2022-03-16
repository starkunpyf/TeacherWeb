package cn.tedu.boot11.controller;

import cn.tedu.boot11.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamController {
    @RequestMapping("/param1")
    @ResponseBody
    public String param1(HttpServletRequest request){
        //获取传递过来的参数
        String info = request.getParameter("info");
        return "测试成功! info="+info;
    }

    @RequestMapping("/param2")
    @ResponseBody
    public String param2(String name,int age){
        return "测试成功! name="+name+" age="+age;
    }

    @RequestMapping("/param3")
    @ResponseBody
    public String param3(User user){
        return "测试成功!"+user;
    }



}
