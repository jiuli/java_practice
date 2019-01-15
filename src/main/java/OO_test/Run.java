package OO_test;

public class Run extends Person{
	public static void main(String[] args) {
		System.out.println("...........");
		BaseDTO ss = new BaseDTO();
		BaseDTO copyDTO = new BaseDTO("11", 1L, "liming");
		ss.copy(copyDTO);
		System.out.println(ss.getId());
		System.out.println(ss.getVersion());
		System.out.println(ss.getCreatedBy());
	}
}
