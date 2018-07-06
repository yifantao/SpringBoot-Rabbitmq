package indi.yftao.rabbitmqcommon.constant;

import lombok.Getter;

/**
 * @descriptionn:
 * @author: yftao
 * @create: 2018-07-05 20:47
 **/

@Getter
public enum QueueEnum {

    /**
     * 用户注册枚举
     */
    TEST_QUEUE("queue.test","key.test")
    ;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 队列路由键
     */
    private String routingKey;

    QueueEnum(String name, String routingKey) {
        this.name = name;
        this.routingKey = routingKey;
    }
}
