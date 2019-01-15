package pattern.prototype_pattern;

/**
 * 工作周报WeeklyLog:具体原型类，考虑到代码的可读性和易理解性，
 * 只列出部分与模式相关的核心代码
 * */
public class WeeklyLog implements Cloneable{
	private Attachment attachment; //附件，这里只有一个附件，实际情况会有多个，可以通过list等集合对象来实现
	private String name;
	private String date;
	private String content;
	
	public Attachment getAttachment() {
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	//克隆方法clone()，此处使用Java语言提供的克隆机制
	public WeeklyLog clone() {
		Object obj = null;
		try {
			obj = super.clone();
			return (WeeklyLog)obj;
		} catch(CloneNotSupportedException e) {
			System.out.println("不支持复制！");
			return null;
		}
	}
	
}
