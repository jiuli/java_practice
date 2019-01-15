package pattern.bridge_pattern;
/* 会议活动*/
public class Meeting extends AbstractAction {
	public void doAction(String depart, String title) {
		if (depart.length() == 0) {
			System.out.println("这是部门的会议工作活动");
		}
		System.out.println("这是" + depart + "会议工作活动，" +
				"主题是" + title);
	}
}
