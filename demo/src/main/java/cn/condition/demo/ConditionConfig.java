package cn.condition.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    /**
     * 通过@Conditional 注解，符合windows条件就返回WindowsListService实例
     * 
     */
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windonwsListService() {
        return new WindowsListService();
    }

    /**
     * 通过@Conditional 注解，符合linux条件就返回LinuxListService实例
     * 
     */
    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService() {
        return new LinuxListService();
    }
}