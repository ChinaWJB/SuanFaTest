package com.wjb.binarytree.mixdistance;

import com.wjb.binarytree.mixdistance.Node;

public class BinaryTree {
	private Node root;
	public BinaryTree(){
		root = null;
	}
	public void insert(int data){
		Node newNode = new Node(data);
		if(root == null){
			root = newNode;
		}else{
			Node current = root;
			Node parent;		//Ϊ�˸�newNode��ֵ�õģ�ÿ�ξ���whileʱparent����current�ĸ��ڵ�
			while(true){
				parent = current;
				if(data<current.data){
					current = current.left;
					if(current == null){	//��Ϊcurent�����ж��Ƿ�Ϊ���ˣ���ʱparentΪcurrent�ĸ��ڵ�
						parent.left = newNode;
						return;
					}
				}else{
					current = current.right;
					if(current == null){
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * �������������
	 * @param data
	 */
	public void buildTree(int[] data){
		for(int i=0; i<data.length; i++){
			insert(data[i]);
		}
	}
	
	private int maxLen = 0;
	private int max(int a, int b){
		return a>b?a:b;
	}
	public void FindMaxDistance(Node root){
		if(root == null){
			return;
		}
		if(root.left == null){
			root.leftMaxDistance = 0;
		}
		if(root.right == null){
			root.rightMaxDistance = 0;
		}
		if(root.left != null){
			FindMaxDistance(root.left);
		}
		if(root.right != null){
			FindMaxDistance(root.right);
		}
		//�����������о�����ڵ��������
		if(root.left != null){
			root.leftMaxDistance = max(root.left.leftMaxDistance, root.left.rightMaxDistance)+1;
		}
		//����������������ڵ��������
		if(root.right != null){
			root.rightMaxDistance = max(root.right.leftMaxDistance, root.right.rightMaxDistance)+1;
		}
		//��ȡ���������нڵ��������
		if(root.leftMaxDistance + root.rightMaxDistance > maxLen){
			maxLen = root.leftMaxDistance + root.rightMaxDistance;
		}
	}
	
	//����
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		int[] data = {5,1,2,3,4,6,7,8,9};
		
		bt.buildTree(data);
		
		bt.FindMaxDistance(bt.root);
		System.out.println("���Ľڵ��ľ���Ϊ: " + bt.maxLen);
		
	}
}
