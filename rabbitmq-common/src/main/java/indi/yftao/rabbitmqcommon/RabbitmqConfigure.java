package indi.yftao.rabbitmqcommon;

import indi.yftao.rabbitmqcommon.constant.ExchangeEnum;
import indi.yftao.rabbitmqcommon.constant.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @descriptionn:
 * @author: yftao
 * @create: 2018-07-05 20:58
 **/
@Configuration
public class RabbitmqConfigure {

    /**
     * 配置路由交换对象实例
     * @return
     */
    @Bean
    public DirectExchange userRegisterDirectExchange()
    {
        return new DirectExchange(ExchangeEnum.TEST_EXCHANGE.getValue());
    }

    /**
     * 配置用户注册队列对象实例
     * 并设置持久化队列
     * @return
     */
    @Bean
    public Queue userRegisterQueue()
    {
        return new Queue(QueueEnum.TEST_QUEUE.getName(),true);
    }

    /**
     * 将用户注册队列绑定到路由交换配置上并设置指定路由键进行转发
     * @return
     */
    @Bean
    public Binding userRegisterBinding()
    {
        return BindingBuilder.bind(userRegisterQueue()).to(userRegisterDirectExchange()).with(QueueEnum.TEST_QUEUE.getRoutingKey());
    }

}
