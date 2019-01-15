package JDK8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.annotations.Filter;


/**
 * @Description: 重复注解@Repeatable
 */
public class RepeatingAnnotations {
    /*	这里的Filter类使用@Repeatable(Filters.class)注解修饰，
     * 	而Filters是存放Filter注解的容器，编译器尽量对开发者屏蔽这些细节
     * 这样，Filterable接口可以用两个Filter注解注释（这里并没有提到任何关于Filters的信息）。
     * 反射API提供了一个新的方法：getAnnotationsByType()，可以返回某个类型的重复注解，
     * 例如Filterable.class.getAnnoation(Filters.class)将返回两个Filter实例
     * */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        String value();

        String value2();
    }

    @Filter(value = "filter1", value2 = "111")
    @Filter(value = "filter2", value2 = "222")
    //@Filters({@Filter(  value="filter1",value2="111" ),@Filter(  value="filter2", value2="222")}).
    // 注意：JDK8之前：1.没有@Repeatable2.采用本行“注解容器”写法
    public interface Filterable {

    }

    public static void main(String[] args) {
        // 获取注解后，遍历打印值
        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value() + filter.value2());
        }
    }
}
