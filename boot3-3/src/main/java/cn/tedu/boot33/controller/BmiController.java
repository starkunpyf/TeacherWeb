package cn.tedu.boot33.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BmiController {
    @RequestMapping("/bmi")
    public String bmi(float height,float weight){
        float bmi = weight/(height*height);
        if (bmi<18.5){
            return "瘦了";
        }
        if (bmi<24){
            return "正常";
        }
        if (bmi<28){
            return "微微胖";
        }
        return "微胖!";
    }
}
