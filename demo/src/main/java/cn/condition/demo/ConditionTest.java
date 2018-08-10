package cn.condition.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Spring的条件化配置，条件化配置允许配置存在于应用中，但是在满足某些特定条件前会忽略这些配置。
要实现条件化配置我们要用到@Conditional条件化注解
 *
 */
public class ConditionTest {

    public static void main(String[] args) {
    	//启动的时候会去解析ConditionConfig  根据Condition实现类里的业务代码得到判断结果 满足时返回true 这样就触发了条件
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out
                .println(context.getEnvironment().getProperty("os.name") + " 系统下的列表命令为： " + listService.showListLine());
    }
}
