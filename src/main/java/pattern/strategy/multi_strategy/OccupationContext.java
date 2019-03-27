package pattern.strategy.multi_strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/27 13:40
 * @since 1.0
 */
@Slf4j
public class OccupationContext {
    /**
     * 攻取西川参谋部，就是上下文啦，由上下文来选择具体的策略
     */
    public void occupationWestOfXiChuan(String msg) {
        log.info(msg);
        //先用上上策
        ITakeStrategy takeStrategy = new UpperStrategy();
        try {
            takeStrategy.occupationWestOfXiChuan(msg);
        } catch (Exception e) {
            log.info("这个给手下的人激励不够，用中计策");
            takeStrategy = new MiddleStrategy();
            takeStrategy.occupationWestOfXiChuan(msg);
        }
    }
}
