package utils;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamTest {

    public static void main(String[] args) {
        User one = new User("阿大,阿大21,阿大", 18);
        User two = new User("阿二,阿大", 16);
        User three = new User("阿三", 14);
        one.setToyArray(new Toy[]{new Toy("熊大", "棕色"), new Toy("黑猫警长", "黑白色")});
        two.setToyArray(new Toy[]{new Toy("手枪", "黑色"), new Toy("小汽车", "红色")});
        three.setToyArray(new Toy[]{new Toy("不倒翁", "黄色"), new Toy("铁环", "灰色")});


        User[] userArray = {one, two, three};
        Arrays.stream(userArray).map(User::getToyArray)
                .flatMap(Arrays::stream).map(Toy::getColor).forEach(System.out::println);
        System.out.println("////////////////////////////////////////////////////////////////////////////////////");

        Stream.of(userArray).map(User::getToyArray)
                .flatMap(Arrays::stream).map(Toy::getColor).forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------------");

        /**
         * 集合
         */
        List<User> userList = Arrays.asList(one, two, three);

        //得到List<String[]>
        List nameList = userList.stream().map(User::getName).collect(Collectors.toList())
                .stream().map(name -> name.split(","))
                .collect(Collectors.toList());
        //使用flatMap合并collect,得到一个扁平collect
        List<String> names = userList.stream().map(User::getName).collect(Collectors.toList())
                .stream().map(name -> name.split(","))
                .flatMap(Arrays::stream).distinct().collect(Collectors.toList());

        one.setToys(Arrays.asList(new Toy("熊大", "棕色"), new Toy("黑猫警长", "黑白色")));
        two.setToys(Arrays.asList(new Toy("手枪", "黑色"), new Toy("小汽车", "红色")));
        three.setToys(Arrays.asList(new Toy("不倒翁", "黄色"), new Toy("铁环", "灰色")));


        userList.stream().map(User::getToys)
                .flatMap(toy -> toy.stream()).map(Toy::getColor).forEach(System.out::println);
        System.out.println("=====================================================================================");

        userList.stream().map(User::getToys)
                .flatMap(Collection::stream).map(Toy::getColor).forEach(System.out::println);
        System.out.println("===================================并行流=============================================");
        userList.stream().map(User::getToys)
                .flatMap(toy -> toy.parallelStream()).map(Toy::getColor).forEach(System.out::println);

        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };
        System.out.println("一个流式处理可以分为三个部分：转换成流、中间操作、终端操作");
        System.out.println(students.stream()
                .filter(student -> "南京大学".equals(student.getSchool()))
                .collect(Collectors.toList()));


        List<ProjectDTO> projectDTOList = new ArrayList<>();
        List<ProjectDTO> projectDTOs = new ArrayList<>();
        projectDTOs.remove(new ProjectDTO("1", "李四", new Date(2018, 4, 16), new Date(2019, 7, 16), 10D));
        System.out.println(projectDTOs.stream().map(ProjectDTO::getProjectName).collect(Collectors.toSet()).contains("111"));

        System.out.println(projectDTOs.stream().map(ProjectDTO::getProjectName).collect(Collectors.joining(",")));
        ProjectDTO projectDTO1 = new ProjectDTO("1", "李四", new Date(2018, 4, 16), new Date(2019, 7, 16), 10D);
        ProjectDTO projectDTO2 = new ProjectDTO("1", "王二", new Date(2018, 4, 14), new Date(2019, 3, 16), 12D);
        ProjectDTO projectDTO3 = new ProjectDTO("1", "天意", new Date(2018, 7, 16), new Date(2019, 8, 16), 5D);
        projectDTOs.add(projectDTO1);
        projectDTOs.add(projectDTO2);
        projectDTOs.add(projectDTO3);

        System.out.println("拼接对象中某个字段");
        System.out.println(projectDTOs.stream().map(ProjectDTO::getProjectName).collect(Collectors.joining(",")));

        System.out.println("得到最大结束时间对象");
        System.out.println(Collections.max(projectDTOs, new Comparator<ProjectDTO>() {
            @Override
            public int compare(ProjectDTO arg0, ProjectDTO arg1) {
                // TODO Auto-generated method stub
                if (arg0.getEndDate().after(arg1.getEndDate())) {
                    return 1;
                }
                return 0;
            }
        }).getProjectName());

        System.out.println("得到最小开始时间对象");
        System.out.println(Collections.max(projectDTOs, new Comparator<ProjectDTO>() {
            @Override
            public int compare(ProjectDTO arg0, ProjectDTO arg1) {
                // TODO Auto-generated method stub
                if (arg0.getStartDate().before(arg1.getStartDate())) {
                    return 1;
                }
                return 0;
            }
        }).getProjectName());

        System.out.println("reduce测试示例");

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        log.info(String.valueOf(integers.stream().reduce(Integer::sum).get()));
        // 可以给一个起始种子值
        log.info(String.valueOf(integers.stream().reduce(2, Integer::sum)));
        //直接用sum方法
        log.info(String.valueOf(integers.stream().mapToInt(i -> i).sum()));
        //concat
        List<String> strs = Arrays.asList("J", "a", "s", "o", "n");
        log.info(strs.stream().reduce(String::concat).get());
        log.info(strs.stream().reduce(",", String::concat));

        log.info(String.valueOf(integers.stream().reduce(Integer.MAX_VALUE, Integer::min)));
        log.info(String.valueOf(integers.stream().mapToInt(i -> i).min().getAsInt()));
        log.info(String.valueOf(integers.stream().mapToInt(i -> i).max().getAsInt()));
        log.info(String.valueOf(integers.stream().reduce(Integer.MIN_VALUE, Integer::max)));
    }
}
