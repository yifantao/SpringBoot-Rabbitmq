package indi.yftao.rabbitmqconsumermanual;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @descriptionn:
 * @author: yftao
 * @create: 2018-07-06 17:39
 **/
@Configuration
public class RabbitmqConsumerConf {

    @Autowired
    MessageReceiver messageReceiver;

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("queue.test");
        container.setMessageListener(messageReceiver);
        //container.setMaxConcurrentConsumers(1);
        //container.setConcurrentConsumers(1); 默认为1
        //container.setExposeListenerChannel(true);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // 设置为手动，默认为 AUTO，如果设置了手动应答 basicack，就要设置manual
        return container;
    }

}
