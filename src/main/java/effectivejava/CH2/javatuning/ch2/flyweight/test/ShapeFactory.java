package effectivejava.CH2.javatuning.ch2.flyweight.test;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author lijunsong
 * @date 2019/3/26 13:20
 * @since 1.0
 */
@Slf4j
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            log.info("Create circle of color:" + color);
        }
        return circle;
    }
}
