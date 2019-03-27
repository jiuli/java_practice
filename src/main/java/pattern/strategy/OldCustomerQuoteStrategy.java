package pattern.strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 老客户报价策略实现类
 *
 * @author lijunsong
 * @date 2019/3/27 10:16
 * @since 1.0
 */
@Slf4j
public class OldCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        log.info("老客户8折优惠");
        return originalPrice.multiply(new BigDecimal(0.8)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
