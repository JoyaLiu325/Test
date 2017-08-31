package staticTest;

public class StaticTest {
	
	private String property="123456";
	
	public static void func() {
		StaticTest st = new StaticTest();
		
		System.out.println(st.property);
	}

	public static void main(String[] args) {
		func();

	}

}
