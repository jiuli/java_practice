package effectivejava.CH2.javatuning.ch2.observor;

import java.util.Vector;

public class ConcreteSubject implements ISubject {
    Vector<IObserver> observers = new Vector<IObserver>();

    @Override
    public void attach(IObserver observer) {
        observers.addElement(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.removeElement(observer);
    }

    @Override
    public void inform() {
        Event evt = new Event();
        for (IObserver ob : observers) {
            ob.update(evt);
        }
    }
}  