package pattern.single_pattern;
//单利模式 客户测试端
public class SingleClient {
	public static void main(String[] args) {
		LoadBalancer b_1,b_2,b_3,b_4;
		b_1 = LoadBalancer.getLoadBalancer();
		b_2 = LoadBalancer.getLoadBalancer();
		b_3 = LoadBalancer.getLoadBalancer();
		b_4 = LoadBalancer.getLoadBalancer();
		
		//判断服务器负载均衡器是否相同
		if (b_1 == b_2 && b_2 == b_3 && b_3 == b_4) {
			System.out.println("服务器负载均衡器具有唯一性！");
		}
		
		//增加服务器
		b_1.addServer("server 1");
		b_2.addServer("server 2");
		b_3.addServer("server 3");
		b_4.addServer("server 4");
		
		//模拟客户端请求的分发
		for (int i = 0; i < 10; i++) {
			String server = b_1.getServer();
			System.out.println("分发请求到服务器：" + server);
		}
	}
}
