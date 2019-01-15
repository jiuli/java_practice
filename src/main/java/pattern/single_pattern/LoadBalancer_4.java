package pattern.single_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** 创建型模式：涉及类的实例化，将客户端与类的实例化解耦
 * 负载均衡器LoadBalancer:单利类，真实环境下该类将非常复杂，
 * 包括大量初始化的工作和业务方法，考虑到可读性和易理解性，
 * 只列出部分与模式相关的核心代码 *
 饿汉形式不能实现延迟加载，它始终占据内存，
 懒汉线程控制烦死，而且性能受影响。
 接下使用：Initialization on Demand Holder(IoDH)的技术
 解决上面两者的缺点。缺点是其他语言不一定支持IoDH。
 给单例列添加一个静态内部类。 
 */
public class LoadBalancer_4 {
	//服务器集合
	private List server_list = null;
	
	private LoadBalancer_4(){
		server_list = new ArrayList();
	}
	
	private static class HolderClass {
		private final static LoadBalancer_4 instance = new LoadBalancer_4();
	}
	
	//JVM来保证其线程安全性，确保该成员只能初始化一次
	public static LoadBalancer_4 getLoadBalancer() {
		return HolderClass.instance;
	}
	
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
