package pattern.strategy.pay_strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/27 14:07
 * @since 1.0
 */
@Slf4j
public class DollarPay implements PayStrategy {
    @Override
    public void pay(PayContext payContext) {
        //美金支付
        log.info("现在给：" + payContext.getUserName() + "美金支付：" + payContext.getMoney() + "dollar.");
    }
}
