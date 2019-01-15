package pattern.bridge_pattern;

public class DevelopmentDep extends AbstractDepartment {
	private String depart_name = "开发部";
	
	public void action(String title) {
		depart_action.doAction(depart_name, title);
	}
}
