package pattern.prototype_pattern;

/**
 *附件 
 *
 *系列化是将对象到流的过程，从流中得到对象复制，原对象还在内存中。
 *系列化可以实现对引用类型变量的克隆，那就得实现Serializable接口
 *（空接口和Cloneable一样，只是起到标示作用，到jvm时提醒该对象或类要做对应的处理）*/
public class Attachment {
	private String name; //附件名

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void download() {
		System.out.print("下载附件，文件名为：" + name);
	}
	
}
