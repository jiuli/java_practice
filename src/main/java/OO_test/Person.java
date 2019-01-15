package OO_test;

public class Person {
	 private String name;
	 
	 protected void reName(){
		 this.name = "JasonLi";
		 System.out.println(name);
	 }
	 
	 public String isName() {
			reName();
			return this.name;
		}
}
