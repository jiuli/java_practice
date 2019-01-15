package pattern.bridge_pattern;

public class MarketDep extends AbstractDepartment {
	private String depart_name = "市场部";
	
	public void action(String title) {
		depart_action.doAction(depart_name, title);
	}
}
