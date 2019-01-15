package AOP_JDK;

/*
 * 被代理类，即目标类target*/
public class AService implements Service{
	public void add(){
		System.out.println("AService add>>>>>>>>>>>>");
	}
	
	public void update(){
		System.out.println("AService update>>>>>>>>>>>>>>>");
	}
}
