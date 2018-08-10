package com.example.demo.seckill.order.dao;
import com.example.demo.seckill.order.domain.OrderSeckill;

public interface OrderSeckillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderSeckill record);

    int insertSelective(OrderSeckill record);

    OrderSeckill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderSeckill record);

    int updateByPrimaryKey(OrderSeckill record);
}