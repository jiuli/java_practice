package effectivejava.CH2.javatuning.ch2.observor;

public class ConcreteObserver implements IObserver{  
    @Override
    public void update(Event evt){
    	System.out.println("obserer receives information");
    }  
}  
