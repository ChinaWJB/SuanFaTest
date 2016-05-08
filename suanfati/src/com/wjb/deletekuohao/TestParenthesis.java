package com.wjb.deletekuohao;

import java.util.Stack;

/**
 * (1,(2,3),(4,(5,6),7))
 * ����1���������ʽ�е����ţ����Ϊ��(1,2,3,4,5,6,7)
 * ����2��ͬʱ��Ҫ�жϱ��ʽ�Ƿ���ȷ�������Ƿ���ȷ�������ַ����Ƿ��������ַ���
 * ���ţ�parenthesis��bracket
 * @author wjb
 *
 */
public class TestParenthesis {
	/**
	 * ����1��
	 * 
	 * ֱ�Ӻϳɽ��
	 * 
	 * @param s
	 * @return
	 */
	public static String change_str(String s){
		String result = "(";			//���ڹ�������
		char[] ch = s.toCharArray();	//ת�����ַ�����
		int bracket_num = 0;			//�����ж����ŵ��Ƿ�ƥ��
		int i = 0;
		while(i < ch.length){
			if(ch[i] == '('){
				bracket_num ++;
			}
			else if(ch[i] ==')'){
				if(bracket_num > 0){
					bracket_num --;
				}else{					//��������Ŀ���ָ�ֵ���϶����쳣
					System.out.println("Expression wrong!");
					return null;
				}
			}
			else if(ch[i] == ','){
				result += ch[i++];	//ch[i++]Ϊ','����resultƴ�ӽ������i++
				continue;
			}
			else if(ch[i] >= '0' && ch[i] <= '9'){
				result += ch[i++];	//ֻ�ǽ����ֺ�","�ͽ������ϣ�
				continue;
			}
			else{						//˵�����������ַ���������쳣
				System.out.println("Expression wrong!");
				return null;
			}
			i++;	//����Ҫ��ѭ�������ж�����
		}
		if(bracket_num != 0){	//����������Ӧ��Ϊ0������϶����쳣
			System.out.println("Expression wrong!");
			return null;
		}
		result += ')';	//ƴ�ӽ���ַ��������һ��������
		return result;
	}
	
	/**
	 * ����2��
	 * 
	 * ��ջʵ��
	 * 
	 * @param s
	 * @return
	 */
	public static String test(String s){
		Stack<Character> stack = new Stack<Character>();
		char[] ch = s.toCharArray();
		int count = 0;
		stack.push('(');
		String value = "";
		for(int i = 0; i<ch.length; i++){
			if(ch[i] == '('){
				count++;
			}else if(ch[i] == ')'){
				if(count>0){
					count--;
				}else{
					System.out.println("ERROR");//�����Ŷ಻ƥ��
					return null;
				}
			}else if(ch[i] >= '0' && ch[i] <= '9'){
				stack.push(ch[i]);
			}else if(ch[i] == ','){
				stack.push(ch[i]);
			}else{
				System.out.println("ERROR");//�������ַ�
				return null;
			}
		}
		if(count != 0){
			System.out.println("ERROR");//�������Ų�ƥ��
			return null;
		}
		stack.push(')');
		while(!stack.isEmpty()){
			value = stack.pop() + value;
		}
		return value;
	}
	
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "(1,(2,3),(4,(5,6),7))";
//		String result = change_str(s);
		String result = test(s);
		if(result != null){
			System.out.println(result);
		}
		
		s = "((1,(2,3),(4,(5,6),7))";
//		result = change_str(s);
		result = test(s);
		if(result != null){
			System.out.println(result);
		}
	}
}
