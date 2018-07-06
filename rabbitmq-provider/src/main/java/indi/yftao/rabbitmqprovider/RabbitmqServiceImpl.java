package indi.yftao.rabbitmqprovider;

import indi.yftao.rabbitmqcommon.constant.ExchangeEnum;
import indi.yftao.rabbitmqcommon.constant.QueueEnum;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @descriptionn:
 * @author: yftao
 * @create: 2018-07-05 20:44
 **/
@Service
public class RabbitmqServiceImpl implements IRabbitmqService {

    @Autowired
    RabbitTemplate rabbitTemplate;

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
    public void send(Object message, ExchangeEnum exchangeEnum, String routingKey) {
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(exchangeEnum.getValue(),routingKey, message, correlationData);
    }
}
