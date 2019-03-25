package effectivejava.CH4.javatuning.ch4.gs.simple;

public class Request {
    private String name;
	public Request(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "[ Request " + name + " ]";
    }
}
