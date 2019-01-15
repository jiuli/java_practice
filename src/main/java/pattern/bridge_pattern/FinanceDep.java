package pattern.bridge_pattern;

public class FinanceDep extends AbstractDepartment {
	private String depart_name = "财务部";
	
	public void action(String title){
		depart_action.doAction(depart_name, title);
	}
}
