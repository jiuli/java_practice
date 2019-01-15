package pattern.bridge_pattern;

/* 结构型模式 ：可以让你把类或对象组合到更大的结构中
 * 桥梁（Bridge）模式：将抽象部分与它的实现部分分离，使它们都可以独立地变化。*/
/* 实现化角色 implementor*/
public abstract class AbstractAction {
	public void doAction(String depart, String title) {
		if (depart.length() == 0) {
			System.out.println("这是部门的标准工作活动");
		}
		
		System.out.println("这是" + depart + "部门的标准工作活动，" +
				"主题是" + title);
		
	}
}
