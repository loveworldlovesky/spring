package com.example.demo.seckill.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.seckill.product.domain.ProductSeckill;
import com.example.demo.seckill.product.service.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
    private ProductService productService;
	
	//ProductSeckill
	@ResponseBody
	@GetMapping("insert")
	public ProductSeckill insert(){
		ProductSeckill ps = new ProductSeckill();
		ps.setProductName("诺基亚001");
		ps.setProductNum("NK001");
		ps.setSeckillNum(10);
		
		productService.insert(ps);
		return ps;
	}
	@ResponseBody
	@PostMapping("seckill")
	public String productSeckill(String phoneNum,String productNum){
		//秒杀
//		-->当前有库存-->抢购成功
//		库存全部被锁后，其余抢购直接报失败
//		抢购成功-->锁库存-->确认下单-->减库存，生成订单
//		抢购成功-->锁库存-->取消下单-->释放库存锁-->其他人可以继续抢购
		String result = productService.productSeckill(phoneNum,productNum);
		return result;
	}

}
