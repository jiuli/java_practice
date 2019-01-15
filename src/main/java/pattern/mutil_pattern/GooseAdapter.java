package pattern.mutil_pattern;
/**
 * 使用适配器模式将鹅适配成鸭子*/
public class GooseAdapter implements IQuackable{
	Goose goose;
	public GooseAdapter(Goose goose){
		this.goose = goose;
	}
	
	public void quack(){
		goose.honk();
	}
}
