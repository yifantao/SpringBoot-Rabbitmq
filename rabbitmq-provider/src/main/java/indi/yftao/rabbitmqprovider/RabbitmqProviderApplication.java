package indi.yftao.rabbitmqprovider;

import indi.yftao.rabbitmqcommon.constant.ExchangeEnum;
import indi.yftao.rabbitmqcommon.constant.QueueEnum;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableRabbit
public class RabbitmqProviderApplication {

    @Autowired
    IRabbitmqService rabbitmqService;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProviderApplication.class, args);
    }

    @RequestMapping("/send")
    public String send(@RequestParam String msg) {
        rabbitmqService.send(msg,ExchangeEnum.TEST_EXCHANGE,QueueEnum.TEST_QUEUE);
        return "ok";
    }
}
