package pattern.builder_pattern;
//英雄角色建造器：具体建造者
public class HeroBuilder extends AbstractActorBuilder {

	@Override
	public void buildType() {
		// TODO Auto-generated method stub
		actor.setType("英雄");
	}

	@Override
	public void buildSex() {
		// TODO Auto-generated method stub
		actor.setSex("男");
	}

	@Override
	public void buildFace() {
		// TODO Auto-generated method stub
		actor.setFace("英俊");
	}

	@Override
	public void buildCostume() {
		// TODO Auto-generated method stub
		actor.setCostume("铠甲");
	}

	@Override
	public void buildHairStyle() {
		// TODO Auto-generated method stub
		actor.setHair_style("飘逸");
	}
	
}
