package utils;

public class Student {
	private long id;

    private String name;

    private int age;

    private int grade;

    private String major;

    private String school;

	public long getId() {
		return id;
	}

	public Student(long id, String name, int age, int grade, String major, String school) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.major = major;
		this.school = school;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
    
}
