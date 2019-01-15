package pattern.builder_pattern;
//恶魔
public class DevilBuilder extends AbstractActorBuilder {

	@Override
	public void buildType() {
		// TODO Auto-generated method stub
		actor.setType("恶魔");
	}

	@Override
	public void buildSex() {
		// TODO Auto-generated method stub
		actor.setSex("妖");
	}

	@Override
	public void buildFace() {
		// TODO Auto-generated method stub
		actor.setFace("丑陋");
	}

	@Override
	public void buildCostume() {
		// TODO Auto-generated method stub
		actor.setCostume("黑衣");
	}

	@Override
	public void buildHairStyle() {
		// TODO Auto-generated method stub
		actor.setHair_style("光头");
	}

}
