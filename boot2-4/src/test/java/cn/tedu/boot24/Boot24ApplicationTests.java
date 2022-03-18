package cn.tedu.boot24;

import cn.tedu.boot24.entity.Emp;
import cn.tedu.boot24.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot24ApplicationTests {
    @Autowired(required = false)    //required=false 设置为非必须的对象
            EmpMapper mapper;
    @Test
    void contextLoads() {
        Emp e = new Emp();
        e.setName("张三");
        e.setSal(300);
        e.setJob("歌手");
        mapper.insert(e);
    }

}
