package xml_html_parser;

import org.w3c.dom.DocumentFragment;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * DOM编程不要其它的依赖包，因为JDK里自带的JDK里含有的上面提到的org.w3c.dom、org.xml.sax 和javax.xml.parsers包就可以满意条件了。
 * （1）org.w3c.dom　W3C推荐的用于XML标准规划文档对象模型的接口。
 * （2）org.xml.sax　用于对XML进行语法分析的事件驱动的XML简单API（SAX）
 * （3）javax.xml.parsers解析器工厂工具，程序员获得并配置特殊的特殊语法分析器。
 */
public class ExtractorUtil {
    /**
     * 加载文件xml,html等，获取DOM对象
     *
     *
     * @param filePath
     * @param file_path
     * @return dom object
     */
    public static DocumentFragment genDom(String filePath, String file_path) {
        StringBuffer content = new StringBuffer();
        BufferedReader reader = null;
        try {
            String line;
            reader = new BufferedReader(new FileReader(file_path));
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            if (reader != null) {
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (DocumentFragment) genDom(content.toString(), "utf-8");
    }

    /**
     * 将html,xml字符串转换成DOM对象
     */
    public static DocumentFragment getDom(String html, String encode) {
        byte[] byt = html.getBytes();
        InputSource source = null;
        InputStreamReader isr = null;
        try {
            source = new InputSource();
            isr = new InputStreamReader(new ByteArrayInputStream(byt), encode);
            source.setCharacterStream(isr);
//            DOMFragmentParser DOMP = new DOMFragmentParser();
//            DocumentFragment dom = new HTMLDocumentImpl();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
