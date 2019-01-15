package utils;

public class Casting {
	//转换
	public static void main(String[] args) {
		Object i = null;
		if (i instanceof Integer) {
			Integer objAsInt = (Integer) i;
			System.out.println(objAsInt);
		}
	}

}
