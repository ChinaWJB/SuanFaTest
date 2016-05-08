package jianzhioffer.stackqueque;

import java.util.Stack;

/**
 * ����ջģ�����
 * 
 * ѹ���У�
 * 		ֻ��ջ1��ѹ
 * �����У�
 * 		ֻ����ջ2��Ԫ��
 * 		���ջ2��Ϊ�գ�ֻ�ǵ���ջ2�е�Ԫ�ؼ���
 * 		���ջ2Ϊ�գ����Ƚ�ջ1�е�Ԫ��ȫ����������ѹ�뵽ջ2��
 * 
 * @author wjb
 *
 */
public class StackToQueue {
	static Stack<Character> s1 = new Stack<Character>();
	static Stack<Character> s2 = new Stack<Character>();
	
	public static void offer(char value){
		s1.push(value);
	}
	
	public static char pull(){
		if(!s2.isEmpty()){
			return s2.pop();
		}else if(!s1.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
			return s2.pop();
		}else{
			return (Character) null;
		}
	}
	
	public static void main(String[] args) {
		offer('a');
		offer('b');
		offer('c');
		
		char c1 = pull();
		System.out.println(c1);
		

		
		char c2 = pull();
		System.out.println(c2);
		

		
		char c3 = pull();
		System.out.println(c3);
		
		offer('a');
		offer('d');
		char c4 = pull();
		char c5 = pull();
		System.out.println(c4);
		System.out.println(c5);
	}
}	
