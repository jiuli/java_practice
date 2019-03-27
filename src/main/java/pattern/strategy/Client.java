package pattern.strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author lijunsong
 * @date 2019/3/27 10:22
 * @since 1.0
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        IQuoteStrategy oldQuoteStrategy = new OldCustomerQuoteStrategy();
        QuoteContext quoteContext = new QuoteContext(oldQuoteStrategy);

        BigDecimal price = quoteContext.getPrice(new BigDecimal(100));
        log.info("折扣价格：" + price);

        IQuoteStrategy mvpQuoteStrategy = new MVPCustomerQuoteStrategy();
        QuoteContext quoteContext1 = new QuoteContext(mvpQuoteStrategy);
        BigDecimal price1 = quoteContext1.getPrice(new BigDecimal(100));
        log.info("折扣价格：" + price1);
    }
}
