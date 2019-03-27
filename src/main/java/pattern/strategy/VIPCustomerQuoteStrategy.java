package pattern.strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * VIP客户报价实现类
 *
 * @author lijunsong
 * @date 2019/3/27 10:18
 * @since 1.0
 */
@Slf4j
public class VIPCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        log.info("VIP客户7折优惠");
        return originalPrice.multiply(new BigDecimal(0.7)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
