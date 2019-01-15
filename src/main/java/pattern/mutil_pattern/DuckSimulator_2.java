package pattern.mutil_pattern;
/**
 * 鸭子模拟器--调用装饰者给鸭子计算叫声次数*/
public class DuckSimulator_2 {
	public static void main(String[] args){
		DuckSimulator_2 sim = new DuckSimulator_2();
		sim.simulate();
	}
	
	public void simulate(){
		IQuackable m_duck = new QuackCounter(new MallardDuck());
		IQuackable red_duck = new QuackCounter(new RedheadDuck());
		IQuackable c_duck = new QuackCounter(new DuckCall());
		IQuackable rub_duck = new QuackCounter(new RubberDuck());
		IQuackable g_duck = new GooseAdapter(new Goose());
		System.out.println("\n Duck Simulator");
		
		simulate(m_duck);
		simulate(red_duck);
		simulate(c_duck);
		simulate(rub_duck);
		/*通过适配器 将鹅也配置进来*/
		simulate(g_duck);
		
		/* 收集叫声次数 */
		System.out.println("The ducks quacked "+ QuackCounter.getNumber_of_quacks()+" times");
	}
	
	public void simulate(IQuackable duck){
		duck.quack();
	}
}
