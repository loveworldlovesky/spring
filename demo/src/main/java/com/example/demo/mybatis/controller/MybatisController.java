package com.example.demo.mybatis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.commons.io.IOUtils;

import com.example.demo.mybatis.domain.TUser;
import com.example.demo.mybatis.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class MybatisController {
	@Autowired
    private UserService userService;
	
//	@ResponseBody
//    @GetMapping("/{id}")
//    public Object getUserById(@PathVariable int id){
//		TUser user = userService.getUser(id);
//        return user;
//    }
	//另外一个写法
	@ResponseBody
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	 public Object getUserById(@PathVariable int id){
		TUser user = userService.getUser(id);
        return user;
    }
	@ResponseBody
	@PostMapping
	public String insert(String id){
		userService.insert(Integer.parseInt(id),String.valueOf(id));
		return "success";
	}
	@ResponseBody
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id){
		userService.delete(id);
		return "success";
	}
	
	@ResponseBody
//	@GetMapping("/getAllUser")
	@RequestMapping("getAllUser") //如果不指定请求类型，则默认支持所有类型
	public List<TUser> getAllUser() {
		List<TUser> users = userService.getAllUser();
		return users;
	}
	@ResponseBody
	@GetMapping("/getStr")
	public Object getStr(){
		return userService.getStr();
	}
	/**
	 * put请求时 要求'Content-Type':'application/x-www-form-urlencoded'
	  * 或者开启HttpPutFormContentFilter
	 * @param request
	 * @param id
	 * @param userName
	 * @return
	 */
	@ResponseBody
	@PutMapping
	public String update(HttpServletRequest request,String id,String userName){
		 InputStream io = null;
        String body;
        System.out.println("------- body -------");
        Map<String,String[]> requestParameter = request.getParameterMap();
        Enumeration<String> requestHeader = request.getHeaderNames();
        try{
            io = request.getInputStream();
            body = IOUtils.toString(io,"UTF-8");
            //打印BODY内容
            System.out.println("Request Body="+body);
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("------- header -------");
        while(requestHeader.hasMoreElements()){
            String headerKey=requestHeader.nextElement().toString();
            //打印所有Header值

            System.out.println("headerKey="+headerKey+";value="+request.getHeader(headerKey));
        }
        System.out.println("------- parameters -------");
        for(String key :requestParameter.keySet())
        {
            for(int i=0;i<requestParameter.get(key).length;i++)
            {
                //打印所有请求参数值
                System.out.println("key="+key+";value="+requestParameter.get(key)[i].toString());
            }
        }
		userService.update(Integer.parseInt(id),userName);
		return "success";
	}
	
}
