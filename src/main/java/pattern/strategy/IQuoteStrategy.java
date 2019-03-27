package pattern.strategy;

import java.math.BigDecimal;

/**
 * @author lijunsong
 * @date 2019/3/27 10:12
 * @since 1.0
 */
public interface IQuoteStrategy {
    /**
     * 获取折后的价格
     *
     * @param originalPrice
     * @return
     */
    BigDecimal getPrice(BigDecimal originalPrice);
}
