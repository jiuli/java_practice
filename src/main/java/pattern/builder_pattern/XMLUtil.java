package pattern.builder_pattern;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 为提高系统的灵活性和可扩展性，这里将具体角色建造者类的类名存储在配置文件中，
 * 并通过工具类XMLUitl来读取配置文件并发射生成对象。 */
public class XMLUtil {
	//该方法用于从XML配置文件中提取具体类的类名，并返回一个实例对象
	public static Object getBean() {
		try {
			//创建文档对象
			DocumentBuilderFactory d_factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =  d_factory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("../pattern/builder_pattern/config.xml"));
			
			//获取包含类名的文件节点
			NodeList nl = doc.getElementsByTagName("className");
			Node class_node = nl.item(0).getFirstChild();
			String c_name = class_node.getNodeValue();
			
			//通过类名生成实例对象并将其返回
			Class c  = Class.forName(c_name);
			Object obj = c.newInstance();
			
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
