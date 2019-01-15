package pattern.builder_pattern;
//天使
public class AngelBuilder extends AbstractActorBuilder{

	@Override
	public void buildType() {
		// TODO Auto-generated method stub
		actor.setType("天使");
	}

	@Override
	public void buildSex() {
		// TODO Auto-generated method stub
		actor.setSex("女");
	}

	@Override
	public void buildFace() {
		// TODO Auto-generated method stub
		actor.setFace("漂亮");
	}

	@Override
	public void buildCostume() {
		// TODO Auto-generated method stub
		actor.setCostume("白裙");
	}

	@Override
	public void buildHairStyle() {
		// TODO Auto-generated method stub
		actor.setHair_style("披肩长发");
	}
	
}
