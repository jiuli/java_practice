package pattern.strategy.multi_strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 攻取西川的上上策
 *
 * @author lijunsong
 * @date 2019/3/27 12:57
 * @since 1.0
 */
@Slf4j
public class UpperStrategy implements ITakeStrategy {

    @Override
    public void occupationWestOfXiChuan(String msg) {
        if (msg == null || msg.length() < 5) {
            //故意设置障碍，导致上上策失败
            log.info("由于计划泄露，上上策失败");
            int i = 100 / 0;
        }
        log.info("挑选精兵，昼夜兼行直接偷袭成都，可以一举而定,此为上计计也!");
    }
}
