package com.zmm.milletucapi.config;

/**
 * @Classname TransactionAdviceConfig
 * @Description 全局事务配置
 * @Date 2019/11/14 10:21
 * @Created by yc
 */
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Aspect
@Configuration
public class TransactionAdviceConfig {
    /**
     * execution理解
     *
     * "execution(* cn.rivamed..service..*Service*.*(..))"
     * execution(): 表达式主体。
     * 第一个*号：表示返回类型， *号表示所有的类型。
     * 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包
     * 第二个*号：表示类名，*Service*表示包下包含Service的所有类。
     * *(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
     */
    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.talkweb.edu..service..*Service*.*(..))";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {

        DefaultTransactionAttribute txAttr_REQUIRED = new DefaultTransactionAttribute();
        txAttr_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DefaultTransactionAttribute txAttr_REQUIRED_READONLY = new DefaultTransactionAttribute();
        txAttr_REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txAttr_REQUIRED_READONLY.setReadOnly(true);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("add*", txAttr_REQUIRED);
        source.addTransactionalMethod("save*", txAttr_REQUIRED);
        source.addTransactionalMethod("insert*", txAttr_REQUIRED);
        source.addTransactionalMethod("delete*", txAttr_REQUIRED);
        source.addTransactionalMethod("update*", txAttr_REQUIRED);
//        source.addTransactionalMethod("exec*", txAttr_REQUIRED);
//        source.addTransactionalMethod("set*", txAttr_REQUIRED);
//        source.addTransactionalMethod("get*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("query*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("find*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("list*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("count*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("is*", txAttr_REQUIRED_READONLY);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}
