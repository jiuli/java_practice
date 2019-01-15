package pattern.bridge_pattern;

/* 培训活动 */
public class Training extends AbstractAction {
	public void doAction(String depart, String title) {
		if (depart.length() == 0) {
			System.out.println("这是部门的培训工作活动");
		}
		System.out.println("这是" + depart + "培训工作活动，" +
				"主题是" + title);
	}
}
