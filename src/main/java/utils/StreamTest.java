package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
	
	public static void main(String[] args) {
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
		projectDTOs.remove(new ProjectDTO("1","李四",new Date(2018,4,16),new Date(2019,7,16),10D));
		System.out.println(projectDTOs.stream().map(ProjectDTO::getProjectName).collect(Collectors.toSet()).contains("111"));
		
		System.out.println(projectDTOs.stream().map(ProjectDTO::getProjectName).collect(Collectors.joining(",")));
		ProjectDTO projectDTO1 = new ProjectDTO("1","李四",new Date(2018,4,16),new Date(2019,7,16),10D);
		ProjectDTO projectDTO2 = new ProjectDTO("1","王二",new Date(2018,4,14),new Date(2019,3,16),12D);
		ProjectDTO projectDTO3 = new ProjectDTO("1","天意",new Date(2018,7,16),new Date(2019,8,16),5D);
		projectDTOs.add(projectDTO1);
		projectDTOs.add(projectDTO2);
		projectDTOs.add(projectDTO3);
		
		System.out.println("拼接对象中某个字段");
		System.out.println(projectDTOs.stream().map(ProjectDTO::getProjectName).collect(Collectors.joining(",")));
		
		System.out.println("得到最大结束时间对象");
		System.out.println(Collections.max(projectDTOs, new Comparator<ProjectDTO>(){
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
		System.out.println(Collections.max(projectDTOs, new Comparator<ProjectDTO>(){
			@Override
			public int compare(ProjectDTO arg0, ProjectDTO arg1) {
				// TODO Auto-generated method stub
				if (arg0.getStartDate().before(arg1.getStartDate())) {
					return 1;
				}
				return 0;
			}
			}).getProjectName());
		
		}
}
