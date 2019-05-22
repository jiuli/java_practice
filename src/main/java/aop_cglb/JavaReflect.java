package aop_cglb;

import entity.Student;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

/**
 * 反射
 * 加载-》连接（验证，准备，解析）-》初始化
 *
 * @author lijunsong
 * @date 2019/5/22 9:38
 * @since 1.0
 */
@Slf4j
public class JavaReflect {
    public static void main(String[] args) {
        Student student = new Student();
        //第一种获取Class对象方式
        Class cls1 = student.getClass();
        log.info(cls1.getName());

        //第二种获取方式
        Class cls2 = Student.class;
        log.info(String.valueOf((cls1 == cls2)));

        //第三种获取方式
        try {
            Class cls3 = Class.forName("entity.Student");
            log.info(String.valueOf(cls3 == cls2));
            /**
             * 一般都第三种，一个字符串可以传入也可写在配置文件中等多种方法
             */


            log.info("获取所有公有构造方法");
            Constructor[] constructors = cls3.getConstructors();
            for (Constructor c : constructors) {
                System.out.println(c);
            }
            log.info("获取所有public,private,protected,默认构造方法");
            Constructor[] constructors1 = cls3.getDeclaredConstructors();
            for (Constructor c : constructors1) {
                System.out.println(c);
            }
            log.info("获取所有无参数构造方法");
            Constructor constructor = cls3.getConstructor();
            System.out.println(constructor);

            /**
             * 调用构造方法
             */
            constructor.newInstance();

            log.info("获取私有构造方法，并调用");
            Constructor constructor1 = cls3.getDeclaredConstructor(Integer.class);
            System.out.println(constructor1);
            //设置可调用,暴力访问
            constructor1.setAccessible(true);
            constructor1.newInstance(11);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
