//package com.wjb.baidu;
///**
// * Сǿ��������û��������
// * 		String left[]���β�ַ��͵�ǰ�ַ������ַ���ȵ��ַ���
// * 		String right[]������ַ��͵�ǰ�ַ���β�ַ���ȵ��ַ���
// * @author wjb
// *
// */
//public class WordListOrder2 {
//	
//	public static int canArrangeWords(String arr[]){
//		String[] usedStr = new String[arr.length]; 
//		int[] used = new int[arr.length];
//		
//	}
//	
//	public static int test(String[] arr, int index, int[] used){
//		String[] left = new String[arr.length];
//		String[] right = new String[arr.length];
//		int n = 0;
//		int m = 0;
//		char start = arr[index].charAt(0);
//		char end = arr[index].charAt(arr[index].length());
//		for(int i = 0; i<arr.length; i++){
//			if(used[i] != 1){
//				if(arr[index].charAt(0) == end){
//					right[n++] = arr[index];
//					used[i] = 1;
//				}
//			}
//		}
//	}
//}
