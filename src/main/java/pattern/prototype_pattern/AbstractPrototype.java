package pattern.prototype_pattern;
/* 原型模式标准定义：用原型实例指定创建对象的种类，
 * 并且通过拷贝这些原型创建新的对象。 */
public abstract class AbstractPrototype {
	public AbstractPrototype cloneMyself() { return this; }
	public void addSomeIntroduction (String topic, String content) {}
	public void deleteSomeIntroduction (String key) {}
	public void showIntroduction() {}
}
