package pattern.strategy;

import java.math.BigDecimal;

/**
 * 上面存在的问题：把不同客户的报价的算法都放在了同一个方法里面，使得该方法很是庞大
 *
 * @author lijunsong
 * @date 2019/3/27 10:02
 * @since 1.0
 */
public class QuteManager {
    public BigDecimal quote(BigDecimal originalPrice, String type) {
        if ("新客户".equals(type)) {
            return this.quoteNewCustomer(originalPrice);
        } else if ("老客户".equals(type)) {
            return this.quoteOldCustomer(originalPrice);
        } else if ("VIP客户".equals(type)) {
            return this.quoteVIPCustomer(originalPrice);
        }
        //其他人员都是原价
        return originalPrice;
    }

    /**
     * 对VIP客户的报价算法
     *
     * @param originalPrice 原价
     * @return 折后价
     */
    private BigDecimal quoteVIPCustomer(BigDecimal originalPrice) {
        System.out.println("恭喜！VIP客户打8折");
        originalPrice = originalPrice.multiply(new BigDecimal(0.8)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }

    /**
     * 对老客户的报价算法
     *
     * @param originalPrice 原价
     * @return 折后价
     */
    private BigDecimal quoteOldCustomer(BigDecimal originalPrice) {
        System.out.println("恭喜！老客户打9折");
        originalPrice = originalPrice.multiply(new BigDecimal(0.9)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }

    /**
     * 对新客户的报价算法
     *
     * @param originalPrice 原价
     * @return 折后价
     */
    private BigDecimal quoteNewCustomer(BigDecimal originalPrice) {
        System.out.println("抱歉！新客户没有折扣！");
        return originalPrice;
    }
}
