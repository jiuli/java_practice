package pattern.strategy.pay_strategy;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author lijunsong
 * @date 2019/3/27 14:18
 * @since 1.0
 */
public class AccountPayContext extends PayContext {
    /**
     * 银行账户
     */
    @Getter
    private String account;

    public AccountPayContext(String userName, BigDecimal money, String acount, PayStrategy payStrategy) {
        super(userName, money, payStrategy);
        this.account = acount;
    }
}
