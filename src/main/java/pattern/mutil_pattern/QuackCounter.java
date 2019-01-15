package pattern.mutil_pattern;
/** 通过装饰者模式 为鸭子对象添加计算叫声次数的方法*/
public class QuackCounter implements IQuackable {
	IQuackable duck;
	static int number_of_quacks;
	
	public QuackCounter(IQuackable duck) {
		this.duck = duck;
	}
	
	public void quack() {
		duck.quack();
		number_of_quacks ++;
	}
	
	public static int getNumber_of_quacks(){
		return number_of_quacks;
	}
	
}
