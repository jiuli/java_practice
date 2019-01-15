package utils;

import java.util.*;

/**
 * @author Administrator
 *	Map的妙用
 */
public class MagicMap {
	public List<String> removeDuplicatedEmailAddresses1(List<String> emails) {
		/*去掉重复数据，用嵌套for循环，还用了比较长时间调试*/
		List<String> refreshEmails = new ArrayList<String>();
		
		for(int i = 0; i < emails.size(); i++){
			boolean found = false;
			String email = emails.get(i);
			for(int j = 0; j < refreshEmails.size(); j++) {
				if(refreshEmails.get(j).equals(email)) {
					found = false;
				}
			}
			if (!found) {
				refreshEmails.add(email);
			}
		}
		return refreshEmails;
	}
	
	public List<String> removeDuplicatedEmailAddresses(List<String> emails) {
		/*同样的事情，用Map进行处理，代码会更简单*/
		Map<String,String> refreshedEmails = new HashMap<String,String>();
		
		for(String mail:emails){
			refreshedEmails.put(mail, mail);
		}
		
		List<String> result = new ArrayList<String>();
		Iterator<String> iter = refreshedEmails.values().iterator();
		while(iter.hasNext()) {
			result.add(iter.next());
		}
		return result;
	}
}
