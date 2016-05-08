package jianzhioffer.stackqueque;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����������ģ��ջ����
 * ѹջ��
 * 		����Ϊ0�Ķ�����ѹ��Ԫ�ء�
 * ��ջ��
 * 		���ĸ�������ֻ��һ��Ԫ�ؾ͵���
 * 		���û��ֻ��һ���Ķ��У���϶�һ��Ϊ�գ�һ���Ӷ���һ��Ԫ�أ���ʱ������Ԫ�صĶ����е�Ԫ�ص�����ѹ�뵽�ն��У���Ҫ�������һ����������
 * @author wjb
 *
 */
public class QueueToStack {
	static Queue<Character> q1 = new LinkedList<Character>();
	static Queue<Character> q2 = new LinkedList<Character>();	
	
	public static void push(char value){
		if(q2.size() == 0){
			q1.offer(value);
		}else if(q1.size() == 0){
			q2.offer(value);
		}
	}
	
	public static char pop(){
		if(q1.size() == 1){
			return q1.poll();
		}else if(q2.size() == 1){
			return q2.poll();
		}else if(q2.size() == 0 && q1.size() != 0){
			while(q1.size()>1){
				char temp = q1.poll();
				q2.offer(temp);
			}
			return q1.poll();
		}else if(q1.size() == 0 && q2.size() != 0){
			while(q2.size()>1){
				char temp = q2.poll();
				q1.offer(temp);
			}
			return q2.poll();
		}else {
			return (Character) null;
		}
	}
	
	public static void main(String[] args) {
		push('a');
		push('b');
		push('c');
		
		char c1 = pop();
		System.out.println(c1);
		char c2 = pop();
		System.out.println(c2);
		char c3 = pop();
		System.out.println(c3);
		char c4 = pop();
		System.out.println(c4);
		
//		push('d');
//		char c3 = pop();
//		System.out.println(c3);
		
//		char c2 = pop();
//		System.out.println(c1 + " " + c2);
		
//		push('d');
//		char c3 = pop();
//		System.out.println(c3);

	}
	
}
