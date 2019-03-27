package pattern.strategy.class_strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/27 10:07
 * @since 1.0
 */
@Slf4j
public class ConcreteStrategy implements IStrategy {

    @Override
    public void algorithmMethod() {
        //具体实现
        log.info("ConcreteStrategy algorithmMethod.....");
    }
}
