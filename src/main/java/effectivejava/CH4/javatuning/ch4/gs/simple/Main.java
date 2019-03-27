package effectivejava.CH4.javatuning.ch4.gs.simple;


public class Main {
    public static void main(String[] args) {
        //请求队列
        RequestQueue requestQueue = new RequestQueue();
        //服务端开启
        for (int i = 0; i < 10; i++)
            new ServerThread(requestQueue, "ServerThread" + i).start();
        //请求进程开启
        for (int i = 0; i < 10; i++)
            new ClientThread(requestQueue, "ClientThread" + i).start();
    }
}
