package com.wjb.baidu;

import java.util.ArrayList;
/**
 * ������������Լ���ĺ͵���������
 * @author wjb
 *
 */
public class PerfectNumber {
	public static int perfectNumber(int n){
		ArrayList<Integer> al = new ArrayList<Integer>();
		int value = 0;
		for(int i = 1; i<n; i++){
			if(n%i == 0){
				al.add(i);
				value += i;
				System.out.println(i);
			}
		}
		System.out.println("value " + value);
		if(value == n){
			return 1;
		}else{
			return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(perfectNumber(28));
	}
}
