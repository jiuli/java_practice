package pattern.bridge_pattern;
/**
 * 抽象和实现各自成为一个对象体系，它们由一个桥连接起来，
 * 可以各自发展各自的对象层次，而不必顾虑另一方面。
 * 这就是Bridge模式所提供的思想。*/
/* 测试桥接模式*/
public class Client {
	public static void main(String[] args) {
		sceneOne();
		sceneTwo();
		sceneThree();
	}
	public static void sceneOne() {
		//场景1：针对开发部的培训工作
		AbstractAction action = new Training(); //培训
		AbstractDepartment depart = new DevelopmentDep(); //开发部
		depart.setAbstractAction(action); //委托培训
		depart.action("提高开发技能");
	}
	
	public static void sceneTwo() {
		//场景2：针对财务部的会议
		AbstractAction action = new Meeting();
		AbstractDepartment depart = new FinanceDep();
		depart.setAbstractAction(action); //委托会议
		depart.action("检查会计制度");
	}
	
	public static void sceneThree() {
		//场景3：针对市场部的培训
		AbstractAction action = new Training();
		AbstractDepartment depart = new MarketDep();
		depart.setAbstractAction(action);
		depart.action("沟通技巧");
	}

}
