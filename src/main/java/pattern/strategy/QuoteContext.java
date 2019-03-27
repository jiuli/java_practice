package pattern.strategy;

import java.math.BigDecimal;

/**
 * @author lijunsong
 * @date 2019/3/27 10:19
 * @since 1.0
 */
public class QuoteContext {
    /**
     * 持有一个具体的报价策略
     */
    private IQuoteStrategy quoteStrategy;

    /**
     * 注入报价策略
     */
    public QuoteContext(IQuoteStrategy quoteStrategy) {
        this.quoteStrategy = quoteStrategy;
    }

    /**
     * 回调具体报价策略的方法
     */
    public BigDecimal getPrice(BigDecimal originalPrice) {
        return quoteStrategy.getPrice(originalPrice);
    }
}
