package alogothry;

import java.util.Stack;

public class PrintListReversingly {
	private Stack<ListTest.Node> stack = new Stack<ListTest.Node>();
//	�õݹ�ʵ�ִ�β��ӡ����
	public void print(ListTest.Node temp) {
		if(temp == null) {
			return;
		}
		int value = temp.value;
		temp = temp.next;
		print(temp);
		System.out.println(value +" ");
		
	}
	
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.add(1);
		lt.add(2);
		lt.add(3);
		lt.add(4);
		PrintListReversingly print = new PrintListReversingly();
		ListTest.Node node = lt.head;
		print.print(node);
//		��̬��Ա���ܳ��зǾ�̬��Ա������
	}
}
