package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
	/**
	 * ���ڲ����������ṹ
	 * @author Administrator
	 *
	 */
	class Node{
		int value = 0;
		Node lchild = null;
		Node rchild = null;
		Node(int value){
			this.value = value;
		}
	}
	
	/**
	 * ���򴴽�������
	 * iΪ�����±�
	 */
	static int i = 0;
	Node createTree(int[] input) {
		Node node= null;
		if(input[i]<0)
			return node;
			node = new Node(input[i]);
			i++;
			node.lchild = createTree( input);
			i++;
			node.rchild = createTree(input);
		return node;
	}
	
	/**
	 * �ݹ鷽ʽʵ���������
	 * @param root
	 * @param result
	 */
	void preOrder(Node root,ArrayList<Node> result){
		if(root == null)
			return ;
		result.add(root);
		preOrder(root.lchild,result);
		preOrder(root.rchild,result);
	}
	
	/**
	 * �ݹ鷽ʽʵ���������
	 * @param root
	 * @param result
	 */
	void midOrder(Node root,ArrayList<Node> result) {
		if(root == null)
			return ;
		midOrder(root.lchild, result);
		result.add(root);
		midOrder(root.rchild, result);
	}
	
	/**
	 * �ݹ鷽ʽʵ�ֺ������
	 * @param root
	 * @param result
	 */
	void postOrder(Node root,ArrayList<Node> result) {
		if(root == null)
			return ;
		postOrder(root.lchild,result);
		postOrder(root.rchild,result);
		result.add(root);
	}
	
	/**
	 * ������ʽʵ�����������
	 * ��Ϊ�ݹ�����õ�ջ��ԭ���������еݹ�ʽ�Ӷ�������ջ����ʾ������һ���õ���ջ��
	 * 1.����ջ
	 * 2.ջ��Ԫ�س�ջ���ҽ����ջ����ڵ���ջ��ѭ���ò���
	 * @param root
	 * @return
	 */
	ArrayList<Node> preOrder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		ArrayList<Node> list = new ArrayList<Node>();
		if(root == null) {
			return list;
		}
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			list.add(node);
			if(node.rchild!= null)
			stack.push(node.rchild);
			if(node.lchild!=null)
			stack.push(node.lchild);
		}
		return list;
	}
	
	/**
	 * ������ʽʵ�����������
	 * �Ƚ�������ڵ�ѹջ����ڵ�Ϊ��ʱ��˵���Ѿ����˸���֦�ľ�ͷ����ջ��Ԫ�س�ջ����ȥ�����ý���������
	 * @param root
	 * @return
	 */
	ArrayList<Node> midOrder(Node root){
		ArrayList<Node> list = new ArrayList<Node>();
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		if(root == null)
			return list;
		while(!stack.isEmpty() || node!=null) {
			while(node!=null) {
				stack.push(node);
				node = node.lchild;
			}
			node = stack.pop();
			list.add(node);
			node = node.rchild;
		}
		return list;
	}
	/**
	 * ����ʵ�ֺ��������
	 * ������Ҫ�ı������ոմ�ӡ��Ľ��print��ջ�����top����ʼֵprintΪ���ڵ㣬topΪnull
	 * 1.���ж�ջ�������������Ƿ񱻱���������ԭ���ǣ��ж�print�Ƿ�Ϊջ���ڵ�����ӻ����Һ��ӽ��
	 * 2.���ж�ջ�������������Ƿ񱻱���������ԭ���ǣ��ж�print�Ƿ�Ϊջ���ڵ���Һ��ӽ��
	 * 3.�������������������ˣ���ջ������ջ����ӡ�øýڵ㡣
	 * �ҵ�top��print���Ĺ�ϵ
	 * @param root
	 * @return
	 */
	ArrayList<Node> postOrder(Node root){
		ArrayList<Node> list = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Node top = null;
		Node print = root;
		stack.push(root);
		while(!stack.isEmpty()) {
			top = stack.peek();
			if(top.lchild!= null && top.lchild != print && top.rchild !=print) {
				stack.push(top.lchild);
				top = stack.peek();
			}
			else if(top.rchild!=null && top.rchild!= print) {
				stack.push(top.rchild);
				top = stack.peek();
			}
			else
			{
				print = stack.pop();
				list.add(print);
			}
			
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		//��������
		int[] array = {3,5,-1,9,-1,-1,7,11,-1,-1,13,-1,-1};
		Node root =bt.createTree(array);
		ArrayList<Node> list = bt.postOrder(root);
		for(Node node : list) {
			System.out.print(node.value + " ");
		}
		
	}
	
}
