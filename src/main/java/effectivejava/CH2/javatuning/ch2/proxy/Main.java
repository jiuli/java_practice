package effectivejava.CH2.javatuning.ch2.proxy;

public class Main {
    public static void main(String[] args) {
        //使用代理
        IDBQuery q = new DBQueryProxy();
        //在真正使用时才创建真实对象
        q.request();
    }
}
