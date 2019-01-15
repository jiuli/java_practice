package pattern.prototype_pattern;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CompanyBaseIntroduction extends AbstractPrototype {
	private Map<String, String> introduction_map = new HashMap<String, String>();
	
	public CompanyBaseIntroduction() {}
	public CompanyBaseIntroduction(Map<String, String> map) {
		introduction_map = map;
	}
	public AbstractPrototype cloneMyself() {
		addSomeIntroduction("公司介绍", "这是公司基本介绍");
		AbstractPrototype obj = new CompanyBaseIntroduction(introduction_map);
		return obj;
	}
	
	public void addSomeIntroduction(String topic, String content) {
		introduction_map.put(topic, content);
	}
	
	public void deleteSomeIntroduction(String key) {
		if (introduction_map.containsKey(key)) {
			introduction_map.remove(key);
		}
	}
	
	public void addIntroductionMap(Map map) {
		introduction_map.putAll(map);
	}
	
	public Map getIntroduction_map() {
		return introduction_map;
	}
	
	public void showIndroduction() {
		/* 使用迭代器模式 */
		Iterator iter = introduction_map.keySet().iterator();
		String key, val;
		while (iter.hasNext()) {
			key = (String) iter.next();
			val = (String) introduction_map.get(key);
			System.out.println("key:" + key + ",value:" +val);
		}
	}
}
