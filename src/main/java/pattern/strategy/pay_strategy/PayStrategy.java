package pattern.strategy.pay_strategy;

/**
 * @author lijunsong
 * @date 2019/3/27 14:01
 * @since 1.0
 */
public interface PayStrategy {
    /**
     * 在支付策略方法根据上下文做参数，在具体支付方法中调用上下文中的方法获取对应数据
     * @param payContext
     */
    void pay(PayContext payContext);
}
