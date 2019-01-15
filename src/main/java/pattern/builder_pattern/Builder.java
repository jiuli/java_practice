package pattern.builder_pattern;
/**
 * 在抽象建造者类定义产品的创建方法和返回方法*/
public abstract class Builder {
	//创建产品对象
	protected Product product = new Product();
	
	public abstract void buildPartA();
	public abstract void buildPartB();
	public abstract void buildPartC();
	
	//返回产品对象
	public Product getResult() {
		return product;
	}
}
