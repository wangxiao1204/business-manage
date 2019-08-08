package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user/product/")
public class ProductController{

    @Autowired
    IProductService productService;

    ProductController productController;

    @RequestMapping("find")
    public String findAll(HttpSession session){

        List<Product> productList=productService.findAll();

        session.setAttribute("productlist",productList);

        return "productlist";
    }

    @RequestMapping(value="update/{id}",method= RequestMethod.GET)
    public String update(@PathVariable("id")Integer productId, HttpServletRequest request){

        Product product= productService.findProductById(productId);

        request.setAttribute("product",product);

        return "productupdate";
    }

    @RequestMapping(value="update/{id}",method=RequestMethod.POST)
    public String update(Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //
        int count=productService.updateProduct(product);

        if(count>0){
            //修改成功
            return "redirect:/user/product/find";
        }

        return "productupdate";
    }
    @RequestMapping(value="delete/{id}")
    public  String delete(@PathVariable("id")Integer productId)
    {
        System.out.println(productId);
        int count=productService.deleteProduct(productId);

        if(count==0)
        {
            System.out.println("success");
        }
        //删除成功
        return "redirect:/user/product/find";

    }


    @RequestMapping(value="add",method= RequestMethod.GET)
    public String insert(HttpServletRequest request){

        Product product=new Product();

        request.setAttribute("product",product);

        return "productadd";
    }

    @RequestMapping(value="add",method=RequestMethod.POST)
    public String insert(Product product, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //
        int count=productService.addProduct(product);

        if(count>0){
            //添加成功
            return "redirect:/user/product/find";
        }

        return "productadd";
    }
}
