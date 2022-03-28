package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.Product;
import cn.tedu.coolshark.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired(required = false)
    ProductMapper mapper;

    @RequestMapping("/product/insert")
    public void insert(@RequestBody Product product){
        System.out.println("product = " + product);
        product.setCreated(new Date());

        mapper.insert(product);
    }
    @RequestMapping("/product/select/admin")
    public List<Product> selectAdmin(){
        return mapper.selectAdmin();
    }
    @RequestMapping("/product/delete")
    public void delete(int id){
        //得到文件路径并删除商品文件
        String url = mapper.selectUrlById(id);
        String filePath = "D:/file"+url;
        new File(filePath).delete();

        mapper.deleteById(id);
    }
    @RequestMapping("/product/select/index")
    public List<Product> selectIndex(){
       return mapper.selectIndex();
    }

    @RequestMapping("/product/selectById")
    public Product selectById(int id, HttpSession session){
        System.out.println("id = " + id);
        //取出Session里面第一次浏览时保存的信息 如果没取到说明是第一次
        String info = (String) session.getAttribute("view"+id);
        if (info==null){
            //让浏览量+1
            mapper.updateViewCount(id);
            //此时是第一次访问 把商品id保存到Session里面
            session.setAttribute("view"+id,"浏览过");
        }
        return mapper.selectById(id);
    }

    @RequestMapping("/product/selectByCid")
    public List<Product> selectByCid(int cid){
        System.out.println("cid = " + cid);
        return mapper.selectByCid(cid);
    }

    @RequestMapping("/product/select/top")
    public List<Product> selectTop(){
        List<Product> list = mapper.selectTop();
        for (Product p:list) {
            if (p.getTitle().length()>5){//  非常漂...
                String title = p.getTitle().substring(0,3)+"...";
                p.setTitle(title);
            }
        }
        return list;
    }

}
