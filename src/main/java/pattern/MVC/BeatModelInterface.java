package pattern.MVC;

/**
 * V-C：使用策略模式，V输入指令，调用C算法返回对应数据给V。
 * M-V：使用观察者模式，M提供注册接口、并引用V提供的改变状态的接口，V提供改变状态的接口、并提供引用M注册接口。
 * V:使用组合模式，视图是GUI组件（标签，窗口，文本输入等）的组合。顶层的组件包含其他组件，直到叶子节点。*/
public interface BeatModelInterface {
	public void initialize(); //初始化BeatModel
	
	public void on();  
	public void off();
	
	public void setBPM(int bpm); 
	
	public int getBPM();
	
	public void registerObserver(IBeatObserver o);
	public void removeObserver(IBeatObserver o);
	public void registerObserver(IBPMObserver o);
	public void removeObserver(IBPMObserver o);
	
}
