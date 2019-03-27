package effectivejava.CH2.javatuning.ch2.bd;


import effectivejava.CH2.javatuning.ch2.vo.Order;

public class BusinessDelegateClient {
    //使用业务代理完成更新订单
    public static void main(String[] argv) throws Exception {
        BusinessDelegate bd = new BusinessDelegate();
        Order o = bd.getOrder(11);
        o.setNumber(11);
        bd.updateOrder(o);
    }
}
