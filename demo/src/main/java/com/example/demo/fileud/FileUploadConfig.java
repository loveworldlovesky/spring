package com.example.demo.fileud;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//配置类会覆盖配置文件
@Configuration
public class FileUploadConfig {
	 @Bean
	    public MultipartConfigElement multipartConfigElement() {
	        MultipartConfigFactory factory = new MultipartConfigFactory();
	        factory.setMaxFileSize("500MB"); //单个文件大小
	        factory.setMaxRequestSize("1000MB");//总上传的数据大小
	        return factory.createMultipartConfig();
	    }


}
