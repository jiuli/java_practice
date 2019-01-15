package pattern.mutil_pattern;

/* 观察者具体类 观察个别鸭子*/
public class Quackologist implements IObserver {
	@Override
    public void update(IQuackObservable duck) {
		System.out.println("Quackologist: " + duck + " just quacked.");
	}
}
