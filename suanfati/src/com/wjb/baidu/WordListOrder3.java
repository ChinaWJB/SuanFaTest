package com.wjb.baidu;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * ��ArrayList<String>����������ȡ��Iterator
 * @author wjb
 *
 */
public class WordListOrder3 {
	static int value = -1;
	public static int canArrangeWords(String arr[]){
		if(arr.length == 1){
			return -1;
		}		
		
		//���ڷ�����ң���ǰ�����Ķ�Ӧ�������е��ַ����Ƿ��Ѿ����ù�
		int[] index = new int[arr.length];
		for(int i = 0; i<index.length; i++){
			index[i] = 0;
		}
		
		//����Ѿ��ù����ַ�����ͨ��������С���ж��Ƿ��Ѿ���������
		ArrayList<String> al = new ArrayList<String>();
		
		//ѭ����ÿ�����е�ÿһ��Ԫ�ض���һ����Ԫ��
		for(int i = 0; i<arr.length; i++){
			String str = arr[i];
			al.add(str);
			index[0] = 1;
			test(arr, str, al, index);
			if(value == 1){
				break;
			}else{
				al.remove(str);
				index[0]=0;
			}
//			System.out.println((String)it.next());
		}
		return value;
	}
	
	public static void test(String[] arr, String s, ArrayList<String> al, int[] index){
		if(value ==1){
			return;
		}
		int j = 0;
		while(j < arr.length && value != 1){
			if(index[j] == 0){
				char begin = arr[j].charAt(0);
				char end = s.charAt(s.length()-1);
				if(begin == end){
					al.add(arr[j]);
					index[j] = 1;
					if(al.size() == arr.length){
						value = 1;
						break;
					}	
					test(arr, arr[j], al, index);
					if(value != 1){
						al.remove(arr[j]);
						index[j] = 0;
					}

				}				
			}
			j++;			
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
		String[] arr = {"abc","cba","abc","cbu","tbm"};
//		String[] arr = {"abc"};
		int num = canArrangeWords(arr);
		System.out.println(num);
//		canArrangeWords(arr);
	}
}
