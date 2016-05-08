package com.wjb.baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.management.Query;
/**
 * ��һ���ַ������飬�����������е��ַ��������������У�
 * ������кú��κ�һ���ַ���������ĸ����ǰһ���ַ�����β��ĸ����˵������ַ������������������򷵻�1�����򷵻�-1
 * ע�⣺Set�в������ظ���
 * ����ArrayList
 * 
 * Сǿ��ʾ��
 * 		1.������ֵ��ͬ�ĺϲ�������Ҫÿһ���ж�֮�󶼷��أ��򻯴��룻
 * 
 * @author wjb
 *
 */
public class WordListOrder {
	static int value = -1;
	public static int canArrangeWords(String arr[]){
		if(arr.length == 1){
			return -1;
		}
		ArrayList<String> set = new ArrayList<String>();
		for(int i = 0; i<arr.length; i++){
			set.add(arr[i]);
		}
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			if(value == 1){
				break;
			}
			String temp = (String)it.next();
			
			ArrayList<String> set0 = new ArrayList<String>();
			copy(set, set0);
			set0.remove(temp);
			
			test(set0, temp);
			if(value == 1){
				break;
			}
//			System.out.println((String)it.next());
		}
		return value;
	}
	
	public static void test(ArrayList<String> set, String s){
		if(value == 1){
			return;
		}
		
		ArrayList<String> set0 = new ArrayList<String>();
		copy(set, set0);
		Iterator it0 = set0.iterator();
		while(it0.hasNext() && value != 1){
			String temp = (String)it0.next();
			char begin = temp.charAt(0);
			char end = s.charAt(s.length()-1);
			if(begin == end){
				ArrayList<String> set1 = new ArrayList<String>();
				copy(set0, set1);
				set1.remove(temp);
				if(set1.size() == 0){
					value = 1;
					break;
				}
				test(set1, temp);
			}else{
				
			}
		}
	}
	
	public static void copy(ArrayList<String> seto, ArrayList<String> seti){
		Iterator it = seto.iterator();
		while(it.hasNext()){
			seti.add((String)it.next());
		}
	}
	
	public static void main(String[] args) {
//		String[] arr = {"ett","trc","cba","abu","utc"};
		String[] arr = {"abc","cba","abc","cbt","tbm"};
//		String[] arr = {"abc"};
		int num = canArrangeWords(arr);
		System.out.println(num);
//		canArrangeWords(arr);
	}
}
