package effectivejava.CH2.javatuning.ch2.flyweight.test;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/26 13:18
 * @since 1.0
 */
@Slf4j
@Setter
public class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        log.info("Circel: Draw() color:" + color + ",x:" + x + ",y:" + y + ",radius:" + radius);
    }

}
