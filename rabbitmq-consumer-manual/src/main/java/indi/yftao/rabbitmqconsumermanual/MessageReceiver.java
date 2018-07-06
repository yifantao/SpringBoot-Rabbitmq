package indi.yftao.rabbitmqconsumermanual;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @descriptionn:
 * @author: yftao
 * @create: 2018-07-06 17:33
 **/
@Component
public class MessageReceiver implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws IOException {
        try {
            System.out.println(new String(message.getBody()));
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
