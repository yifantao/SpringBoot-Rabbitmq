package indi.yftao.rabbitmqprovider;

import indi.yftao.rabbitmqcommon.constant.ExchangeEnum;
import indi.yftao.rabbitmqcommon.constant.QueueEnum;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @descriptionn:
 * @author: yftao
 * @create: 2018-07-06 10:38
 **/
@Component
public class RabbitmqService  {
    
    /*private final AmqpAdmin amqpAdmin;
    private final AmqpTemplate amqpTemplate;


    @Autowired
    public RabbitmqService(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
//        amqpAdmin.declareQueue();
//        amqpAdmin.declareExchange(exchange);
//        amqpAdmin.declareBinding(binding);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("回调Id：" + correlationData.getId());
        if (b) {
            System.out.println("回调成功");
        } else {
            System.out.println("回调失败：" + s);
        }
    }

    @Override
    public void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        amqpTemplate.convertAndSend(exchangeEnum.getValue(), queueEnum.getRoutingKey(), message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                return message;
            }
        });
    }*/
}
