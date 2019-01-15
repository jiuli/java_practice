package JDK8;
/**
 * @Description: JDK8新特性
 */

import com.google.common.collect.Lists;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class JDK8_features {
    public List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    /* 1, Lambda表达式
     * */
    @Test
    public void testLambda() {
        list.forEach(System.out::println);

        list.forEach(e -> System.out.println("方式二：" + e));
    }

    /* 2, Stream函数式操作流元素集合
     * */
    @Test
    public void testStream() {
        List<Integer> nums = Lists.newArrayList(2, 2, null, 5, 3, null, 6, 9, 10);
        System.out.println("求和：" + nums.stream() //转成stream
                .filter(element -> element != null) //过滤
                .distinct()  //去重
                .mapToInt(element -> element * 2) //元素
                .skip(2)  //跳过前2个元素
                .limit(4) //限制取前四个元素
                .peek(System.out::println) //流式
                .sum()  //求和
        );
    }

    /* 3, 接口增加了：默认方法和静态方法
     *   default 接口默认实现方法是为了让集合类默认实现这些函数式处理，而不用修改现有代码
     *   如：（List继承与Iterable<T>,接口默认方法不必须实现default forEach方法）
     * */
    @Test
    public void testDefaultFunctionInteface() {
        //可以直接使用接口名.静态方法来访问接口中的静态方法
        JDK8Interface.staticMethod();
        //接口中的默认方法必须通过它的实现类来调用
        new JDK8InterfaceImpl().defaultMethod();

        //多实现类，默认方法重名是必须复写
        new JDK8InterfaceImpl2().defaultMethod();
    }

    public class JDK8InterfaceImpl implements JDK8Interface {
        // 实现接口后，因为默认方法不是抽象方法，重写不重写都可以。
    }

    public class JDK8InterfaceImpl2 implements JDK8Interface, JDK8Interface2 {
        // 实现多接口，默认方法相同，必须复写默认方法。
        @Override
        public void defaultMethod() {
            // TODO Auto-generated method stub
            JDK8Interface.super.defaultMethod();
            System.out.println("实现类复写重名默认方法。");
        }
    }

    /* 4, 方法引用，与Lambda表达式联合使用
     * */
    @Test
    public void testMethodReference() {
        //构造器引用。 语法是Class::new,或者Class<T>::new,要求构造器方法无参数
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        // 静态方法引用。语法是Class::static_method,要求接受一个Class参数
        cars.forEach(Car::collide);
        // 任意对象的方法引用。语法是Class::method.无参
        cars.forEach(Car::repair);
        // 特定对象的方法引用，语法是instance::method.有参数，在某个对象上调用方法，将列表元素作为参数传入；
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }

    public static class Car {
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("静态方法引用：" + car.toString());
        }

        public void repair() {
            System.out.println("任意对象的方法引用: " + this.toString());
        }

        public void follow(final Car car) {
            System.out.println("特定对象的方法引用：" + car.toString());
        }
    }

    /* 5，引入重复注解 @Repeatable
     *  可以不用以前的'注解容器'写法，直接写2次相同注解即可
     *  Java-8在编译器层做了优化，相同注解会以集合的方式保存，因此底层的原理并没有变化
     * */
    @Test
    public void RepeatingAnnotations() {
        RepeatingAnnotations.main(null);
    }

    /* 6,类型注解
     * 新增类型注解： Element
     * */
    @Test
    public void ElementType() {
        Annotations.main(null);
    }

    /* 7,最新的Date/Time API（JSR 310)
     * */
    @Test
    public void DateTime() {
        // 1,Clock
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        // 2, ISO-8610格式并且无时区信息的日期部分
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);

        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromClock);

        // 3,ISO-8610格式并且无时区信息的日期和时间
        final LocalDateTime dateTime = LocalDateTime.now();
        final LocalDateTime dateTimeFromClock = LocalDateTime.now(clock);
        System.out.println(dateTime);
        System.out.println(dateTimeFromClock);

        // 4，特定时区的日期/时间
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClock = zonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeFromClock);
        System.out.println(zonedDateTimeFromZone);

        // 5,在秒与纳秒级别上的一段时间
        final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);
        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());
    }

    /* 8,新增base64加解密API
     * */
    @Test
    public void testBase64() {
        final String text = "加密假药停";
        String encoded = Base64.getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println("加密后：" + encoded);

        final String decoded = new String(
                Base64.getDecoder().decode(encoded),
                StandardCharsets.UTF_8);
        System.out.println("解密后：" + decoded);
    }

    /* 9, 数组并行操作
     * */
    @Test
    public void testParallel() {
        long[] arrayOfLong = new long[2000];

        //1，给数组随机赋值
        Arrays.parallelSetAll(arrayOfLong,
                element -> ThreadLocalRandom.current().nextInt(100000));

        //2，打印前10个元素
        Arrays.stream(arrayOfLong).limit(10).forEach(
                element -> System.out.print(element + " "));
        System.out.println();
        //3,数组排序
        Arrays.parallelSort(arrayOfLong);

        //4.打印排序后的前10个元素
        Arrays.stream(arrayOfLong).limit(10).forEach(
                element -> System.out.print(element + " ")
        );
        System.out.println();
    }

    /* 10, JVM的PermGen空间被移除，取代它的是Metaspace元空间
     * */
    @Test
    public void testMetaspace() {
        //-XX:MetaspaceSize初始空间大小，达到该值就会触发垃圾收集进行类型卸载，同时GC会对该值进行调整
        //-XX:MaxMetaspaceSize最大空间，默认是没有限制
        //-XX:MinMetaspaceFreeRatio在GC之后，最小的Metaspace剩余空间容量的百分比，减少为分配空间所导致的垃圾收集
        //-XX:MaxMetaspaceFreeRatio在GC之后，最大的Metaspace剩余空间容量的百分比，减少为释放空间所导致的垃圾收集
    }

    /* 11,更好的类型推断
     * */

    /* 12,获取方法的参数名称
     * */

    /* 13,空值异常 Optional
     * */
    @Test
    public void testOptional() {
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
    }
}
