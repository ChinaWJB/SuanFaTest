package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InsertLinkList {
	
	private static LinkNode head = null;
	
	public void addNode(int d){
		LinkNode newNode = new LinkNode(d);
		if(head == null){
			head = newNode;
			return;
		}
		LinkNode tempNode = head;
		while(tempNode.next!=null){
			tempNode = tempNode.next;
		}
		tempNode.next = newNode;			
	}
	
	public void printNode(LinkNode headNode){
		while(headNode.next!=null){
			System.out.println("linkNode " + headNode.data); 
			headNode = headNode.next;
		}
		System.out.println("linkNode " + headNode.data);
	}
	
	public void insertNode(int index, int d){
		if(index < 0){
			throw new RuntimeException("��Ч���±꣡");
		}
		LinkNode newNode = new LinkNode(d);
		LinkNode tmp = head;
		for(int i=1; i<index; i++){
			tmp = tmp.next;
			if(tmp == null){
				throw new RuntimeException("��Ч���±꣡");
			}
		}
		newNode.next = tmp.next;
		tmp.next = newNode;
	}
	
	public void deleteNode(int index, LinkNode temphead){
		if(index < 0){
			throw new RuntimeException("��Ч���±꣡");
		}
		if(index == 0){
			throw new RuntimeException("��ɾ����");
		}
		if(index == 1){
			head = head.next;
		}
		for(int i=1; i<index-1; i++){
			temphead = temphead.next;
		}
		if(temphead.next.next == null){
			temphead.next = null;
		}else{
			temphead.next = temphead.next.next;
		}		
	}
	
	/**
	 * ��������
	 * @param temphead
	 */
	public void orderNode(LinkNode temphead){
		LinkNode head0 = temphead;
		LinkNode tail0 = temphead.next;
		int min = head0.data;
		while(head0.next != null){
			while(tail0 != null){
				if(min > tail0.data){					
					head0.data = tail0.data;
					tail0.data = min;
					min = head0.data;
				}
				tail0 = tail0.next;
			}

			head0 = head0.next;
			tail0 = head0.next;
			min = head0.data;
		}

	}
	
	/**
	 * ɾ���������ظ�������
	 * ��Ҫ����Ŀռ�洢������ֵ
	 * @param head
	 */
	public void deleteDuplecate(LinkNode head){
		Map<Integer, Integer> map = new HashMap();
		LinkNode temp = head;
		LinkNode temp0 = head;
		while(temp != null){			
			if((map.get(temp.data) != null) && (temp.next != null)){				
				temp0.next = temp.next;
				temp = temp0.next;
			}else if((map.get(temp.data) != null) && (temp.next == null)){
				temp0.next = temp.next;
				return;
			}else{
				map.put(temp.data, 1);
				temp0 = temp;
				temp = temp.next;
			}
		}		
	}
	
	/**
	 * ɾ���������ظ�������
	 * �����Ӷ���Ĵ洢�ռ�
	 * ʱ�临�ӶȽϸ�
	 * @param head
	 */
	public void deleteDuplecate2(LinkNode head){
		LinkNode p = head;
		LinkNode q = head;
		while(p != null){
			q = p;
			while(q.next != null){
				if(q.next.data == p.data){
					q.next = q.next.next;
				}else{
					q = q.next;
				}
			}
			p = p.next;
		}
	}
	
	/**
	 * �ҳ���������K��Ԫ��
	 * @param headtemp
	 * @param index
	 * @return
	 */
	public LinkNode findLastKNode(LinkNode headtemp, int index){
		LinkNode kheadtemp = headtemp;
		if (index < 1){
			throw new RuntimeException("������index��Ч");
		}
		for(int i=0; i<index-1; i++){			
			if(kheadtemp.next == null){
				throw new RuntimeException("������С�ڸ�����ֵ"); 
			}
			kheadtemp = kheadtemp.next;
		}
		while(kheadtemp.next != null){
			headtemp = headtemp.next;
			kheadtemp = kheadtemp.next;
		}
		return headtemp;
	}
	
	/**
	 * ʵ������ķ�ת
	 * @param temphead
	 * @return
	 */
	public LinkNode reverseNode(LinkNode temphead){
		LinkNode p = temphead;
		LinkNode q = temphead.next;
		if(temphead.next == null){
			throw new RuntimeException("ֻ��һ���ڵ㣡����");
		}
		while(q != null){
			temphead.next = q.next;
			q.next = p;
			p = q;
			q = temphead.next;						
		}
		return p;
	}
	
	/**
	 * ��β��ͷ���������
	 * �ݹ鷽ʽʵ��
	 * ͨ���ݹ鷽ʽʵ��ջ�Ĺ���
	 * @param head
	 */
	public void printListReversely(LinkNode head){
		if(head == null){
			return;
		}
		printListReversely(head.next);
		System.out.println(head.data);
	}
	
	/**
	 * ���������м�ڵ�
	 * 		����ʱ�����һ��
	 * 		ż��ʱ���������
	 * @param head
	 * @return
	 */
	public ArrayList<LinkNode> SearchMid(LinkNode head){
		LinkNode p = head;
		LinkNode q = head;
		ArrayList<LinkNode> al = new ArrayList<>();
		while(q != null && q.next != null && q.next.next != null){
			p = p.next;
			q = q.next.next;
		}
		if(q.next == null){
			al.add(p);
		}else if((q.next != null) && (q.next.next == null)){
			al.add(p);
			al.add(p.next);
		}
		return al;	
	}
	
	/**
	 * �ж�һ�������Ƿ��л�
	 * @param head
	 * @return
	 */
	public boolean IsLoop(LinkNode head){
		LinkNode fast = head;
		LinkNode slow = head;
		if(fast == null || fast.next == null){
			return false;
		}
		while((fast != null) &&(fast.next != null)){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				return true;
			}
		}
		return !((fast == null)||(fast.next == null));
	}
	
	/**
	 * �ڲ�֪��ͷ���������ɾ��һ���ڵ�
	 * ����ýڵ���β�ڵ㣬���޷�ɾ��
	 * @param node
	 * @return
	 */
	public boolean deleteNode2(LinkNode node){
		if(node == null && node.next == null){
			return false;
		}
		int temp = 0;
		temp = node.data;
		node.data = node.next.data;
		node.next.data = temp;
		node.next = node.next.next;
		return true;
	}
	
	public static void main(String[] args) {
		InsertLinkList ill = new InsertLinkList();
		int num = 0;
		
		ill.addNode(5);
		ill.addNode(2);
		ill.addNode(9);
		ill.addNode(18);
		ill.addNode(45);
		ill.addNode(3);
		ill.addNode(1);
		ill.addNode(14);
		
		ill.printNode(head);
				
//		System.out.println("��������������������index֮�󡪡�������������");
//		ill.insertNode(6, 13);
//		ill.printNode(head);
		
//		System.out.println("����������������ɾ��index֮�󡪡�������������");
//		ill.deleteNode(8, head);
//		ill.printNode(head);
		
//		System.out.println("����������������ɾ���ظ��Ľڵ�֮�󡪡�������������");
//		ill.deleteDuplecate2(head);
//		ill.printNode(head);
		
		System.out.println("��������������������֮�󡪡�������������");
		ill.orderNode(head);
		ill.printNode(head);
		
		System.out.println("�������������������������index������������������");
		LinkNode temp = ill.findLastKNode(head, 2);
		System.out.println(temp.data);
		
//		System.out.println("������������������ת֮�󡪡�������������");
//		head = ill.reverseNode(head);
//		ill.printNode(head);
//		
//		System.out.println("������������������β��ͷ�������������������");
//		ill.printListReversely(head);
//		
//		System.out.println("��������������������м�ֵ����������������");
//		ArrayList<LinkNode> all = new ArrayList<>();
//		all = ill.SearchMid(head);
//		for(int i=0; i<all.size(); i++){
//			LinkNode node = (LinkNode)all.get(i);
//			System.out.println(node.data);
//		}
//		
//		System.out.println("�����������������ж������Ƿ��л�����������������");
//		System.out.println(ill.IsLoop(head));
		
		System.out.println("������������������֪��ͷ���������ɾ���ڵ㡪��������������");
		boolean b = ill.deleteNode2(temp);
		System.out.println(b);
		ill.printNode(head);
		
	}
}
