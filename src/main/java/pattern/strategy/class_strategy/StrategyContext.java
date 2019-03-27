package pattern.strategy.class_strategy;

/**
 * 策略上下文
 *
 * @author lijunsong
 * @date 2019/3/27 10:09
 * @since 1.0
 */
public class StrategyContext {
    private IStrategy strategy;

    //使用构造器注入具体策略类
    public StrategyContext(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void contextMethod() {
        //调用策略实现的方法
        this.strategy.algorithmMethod();
    }
}
