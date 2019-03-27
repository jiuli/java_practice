package effectivejava.CH4.javatuning.ch4.gs.future;

import effectivejava.CH4.javatuning.ch4.future.pattern.FutureData;

import java.util.ArrayList;
import java.util.List;


public class ClientThread extends Thread {
    private RequestQueue requestQueue;
    private List<Request> myRequest = new ArrayList<Request>();

    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        //先提出请求
        for (int i = 0; i < 10; i++) {
            Request request = new Request("RequestID:" + i + " Thread_Name:" + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            //设置一个返回值
            request.setResponse(new FutureData());
            requestQueue.addRequest(request);
            //发送请求
            myRequest.add(request);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        //取得服务端的返回值
        for (Request r : myRequest) {
            System.out.println("ClientThread Name is:" +
                    Thread.currentThread().getName() +
                    " Reponse is:" +
                    r.getResponse().getResult());
        }
    }
}
