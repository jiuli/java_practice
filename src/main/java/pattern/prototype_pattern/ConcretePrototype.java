package pattern.prototype_pattern;

public class ConcretePrototype implements Cloneable {
    public Prototype clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("Not support cloneable");
        }
        return (Prototype) obj;
    }
}
