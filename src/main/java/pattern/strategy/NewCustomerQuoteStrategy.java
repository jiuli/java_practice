package pattern.strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 新客户报价策略实现类
 *
 * @author lijunsong
 * @date 2019/3/27 10:14
 * @since 1.0
 */
@Slf4j
public class NewCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        log.info("抱歉，新客户没有折扣");
        return originalPrice;
    }
}
