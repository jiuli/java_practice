package pattern.strategy.pay_strategy;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author lijunsong
 * @date 2019/3/27 14:03
 * @since 1.0
 */
public class PayContext {
    @Getter
    private String userName;
    @Getter
    private BigDecimal money;
    private PayStrategy payStrategy;

    public void pay() {
        //调用具体的支付策略来进行支付
        this.payStrategy.pay(this);
    }

    public PayContext(String userName, BigDecimal money, PayStrategy payStrategy) {
        this.money = money;
        this.userName = userName;
        this.payStrategy = payStrategy;
    }
}
