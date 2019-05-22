package entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/5/22 9:41
 * @since 1.0
 */
@Data
@Slf4j
public class Student {
    private String name;
    private String code;
    private Integer age;

    Student(String name) {
        log.info(String.format("构造方法%s", name));
    }

    public Student() {
        log.info("无参数构造方法");
    }

    public Student(String name, int age) {
        //这的执行效率有问题，以后解决。  
        log.info("姓名：" + name + "年龄：" + age);
    }

    //受保护的构造方法  
    protected Student(boolean n) {
        log.info("受保护的构造方法 n = " + n);
    }

    //私有构造方法
    private Student(Integer age) {
        log.info("私有的构造方法   年龄：" + age);
    }
}
