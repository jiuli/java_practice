package pattern.strategy.pay_strategy;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/27 14:27
 * @since 1.0
 */
@Slf4j
public class AccountPay1 implements PayStrategy {
    /**
     * 不从上下文获取参数
     * 直接从策略内部获取
     */
    @Getter
    @Setter
    private String account;

    public AccountPay1(String account) {
        this.account = account;
    }

    @Override
    public void pay(PayContext payContext) {
        log.info("现在给：" + payContext.getUserName() + "的账户：" + getAccount() + " 支付工资：" + payContext.getMoney() + " 元！");
    }
}
