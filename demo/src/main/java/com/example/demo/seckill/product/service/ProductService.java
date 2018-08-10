package com.example.demo.seckill.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.seckill.product.dao.ProductSeckillDao;
import com.example.demo.seckill.product.domain.ProductSeckill;

@Service
public class ProductService {
	
	//将库存数量放到redis缓存中
	static int pruductNum = 200;
	
	
	@Autowired
    private ProductSeckillDao productSeckillMapper;

	public void insert(ProductSeckill ps) {
		productSeckillMapper.insert(ps);
		
	}

	public String productSeckill(String phoneNum,String productNum) {
		String result = "failed";
		if(pruductNum<0) {
			result = "-1";
		}else {
			result = "1";
			synchronized (this) {
				if(pruductNum<1) {
					result = "-1";
				}else {
					pruductNum--;
					System.out.println("pruductNum="+pruductNum);
					//秒杀成功后,用户在页面确认生成订单,完成支付
					//生成订单--异步执行
					//直接减库存
					if(pruductNum <1 ) {
						//抢购时如果发现被抢完 清空库存
						//如果没被抢完 抢购时间结束后更新缓存 定时任务类
						System.out.println("======================抢购结束,库存请空=======================");
						productSeckillMapper.reduce(200,productNum);
					}
				}
				
			}
			
		}
		
		return result;
	}
	public String productSeckill_01(String phoneNum,String productNum) {
		String result = "failed";
		Integer productTotal = getProductTotal(productNum);
		if(productTotal == null || productTotal == 0) {
			result = ">>>>>>>>>>>>,please wait for next day!";
		}else {
			result = "-----------do seckill from "+productTotal+" product= "+productNum;
			
			//直接减库存
			productSeckillMapper.reduce(1,productNum);
			//生成订单
			
		}
		
		return result;
	}
	public Integer getProductTotal(String productNum) {
		Integer productTotal = productSeckillMapper.getProductTotal(productNum);
		return productTotal;
	}

}
