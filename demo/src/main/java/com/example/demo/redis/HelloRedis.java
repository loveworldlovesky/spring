package com.example.demo.redis;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRedis {
//	@Autowired
//	private StringRedisTemplate stringRedis;
	
	@RequestMapping("/helloRedis")
    public String index(String key,String value) {
//		stringRedis.opsForValue().set(key, value);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		String time = sf.format(new Date());
        return "key:"+value+" at "+time;
    }

}
