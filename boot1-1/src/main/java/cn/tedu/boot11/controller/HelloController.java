package cn.tedu.boot11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HelloController {
    @RequestMapping("/hello") // http://localhost:8080/hello
    public void hello(HttpServletResponse response) throws IOException {
        System.out.println("服务器接收到请求");
        //设置响应类型 告诉客户端浏览器响应的内容是文本或标签 字符集utf-8
        response.setContentType("text/html;charset=utf-8");
        //获取输出对象 异常抛出
        PrintWriter pw = response.getWriter();
        //给客户端响应数据
        pw.print("恭喜你测试成功!");
        pw.close();//关闭资源
    }
}
