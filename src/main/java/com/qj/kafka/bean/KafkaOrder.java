package com.qj.kafka.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * order
 */
@Data
@ToString
public class KafkaOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    // 系统id
    private String systemCode;
    // 订单id
    private Long orderId;
    // 交易类型 0限价 1市价 (-1取消订单:和kafkato通讯使用)
    private Integer tradeType;
    // 买卖类型 0买 1卖
    private Integer side;
    // 法币名称
    private String fiatCode;
    // 虚拟币名称
    private String cryptoCode;
    // 下单时汇率
    private BigDecimal exchangeRate;
    // 交易价格 单价 汇率换算后
    private BigDecimal price;
    // 总数量
    private BigDecimal quantity;
    // 未交易数量
    private BigDecimal leftQuantity;
    // 创建时间
    private Long createTime;
    // 过期时间
    private Long expireTime;

}
