package com.wjb.binarytree.mixdistance;

public class Node {
	public int data;
	public Node left;
	public Node right;
	public int leftMaxDistance;	//����������ڵ�� ������
	public int rightMaxDistance;//����������ڵ��������
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
