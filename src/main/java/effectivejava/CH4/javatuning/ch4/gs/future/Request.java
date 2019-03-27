package effectivejava.CH4.javatuning.ch4.gs.future;

import effectivejava.CH4.javatuning.ch4.future.pattern.Data;

public class Request {
    private String name;
    //参考Future模式，请求的返回值
    private Data response;

    public synchronized Data getResponse() {
        return response;
    }

    public synchronized void setResponse(Data response) {
        this.response = response;
    }

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
