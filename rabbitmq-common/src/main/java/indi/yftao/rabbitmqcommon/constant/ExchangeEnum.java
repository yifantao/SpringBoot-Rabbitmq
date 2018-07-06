package indi.yftao.rabbitmqcommon.constant;

import lombok.Getter;

/**
 * @descriptionn:
 * @author: yftao
 * @create: 2018-07-05 20:47
 **/
@Getter
public enum ExchangeEnum {

    /**
     * 用户注册交换配置枚举
     */
    TEST_EXCHANGE("exchange.test")
    ;
    private String value;

    ExchangeEnum(String value) {
        this.value = value;
    }

}
