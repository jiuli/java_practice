package pattern.strategy.multi_strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 下策
 *
 * @author lijunsong
 * @date 2019/3/27 13:38
 * @since 1.0
 */
@Slf4j
public class LowerStrategy implements ITakeStrategy {
    @Override
    public void occupationWestOfXiChuan(String msg) {
        log.info("退还白帝，连引荆州，慢慢进图益州，此为下计。");
    }
}
