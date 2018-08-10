package cn.condition.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 实现spring 的Condition接口，并且重写matches()方法，如果操作系统是linux就返回true
 *
 */
public class LinuxCondition implements Condition{

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println("LinuxCondition=====================================");
//        return context.getEnvironment().getProperty("os.name").contains("Linux");
        return true;
    }

    
}
