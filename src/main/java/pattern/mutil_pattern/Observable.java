package pattern.mutil_pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;

public class Observable implements IQuackObservable {
	ArrayList observers = new ArrayList();
	IQuackObservable duck;
	
	public Observable(IQuackObservable duck) {
		this.duck = duck;
	}
	
	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		Iterator<IObserver> iter = observers.iterator();
		while (iter.hasNext()) {
			IObserver obs = iter.next();
			obs.update(duck);
		}
	}
	
}
