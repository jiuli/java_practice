package aop_cglb;

import entity.Student;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

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


            //获取Student中main方法
            Method method1 = cls3.getMethod("main", String[].class);
            //调用方法
            method1.invoke(null, (Object) new String[]{"1"});
            //或者
            method1.invoke(null, new Object[]{new String[]{"1"}});


            /**
             * 泛型用在编译期，编译过后泛型擦除（消失掉）。所以是可以通过反射越过泛型检查的
             */
            ArrayList<String> strList = new ArrayList<>();
            strList.add("aaa");
            strList.add("bbb");

            //  strList.add(100);
            //获取ArrayList的Class对象，反向的调用add()方法，添加数据
            //得到 strList 对象的字节码 对象
            Class listClass = strList.getClass();
            //获取add()方法
            Method m = listClass.getMethod("add", Object.class);
            //调用add()方法
            m.invoke(strList, 100);

            //遍历集合
            for (Object obj : strList) {
                System.out.println(obj);
            }

            /**
             * 从文件反射
             */
            Class cls4 = Class.forName(getValueFormFile("className"));
            Method method2 = cls4.getMethod(getValueFormFile("methodName"));
            //调用show方法
            method2.invoke(cls4.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValueFormFile(String key) throws IOException {
        Properties pro = new Properties();
        try (FileReader in = new FileReader("/aop_cglb/reflect.txt")) {
            pro.load(in);
        }

        return pro.getProperty(key);
    }
}
