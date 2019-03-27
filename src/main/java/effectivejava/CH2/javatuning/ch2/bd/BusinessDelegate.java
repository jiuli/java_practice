package effectivejava.CH2.javatuning.ch2.bd;

import effectivejava.CH2.javatuning.ch2.vo.Order;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BusinessDelegate {
    IOrderManager usermanager = null;

    public BusinessDelegate() {
        try {
            usermanager = (IOrderManager) Naming.lookup("OrderManager");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUserFromCache(int uid) {
        return true;
    }

    public boolean checkUser(int uid) throws RemoteException {
        /**
         * 当前对象被多个客户端共享，可以在本地缓存中检验用户
         */
        if (!checkUserFromCache(uid)) {
            return usermanager.checkUser(1);
        }
        return true;
    }

    public Order getOrderFromCache(int oid) {
        return null;
    }

    public Order getOrder(int oid) throws RemoteException {
        /**
         * 可以在本地缓存中获取订单，减少远程方法调用次数
         */
        Order order = getOrderFromCache(oid);
        if (order == null) {
            return usermanager.getOrder(oid);
        }
        return order;
    }


    public boolean updateOrder(Order order) throws Exception {
        /**
         * 暴露给展示层的方法，封装了业务流程，可能在缓存中执行
         */
        if (checkUser(1)) {
            Order o = getOrder(1);
            o.setNumber(10);
            usermanager.updateOrder(o);
        }
        return true;
    }
}
