package alogothry;


public class Program {
	
	public static void ModifyString(StringBuffer text) {
		text.replace(0, 7, "world");
	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("hellosbsbsbsb");
		ModifyString(sb);
		System.out.println(sb);
	}
	
}
