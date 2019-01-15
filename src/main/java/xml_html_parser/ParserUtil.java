package xml_html_parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import base.MyMongodb;
public class ParserUtil {
	public static String parpserBody(String body_str,String encode) {
		Document doc = Jsoup.parseBodyFragment(body_str);
		return doc.text();
	}
	
	public static void main(String[] args) {
		MyMongodb DB = MyMongodb.getMongoInstance();
		DBCollection projects = DB.getTable("project");
		DBCursor p_cur = projects.find();
		while (p_cur.hasNext()) {
			DBObject p = p_cur.next();
			System.out.println(p.get("begin_desc").toString());
			String content = ParserUtil.parpserBody(p.get("begin_desc").toString(), "utf-8");
			System.out.println(content.substring(0, content.length() > 20 ? 20 :content.length()));
		}
//		String body_str = "<p><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-size:16px\"><span style=\"font-family:微软雅黑\">大家好！这里是&ldquo;试穿成就&rdquo;<img alt=\"laugh\" src=\"http://bms.microc.cn/shopguide/res/questionnaire/js/plug-in/ckeditor/plugins/smiley/images/teeth_smile.png\" style=\"height:23px; width:23px\" title=\"laugh\" /></span></span></span></span></span></span></span></span></p>\n\n<p><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-size:8px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-family:微软雅黑\">&nbsp;&nbsp;</span></span></span></span></span></span></p>\n\n<p><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102); font-family:微软雅黑; font-size:16px\">每天让顾客试穿，成交顾客成为我们的奋斗目标之一<img alt=\"devil\" src=\"http://bms.microc.cn/shopguide/res/questionnaire/js/plug-in/ckeditor/plugins/smiley/images/devil_smile.png\" style=\"height:23px; width:23px\" title=\"devil\" /></span></span></span></span></span></p>\n\n<p><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-size:8px\"><span style=\"color:rgb(102, 102, 102); font-family:微软雅黑\">&nbsp;</span></span></span></span></span></span></p>\n\n<p><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-size:16px\"><span style=\"font-family:微软雅黑\">所以&ldquo;试穿成就&rdquo;在这里守候你的试穿顾客，记录你的试穿成就！</span></span></span></span></span></span></span></span></p>\n\n<p><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-size:8px\"><span style=\"color:rgb(102, 102, 102)\">&nbsp;</span></span></span></span></span></span></p>\n\n<p><span style=\"font-family:微软雅黑\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-size:16px\">那你需要怎么做呢？</span></span></span></span></span></span></span></span></p>\n\n<p><span style=\"font-family:微软雅黑\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-size:8px\"><span style=\"color:rgb(102, 102, 102)\">&nbsp;</span></span></span></span></span></span></span></p>\n\n<p><span style=\"font-family:微软雅黑\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-size:16px\">1、顾客穿上你推荐的服装时，用手机为他拍照</span></span></span></span></span></span></span></span></p>\n\n<p><span style=\"font-family:微软雅黑\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-size:16px\">2、将照片传到这里&ldquo;试穿成就&rdquo;<br />\n<span style=\"font-size:8px\">&nbsp;</span></span></span></span></span></span></span></span></span></p>\n\n<p><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-family:微软雅黑; font-size:16px\">特别奖励：每一位试穿顾客的照片都能为你带来<span style=\"font-size:18px\"><strong>50</strong></span>个金币哦<img alt=\"kiss\" src=\"http://bms.microc.cn/shopguide/res/questionnaire/js/plug-in/ckeditor/plugins/smiley/images/kiss.png\" style=\"height:23px; width:23px\" title=\"kiss\" /></span></span></span></span></span></span></span></p>\n\n<p><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-size:8px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-family:微软雅黑\">&nbsp;</span></span></span></span></span></span></p>\n\n<p><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"color:rgb(102, 102, 102)\"><span style=\"font-size:16px\"><span style=\"font-family:微软雅黑; font-size:16px\">希望你的&ldquo;试穿成就&rdquo;每天都可以增长<img alt=\"laugh\" src=\"http://bms.microc.cn/shopguide/res/questionnaire/js/plug-in/ckeditor/plugins/smiley/images/teeth_smile.png\" style=\"height:23px; width:23px\" title=\"laugh\" /></span></span></span></span></span></span></span></p>\n";
//		String content = ParserUtil.parpserBody(body_str, "utf-8");
//		System.out.println(content.substring(0, content.length() > 20 ? 20 :content.length()));
//		
	}
}
