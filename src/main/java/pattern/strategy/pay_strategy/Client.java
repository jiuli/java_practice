package pattern.strategy.pay_strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author lijunsong
 * @date 2019/3/27 14:09
 * @since 1.0
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        PayStrategy rmbStrategy = new RMBPay();
        PayStrategy dollarStrategy = new DollarPay();

        log.info("准备小王的支付上下文");
        PayContext context = new PayContext("小霞", new BigDecimal(60000), rmbStrategy);
        context.pay();


        log.info("准备给Tomas的支付上下文");
        context = new PayContext("Tomas", new BigDecimal(30000), dollarStrategy);
        context.pay();

        AccountPay accountPay = new AccountPay();
        log.info("准备给小马的银行支付上下文");
        context = new AccountPayContext("小马", new BigDecimal(100000), "72081212121212222", accountPay);
        context.pay();

        //不从上下文中获取银行账户参数
        AccountPay1 accountPay1 = new AccountPay1("62224354352u524352345");
        log.info("准备给小马的银行支付上下文");
        context = new PayContext("小马", new BigDecimal(100000), accountPay1);
        context.pay();

    }
}
