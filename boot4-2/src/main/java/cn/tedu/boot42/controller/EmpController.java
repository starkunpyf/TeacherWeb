package cn.tedu.boot42.controller;

import cn.tedu.boot42.entity.Emp;
import cn.tedu.boot42.mapper.EmpMapper;
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
        mapper.insert(emp);
    }

    @RequestMapping("/select")
    public List<Emp> select(){
        //当方法的返回值类型为自定义对象类型或集合类型时
        //SpringMVC框架会自动将对象或集合里面的数据装成字符串(Json格式的字符串)
        //最后再把字符串转成二进制数据 通过网络传输给客户端
        return mapper.select();
    }
    @RequestMapping("/delete")
    public void delete(int id){
        mapper.deleteById(id);
    }


}
