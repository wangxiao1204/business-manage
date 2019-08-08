package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductService {



    /**
     *添加商品
     * **/
    public int addProduct(Product product)throws MyException;

    /**
     *删除商品
     * **/
    public int deleteProduct(int productId)throws MyException;


    /**
     *修改商品
     * **/
    public int updateProduct(Product product)throws MyException;


    /**
     *查询商品
     *  **/

    public List<Product> findAll() throws MyException;

    /**
     * 根据商品id查询商品信息
     */
    public Product findProductById(int productId);
}
