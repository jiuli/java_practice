package pattern.mutil_pattern;
/**
 * 鸭子模拟器--通过抽象工厂模式来创建鸭子对象*/
public class DuckSimulator_3 {
	public static void main(String[] args){
		DuckSimulator_3 sim = new DuckSimulator_3();
		AbstractDuckFactory d_factory = new CountingDuckFactory();
		sim.simulate(d_factory);
	}
	
	public void simulate(AbstractDuckFactory d_factory){
		IQuackable m_duck = d_factory.createMallardDuck();
		IQuackable red_duck = d_factory.createRedheadDuck();
		IQuackable c_duck = d_factory.createDuckCall();
		IQuackable rub_duck = d_factory.createRubberDuck();
		IQuackable g_duck = new GooseAdapter(new Goose());
		System.out.println("\n Duck Simulator:With Abstract Factory ");
		
		simulate(m_duck);
		simulate(red_duck);
		simulate(c_duck);
		simulate(rub_duck);
		/*通过适配器 将鹅也配置进来*/
		simulate(g_duck);
		
		System.out.println("The ducks quaked " + QuackCounter.getNumber_of_quacks() + " times");
	}
	
	public void simulate(IQuackable duck){
		duck.quack();
	}
}
