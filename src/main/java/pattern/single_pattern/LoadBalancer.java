package pattern.single_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** 创建型模式：涉及类的实例化，将客户端与类的实例化解耦
 * 负载均衡器LoadBalancer:单利类，真实环境下该类将非常复杂，
 * 包括大量初始化的工作和业务方法，考虑到可读性和易理解性，
 * 只列出部分与模式相关的核心代码*
 */
public class LoadBalancer {
	//私有静态成员变量，存储唯一实例
	private static LoadBalancer instance = null;
	//服务器集合
	private List server_list = null;
	
	private LoadBalancer(){
		server_list = new ArrayList();
	}
	
	public static LoadBalancer getLoadBalancer() {
		if (instance == null) {
			instance = new LoadBalancer();
		}
		return instance;
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
