package pattern.mutil_pattern;
/**
 * 鸭子模拟器*/
public class DuckSimulator {
	public static void main(String[] args){
		DuckSimulator sim = new DuckSimulator();
		sim.simulate();
	}
	
	public void simulate(){
		IQuackable m_duck = new MallardDuck();
		IQuackable red_duck = new RedheadDuck();
		IQuackable c_duck = new DuckCall();
		IQuackable rub_duck = new RubberDuck();
		IQuackable g_duck = new GooseAdapter(new Goose());
		System.out.println("\n Duck Simulator");
		
		simulate(m_duck);
		simulate(red_duck);
		simulate(c_duck);
		simulate(rub_duck);
		/*通过适配器 将鹅也配置进来*/
		simulate(g_duck);
	}
	
	public void simulate(IQuackable duck){
		duck.quack();
	}
}
