package indi.yftao.rabbitmqprovider;

import indi.yftao.rabbitmqcommon.constant.ExchangeEnum;
import indi.yftao.rabbitmqcommon.constant.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @descriptionn:
 * @author: yftao
 * @create: 2018-07-05 20:44
 **/
public interface IRabbitmqService extends RabbitTemplate.ConfirmCallback {

    void send(Object message, ExchangeEnum exchangeEnum, String routeKey);

}
