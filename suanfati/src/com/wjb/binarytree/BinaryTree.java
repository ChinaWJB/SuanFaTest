package com.wjb.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;
	public BinaryTree(){
		root = null;
	}
	/**
	 * ѭ�����뷨���������������
	 * @param data
	 */
	public void insert(int data){
		Node newNode = new Node(data);
		if(root == null){
			root = newNode;
		}else{
			Node current = root;
			Node parent;		//Ϊ�˸�newNode��ֵ�õģ�ÿ�ξ���whileʱparent����current�ĸ��ڵ�
			while(true){
				parent = current;	//�ܹؼ����ڱ���ĳ�ڵ�����Һ���ʱ�����ڵ������ʱ����
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
     * �ݹ鴴����������� 
     * @param node 
     * @param data 
     */  
    public void buildTree(Node node,int data){  
        if(root == null){  
            root = new Node(data);  
        }else{  
            if(data < node.data){  
                if(node.left == null){  
                    node.left = new Node(data);  
                }else{  
                    buildTree(node.left,data);  
                }  
            }else{  
                if(node.right == null){  
                    node.right = new Node(data);  
                }else{  
                    buildTree(node.right,data);  
                }  
            }  
        }  
    }
	
	/**
	 * ����ֵ���빹����������
	 * �������������
	 * @param data
	 */
	public void buildTree(int[] data){
		for(int i=0; i<data.length; i++){
			insert(data[i]);
		}
	}
	
	/**
	 * ����������ݹ�ʵ��
	 * @param localRoot
	 */
	public void preOrder(Node localRoot){
		if(localRoot != null){
			System.out.print(localRoot.data + " ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	public void preOrder(){
		this.preOrder(this.root);
	}
	
	/**
	 * ����������ݹ�ʵ��
	 * @param localRoot
	 */
	public void inOrder(Node localRoot){
		if(localRoot != null){			
			inOrder(localRoot.left);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.right);
		}
	}
	public void inOrder(){
		this.inOrder(this.root);
	}
	
	/**
	 * ����������ݹ�ʵ��
	 * @param localRoot
	 */
	public void postOrder(Node localRoot){
		if(localRoot != null){
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data + " ");
		}
	}
	public void postOrder(){
		this.postOrder(this.root);
	}
	
	/**
	 * ������һ�Ŷ����������ö��С�
	 * �Ƚ����ڵ������У�Ȼ�����whileѭ����ÿpullһ���������ͽ������Һ�����ӵ�����
	 */
	public void layerTranverse(){
		if(this.root == null){
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(this.root);
		while(!q.isEmpty()){
			Node n = q.poll();
			System.out.print(n.data);
			System.out.print(" ");
			if(n.left != null){
				q.add(n.left);
			}
			if(n.right != null){
				q.add(n.right);
			}
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
//		int[] data = {15,4,3,10,45,13,24};
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		bt.buildTree(data);
		bt.preOrder();
		bt.layerTranverse();
	}
}
