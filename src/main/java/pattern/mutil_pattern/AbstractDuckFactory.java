package pattern.mutil_pattern;

/* 创建不同类型的鸭子的集合，使用抽象工厂模式*/
public abstract class AbstractDuckFactory {
	public abstract IQuackable createDuckCall();
	public abstract IQuackable createRubberDuck();
	public abstract IQuackable createRedheadDuck();
	public abstract IQuackable createMallardDuck();
	
}
