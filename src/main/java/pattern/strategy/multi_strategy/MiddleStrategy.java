package pattern.strategy.multi_strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 中计划
 * @author lijunsong
 * @date 2019/3/27 13:37
 * @since 1.0
 */
@Slf4j
public class MiddleStrategy implements ITakeStrategy {
    @Override
    public void occupationWestOfXiChuan(String msg) {
      log.info("杨怀、高沛是蜀中名将，手下有精锐部队，而且据守关头，我们可以装作要回荆州，引他们轻骑来见，可就此将其擒杀，而后进兵成都，此为中计。");
    }
}
