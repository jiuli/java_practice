package pattern.mutil_pattern;
/**
 * 鸭子模拟器--通过组合模式来统一管理鸭子*/
public class DuckSimulator_4 {
	public static void main(String[] args){
		DuckSimulator_4 sim = new DuckSimulator_4();
		AbstractDuckFactory d_factory = new CountingDuckFactory();
		sim.simulate(d_factory);
	}
	
	public void simulate(AbstractDuckFactory d_factory){
		IQuackable m_duck = d_factory.createMallardDuck();
		IQuackable red_duck = d_factory.createRedheadDuck();
		IQuackable c_duck = d_factory.createDuckCall();
		IQuackable rub_duck = d_factory.createRubberDuck();
		IQuackable goose_duck = new GooseAdapter(new Goose());
		System.out.println("\n Duck Simulator:With Composite ");
		
		Flock f_ducks = new Flock();//flock 群 大堆 大量
		//创建一群鸭子，主群
		f_ducks.add(m_duck);
		f_ducks.add(c_duck);
		f_ducks.add(rub_duck);
		f_ducks.add(red_duck);
		f_ducks.add(goose_duck);
		
		Flock f_of_calls = new Flock();
		//创建都是duckCall的鸭子群
		IQuackable c_duck_1 = d_factory.createDuckCall();
		IQuackable c_duck_2 = d_factory.createDuckCall();
		IQuackable c_duck_3 = d_factory.createDuckCall();
		IQuackable c_duck_4 = d_factory.createDuckCall();
		f_of_calls.add(c_duck_1);
		f_of_calls.add(c_duck_2);
		f_of_calls.add(c_duck_3);
		f_of_calls.add(c_duck_4);
		
		f_ducks.add(f_of_calls); //duckCall的鸭子群 并入主群f_ducks
		
		System.out.println("\n Duck Simulator:Whole Flock Simulation");
		simulate(f_ducks);
		System.out.println("\n Duck Simulator:duckCall Flock Simulation");
		simulate(f_of_calls);
		System.out.println("\n The ducks quakced"+QuackCounter.getNumber_of_quacks() + " times");
	}
	
	public void simulate(IQuackable duck){
		duck.quack();
	}
}
