package com.example.demo.seckill.product.dao;
import com.example.demo.seckill.product.domain.ProductSeckill;
//@Mapper
public interface ProductSeckillDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductSeckill record);

    int insertSelective(ProductSeckill record);

    ProductSeckill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductSeckill record);

    int updateByPrimaryKey(ProductSeckill record);
    
    Integer getProductTotal(String productNum);
    
    void reduce(int num,String productNum);
}