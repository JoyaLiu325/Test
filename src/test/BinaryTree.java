package test;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {

	class Node{
		int value = 0;
		Node lchild = null;
		Node rchild = null;
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
			stack.push(node.rchild);
			stack.push(node.lchild);
		}
		return list;
	}
	
	ArrayList<Node> midOrder(Node root){
		ArrayList<Node> list = new ArrayList<Node>();
		Stack<Node> stack = new Stack<Node>();
		
	}
}
