package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
	/**
	 * 用内部类申明结点结构
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
	 * 先序创建二叉树
	 * i为数组下标
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
	 * 递归方式实现先序遍历
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
	 * 递归方式实现中序遍历
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
	 * 递归方式实现后序遍历
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
	 * 迭代方式实现先序遍历。
	 * 因为递归就是用到栈的原理，所以所有递归式子都可以用栈来表示，遍历一定用到了栈。
	 * 1.根入栈
	 * 2.栈顶元素出栈，右结点入栈，左节点入栈。循环该步骤
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
	 * 迭代方式实现中序遍历。
	 * 先将所有左节点压栈，左节点为空时，说明已经到了该树枝的尽头，则栈顶元素出栈，再去遍历该结点的右子树
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
	 * 迭代实现后序遍历。
	 * 两个重要的变量：刚刚打印完的结点print和栈顶结点top，初始值print为根节点，top为null
	 * 1.先判断栈顶结点的左子树是否被遍历，遍历原理是：判断print是否为栈顶节点的左孩子或者右孩子结点
	 * 2.再判断栈顶结点的右子树是否被遍历，遍历原理是：判断print是否为栈顶节点的右孩子结点
	 * 3.若左右子树都被遍历了，则栈顶结点出栈，打印该该节点。
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
		//测试数据
		int[] array = {3,5,-1,9,-1,-1,7,11,-1,-1,13,-1,-1};
		Node root =bt.createTree(array);
		ArrayList<Node> list = bt.postOrder(root);
		for(Node node : list) {
			System.out.print(node.value + " ");
		}
		
	}
	
}
