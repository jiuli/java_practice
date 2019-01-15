package pattern.builder_pattern;

//角色建造器：抽象建造者
public abstract class AbstractActorBuilder {
	protected Actor actor = new Actor();
	
	public abstract void buildType();
	public abstract void buildSex();
	public abstract void buildFace();
	public abstract void buildCostume();
	public abstract void buildHairStyle();
	
	public Actor createActor() {
		return actor;
	}
}
