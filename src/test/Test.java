package test;

public class Test {

	public Test foo() {
		return this;
	}
	
}
class Test1 extends Test{
	public Test foo() {
		return this;
	}
}

class Test2 extends Test1{
	
	
//	º¯ÊıµÄÖØÔØ
	public Test foo(Test1 test) {
		return test;
		
	}
}
