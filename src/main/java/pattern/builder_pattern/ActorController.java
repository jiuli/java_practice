package pattern.builder_pattern;
/**
 * 游戏角色创建控制器：指挥者*/
public class ActorController {
	//逐步构建复杂产品对象
	public Actor construct(AbstractActorBuilder ab) {
		Actor actor;
		ab.buildType();
		ab.buildFace();
		ab.buildSex();
		ab.buildCostume();
		ab.buildHairStyle();
		actor = ab.createActor();
		return actor;
	}
	
	public static void main(String[] args) {
		HeroBuilder h = new HeroBuilder();
		ActorController a = new ActorController();
		Actor actor = a.construct(h);
		String type = actor.getType();
		System.out.println(type + "的外观：");
		System.out.println("性别：" + actor.getSex());
		System.out.println("面容：" + actor.getFace());
		System.out.println("服装：" + actor.getCostume());
		System.out.println("发型：" + actor.getHair_style());
	}
}
