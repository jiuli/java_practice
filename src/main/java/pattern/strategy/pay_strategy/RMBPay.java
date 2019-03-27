package pattern.strategy.pay_strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/27 14:06
 * @since 1.0
 */
@Slf4j
public class RMBPay implements PayStrategy {
    @Override
    public void pay(PayContext payContext) {
        //人民币结算
        log.info("现在给：" + payContext.getUserName() + "人民币支付：" + payContext.getMoney() + "元");
    }
}
