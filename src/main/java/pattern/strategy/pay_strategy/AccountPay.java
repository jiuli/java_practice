package pattern.strategy.pay_strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/27 14:16
 * @since 1.0
 */
@Slf4j
public class AccountPay implements PayStrategy {

    /**
     * 要新增一个银行账户的支付策略
     * 由于需要从上下文中获取数据，为了不修改已有的上下文，
     * 我们可以通过继承已有的上下文来扩展一个新的带有银行账户的上下文AccountPayContext，
     * 然后再客户端中使用新的策略实现和带有银行账户的上下文，这样之前已有的实现完全不需要改动，遵守了开闭原则
     */
    @Override
    public void pay(PayContext payContext) {
        AccountPayContext accountPayContext = (AccountPayContext) payContext;
        log.info("现在给" + accountPayContext.getUserName() + "的账户" + accountPayContext.getAccount() + "转账" +
                accountPayContext.getMoney() + "元");
    }

}
