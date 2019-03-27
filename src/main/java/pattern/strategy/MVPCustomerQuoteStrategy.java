package pattern.strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * MVP客户
 *
 * @author lijunsong
 * @date 2019/3/27 10:26
 * @since 1.0
 */
@Slf4j
public class MVPCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        log.info("MVP客户6折");
        return originalPrice.multiply(new BigDecimal(0.6)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
