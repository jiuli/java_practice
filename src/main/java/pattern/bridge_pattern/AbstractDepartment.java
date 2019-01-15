package pattern.bridge_pattern;
/* 抽象化角色 Abstraction */
public abstract class AbstractDepartment {
	protected AbstractAction depart_action;
	public void setAbstractAction(AbstractAction action) {
		depart_action = action;
	}
	public void action(String title) {
		depart_action.doAction("", title);
	}
}
