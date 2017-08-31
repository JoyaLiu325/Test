package alogothry;

import java.util.Stack;

public class MyStack {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	
	public void push(Integer i) {
		if(stackMin.isEmpty()) {
			stackMin.push(i);
		}
		else if (i<=stackMin.peek()) {
				stackMin.push(i);
			}
//		任何数据都会被push，所以把这个操作放在最外面
				stackData.push(i);
		}
	
	public Integer pop() {
		if(stackMin.isEmpty())
			throw new RuntimeException("null");
		Integer value = stackData.pop();
		if(value.equals(this.getMin())) {
			stackMin.pop();
		}
		return value;
	}
	
	public Integer getMin() {
		if(this.stackMin.isEmpty())
			throw new RuntimeException("null");
		return stackMin.peek();
	}
}
