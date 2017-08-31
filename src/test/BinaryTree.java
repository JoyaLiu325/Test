package test;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
	class Node{
		int value = 0;
		Node lchild = null;
		Node rchild = null;
		Node(int value){
			this.value = value;
		}
	}
	
	Node createTree(int[] input,int length,int i) {
		if(input[i]!=-1 && i<length) {
			Node node = new Node(input[i]);
		}
		else if(input[i] ==-1 && i<length) {
			Node node = null;
		}
		createTree( input, length,++i);
		createTree(input,length,++i);
		

		
	}
	
	void preOrder(Node root,ArrayList<Node> result){
		if(root == null)
			return ;
		result.add(root);
		preOrder(root.lchild,result);
		preOrder(root.rchild,result);
	}
	
	void midOrder(Node root,ArrayList<Node> result) {
		if(root == null)
			return ;
		midOrder(root.lchild, result);
		result.add(root);
		midOrder(root.rchild, result);
	}
	
	void postOrder(Node root,ArrayList<Node> result) {
		if(root == null)
			return ;
		postOrder(root.lchild,result);
		postOrder(root.rchild,result);
		result.add(root);
	}
	/**
	 * 根，然后右左结点循环入栈
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
		while(!list.isEmpty()) {
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
	 * 
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
	 * 刚刚打印完的结点print
	 * 栈顶结点top
	 * 找到top和print结点的关系
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
		Node node = bt.new Node();
		
	}
	
}
