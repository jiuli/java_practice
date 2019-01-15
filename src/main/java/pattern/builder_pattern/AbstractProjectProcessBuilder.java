package pattern.builder_pattern;

import java.util.ArrayList;
import java.util.List;

/* 创建型模式 ：涉及对象的实例化，将客户从所需要实例化的对象中解耦
 * 建造者模式（也叫生成器模式）标准定义：将一个复杂对象的构建与它的表示分离，
 * 使得同样的构建过程可以创建不同的表示。*/
public abstract class AbstractProjectProcessBuilder {
	List<String> process_list = new ArrayList();
	public void buildFeasibility() {}
	
}
