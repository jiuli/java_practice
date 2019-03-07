package utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lijunsong
 * @date 2019/3/7 11:48
 * @since 1.0
 */
@Data
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private List<Toy> toys;
    private Toy[] toyArray;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
