package pattern.mutil_pattern;

import java.util.ArrayList;
import java.util.Iterator;

/* 同组合模式 统一管理一群鸭子 像对待单个对象䘝对待集合*/
public class Flock implements IQuackable {
	ArrayList quackers = new ArrayList();
	/* 使用List add添加String,ArrayList add添加Object */
	public void add(IQuackable quacker) {
		quackers.add(quacker);
	}/* 安全性 vs 透明性 1，add放在Flock中比较安全 
	2，add放在IQuackable中似的叶子和组之间是“透明的”
	实际情况怎么考虑？*/
	
	public void quack() {
		/*在这里，使用的是迭代器模式*/
		Iterator<IQuackable> iter = quackers.iterator(); 
		while (iter.hasNext()) {
			IQuackable quacker = iter.next();
			quacker.quack();
		}
	}
}
