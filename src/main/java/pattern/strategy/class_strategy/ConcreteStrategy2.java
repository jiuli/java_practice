package pattern.strategy.class_strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/27 10:08
 * @since 1.0
 */
@Slf4j
public class ConcreteStrategy2 implements IStrategy {

    @Override
    public void algorithmMethod() {
      log.info("ConcreteStrategy2 algorithmMethod.......");
    }
}
