package pattern.single_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** 创建型模式：涉及类的实例化，将客户端与类的实例化解耦
 * 负载均衡器LoadBalancer:单利类，真实环境下该类将非常复杂，
 * 包括大量初始化的工作和业务方法，考虑到可读性和易理解性，
 * 只列出部分与模式相关的核心代码 *
 懒汉形式实例化 懒汉形式实例化 懒汉形式实例化
 */
public class LoadBalancer_3 {
	//私有静态成员变量，存储唯一实例  懒汉形式实例化
	private volatile static LoadBalancer_3 instance = null;
	//服务器集合
	private List server_list = null;
	
	private LoadBalancer_3(){
		server_list = new ArrayList();
	}
	//加上线程锁，这个是在方法上加上锁，多线程高并发下，系统性能变低
	synchronized public static LoadBalancer_3 getLoadBalancer() {
		if (instance == null) {
			instance = new LoadBalancer_3();
		}
		return instance;
	}
	/* 对方法中业务部分进行线程锁，单还是会出现多个实例化
	public static LoadBalancer_3 getLoadBalancer() {
		if (instance == null) {
			synchronized (LoadBalancer_3.class){
				instance = new LoadBalancer_3();
			}
		}
		return instance;
	} */
	
	/* 再进行一次 'instance == null' 判断，这种方式称为双重检查锁定（Double-Check Locking）
	public static LoadBalancer_3 getLoadBalancer() {
		if (instance == null) { //第一次判断
			synchronized (LoadBalancer_3.class){
				if (instance == null) { //第二次判断
					instance = new LoadBalancer_3();
				}
			}
		}
		return instance;
	} 
	//使用这方式实现懒汉式单例类，需要在静态成员变量instance增加修饰符volatile，
	 * 被volatile修饰的成员变量可以确保多个线程都能够正常处理，JDK1.5及以上才能正常执行
	 * 由于volatile会屏蔽JVM的所作的一些代码优化，可能会导致系统运行效率降低，所以改方式也不完美。
	*/
	
	//增加服务器
	public void addServer(String server) {
		server_list.add(server);
	}
	
	public void removeServer(String server) {
		server_list.remove(server);
	}
	
	//使用Random类随机获取服务器
	public String getServer() {
		Random random = new Random();
		int i = random.nextInt(server_list.size());
		return (String)server_list.get(i);
	}
}
