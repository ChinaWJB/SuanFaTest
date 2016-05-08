package com.wjb.baidu;

/**
 * �ж�һ�ö������Ƿ�����һ�õ���ȫ������
 * ע�⣺��ȫ������Ҫ��ÿһ������ֵ�����Һ��ӵ�ֵ������ȡ�
 * �жϱ�׼�ǣ��ж�ÿ���ڵ��ֵ�Ƿ����
 * �����ݹ鷽����
 * ��һ���ݹ飺������һ�������ҳ��͵ڶ������ĸ��ڵ���ȵĽڵ�
 * �ڶ����ݹ飺�Ե�һ�����ĵ�ǰ�ڵ�Ϊ�������ڵ�����еȲ���
 * @author wjb
 *
 */
public class IsSubTree {
	/**
	 * �����жϣ�����root1�е����н�㣬���������Ҫ��ģ�����ֹ����
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static int isSubTree(Node root1, Node root2){
		int value = -1;
		if(root1 == null){
			
		}else if(root2 == null){
			value = 1;
		}else{
			//����root1���ֵ����н�㣬ÿ����root2.data��ȵĽ�㶼�鿴һ������������
			if(root1.data == root2.data){
				value = test(root1, root2);
			}
			if(root1.left != null && value != 1){
				value = isSubTree(root1.left, root2);
			}
			if(root1.right != null && value != 1){
				value = isSubTree(root1.right, root2);
			}

		}
		return value;
	}
	
	/**
	 * ����root1�е�ÿһ����root2��ȵĽ�㣬����һ���ж������ı���
	 * ���շ��������ȵĽ���Ƿ������root2��һ��ֵ��ȶ�����
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static int test(Node root1, Node root2){
		int left = 0;
		int right = 0;
		if(root1 != null && root2 != null){
			if(root1.data == root2.data){
				left = test(root1.left, root2.left);
				right = test(root1.right, root2.right);
				if((left+right) == 2){
					return 1;
				}
			}	
		}else if(root1 == null && root2 == null ){
			return 1;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		Node node1 = new Node(3);
		Node node2 = new Node(8);
//		Node node3 = new Node(7);
//		Node node4 = new Node(8);
		
		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
		
		int value = isSubTree(n1, node1);
		System.out.println(value);
		
	}
	
}
class Node {
	public int data;
	public Node left = null;
	public Node right = null;
	public Node(int data){
		this.data = data;
	}
}
