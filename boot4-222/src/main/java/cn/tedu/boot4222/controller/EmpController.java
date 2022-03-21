package cn.tedu.boot4222.controller;

import cn.tedu.boot4222.entity.Emp;
import cn.tedu.boot4222.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired(required = false)
    EmpMapper mapper;

    @RequestMapping("/insert")
    public void insert(Emp emp){
        System.out.println("emp = " + emp);
        mapper.insert(emp);
    }
    @RequestMapping("/select")
    public List<Emp> select(){

        //当方法return的类型为自定义对象或集合时,
        // SpringMVC框架会自动将集合或对象转成Json格式的字符串
        //然后将字符串再转成二进制数据通过网络传输给客户端
        return mapper.select();
    }
    @RequestMapping("/delete")
    public void delete(int id){
        mapper.deleteById(id);
    }


}
