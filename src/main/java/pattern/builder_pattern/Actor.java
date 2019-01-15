package pattern.builder_pattern;
/**
 * 在没有指挥者类Director,客户端将如何构建复杂产品
 * 使用建造者模式来实现游戏角色的创建*/
public class Actor { // Product 产品类型
	private String type; //角色类型
	private String sex;  //性别
	private String face;  //脸型
	private String costume; //服装
	private String  hair_style; //发型
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getCostume() {
		return costume;
	}
	public void setCostume(String costume) {
		this.costume = costume;
	}
	public String getHair_style() {
		return hair_style;
	}
	public void setHair_style(String hair_style) {
		this.hair_style = hair_style;
	}
	
}
