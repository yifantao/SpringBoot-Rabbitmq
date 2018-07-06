package indi.yftao.rabbitmqcomsuer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @descriptionn:
 * @author: yftao
 * @create: 2018-07-05 21:05
 **/
@Component
@Slf4j
@RabbitListener(queues = "queue.test")
public class RabbitmqConsumer {

    @RabbitHandler
    public void execute(String msg) {
        System.out.println(msg);
        log.info(msg);
    }
}
