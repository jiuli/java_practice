package pattern.builder_pattern;

/**
 * 建造者模式中引入一个指挥者类Director,主要提供两个作用：
 * 1，它隔离了客户与创建过程。
 * 2，它控制产品的创建过程，包括某个部件方法的是否调用，以及部件方法调用的先后次序。
 * 现实例子：你去电脑城，买电脑，告诉销售人员要什么类型的，电脑，销售人员相当于
 * 指挥者，根据你的要求组装一台电脑。
 * 通过配置文件来存储具体建造者类ConcreteBuilder的类名，使得更换新的
 * 建造者时无须更改源代码，系统扩展更为方便。
 * 建造者模式与抽象工厂模式有点相似，但是建造者模式返回一个完整的复杂的产品，
 * 而抽象工厂模式返回一系列相关的产品。*/
public class Director {
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	
	//产品构建与组装方法
	public Product construct() {
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
		
		return builder.getResult();
	}
	
}
