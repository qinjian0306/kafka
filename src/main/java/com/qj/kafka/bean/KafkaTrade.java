package com.qj.kafka.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * trade
 */
@Data
@ToString
public class KafkaTrade implements Serializable {

    private static final long serialVersionUID = 1L;

    // 主键id
    private  Long id;
    // 平台id
    private String systemCode;
    // 订单id
    private Long orderId;
    // 0买 1卖
    private Integer side;
    // 交易状态 部分成交(0)，完全成交(1)，已撤单(-1) 撤单失败(-2)
    private Integer status;
    // 价格
    private BigDecimal price;
    // 成交汇率
    private BigDecimal exchangeRate;
    // 数量
    private BigDecimal quantity;
    // 交易时间
    private Long time;

}
