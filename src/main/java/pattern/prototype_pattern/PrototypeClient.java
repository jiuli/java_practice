package pattern.prototype_pattern;
/* 原始模型测试 */
public class PrototypeClient {
	public static void main(String[] args) {
		
	CompanyBaseIntroduction company = new CompanyBaseIntroduction();
	
	AbstractPrototype depart_a = company.cloneMyself();
	
	depart_a.addSomeIntroduction("部门A介绍", "这是部门A介绍的内容");
	depart_a.showIntroduction();
	company.showIntroduction();
	
	AbstractPrototype depart_b = depart_a.cloneMyself();
	depart_b.deleteSomeIntroduction("部门A介绍");
	depart_b.addSomeIntroduction("部门B介绍", "这是部门B介绍的内容");
	depart_b.showIntroduction();
	
	WeeklyLog log = new WeeklyLog();
	log.setName("张卫健");
	log.setDate("第12周");
	log.setContent("这周工作很忙，每天加班!");
	
	System.out.println("***周报***");
	System.out.println("周次：" + log.getDate());
	System.out.println("姓名：" + log.getName());
	System.out.println("内容：" + log.getContent());
	System.out.println("-------------------------");
	
	WeeklyLog log_new;
	log_new = log.clone(); //调用克隆方法创建克隆对象
	log_new.setDate("第13周");
	System.out.println("***周报***");
	System.out.println("周次：" + log_new.getDate());
	System.out.println("姓名：" + log_new.getName());
	System.out.println("内容：" + log_new.getContent());
	System.out.println("-------------------------");
	
	System.out.println(log == log_new);
	System.out.println(log.getDate() == log_new.getDate());
	System.out.println(log.getName() == log_new.getName());
	System.out.println(log.getContent() == log_new.getContent());
	}
	
	
	
}
