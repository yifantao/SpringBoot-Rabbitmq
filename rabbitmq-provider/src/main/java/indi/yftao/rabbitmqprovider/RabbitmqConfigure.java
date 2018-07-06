package indi.yftao.rabbitmqprovider;

import indi.yftao.rabbitmqcommon.constant.ExchangeEnum;
import indi.yftao.rabbitmqcommon.constant.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @descriptionn:
 * @author: yftao
 * @create: 2018-07-05 20:58
 **/
@Configuration
public class RabbitmqConfigure {

    @Autowired
    RabbitAdmin rabbitAdmin;

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory defaultConnectionFactory){
        return new RabbitAdmin(defaultConnectionFactory);
    }

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

    @PostConstruct
    public void init (){
        Queue queue = new Queue(QueueEnum.TEST_QUEUE.getName(),true);
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareExchange(new DirectExchange(ExchangeEnum.TEST_EXCHANGE.getValue(),true,false));
    }
}
