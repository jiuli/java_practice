package pattern.mutil_pattern;


/**
 *  与使用统一管理鸭子相反，现在需要观察个别鸭子，通过观察者模式
 */
public interface IQuackObservable {
	public void registerObserver(IObserver observer);
	public void notifyObservers();
}
