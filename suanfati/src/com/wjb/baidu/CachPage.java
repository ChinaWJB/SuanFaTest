package com.wjb.baidu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * һ����Ų�ͬ��ҳ�����飬������������棻һ�������С�����������棻
 * ��ҳ�������зţ�������������и���ҳ���������мӣ���ͬһ����ҳ�ڻ�����ֻ������һ������
 * ����������������һ�����û��Ҫ�������ҳ�����ڻ����д��ʱ�������ҳɾ����
 * ��ÿ����ҳ�����������ʱ��������û�и���ҳ���Ĵ�����
 * ����
 * 		{1,2,1,3,1,2}���ͻ����СΪ2�����������Ϊ5��
 * @author wjb
 *
 */
public class CachPage {
	/*
	 * ���ö��к�Mapʵ�ֻ���Ĺ��ܣ�
	 * ���������Ƚ��ȳ����������ڻ����е�ͣ��ʱ����pull�����Ƚ����
	 * Map���ڱ�������ҳ�Ƿ��Ѿ������ڻ����У����ң�Map�д����ҳ�����ǣ�ָ���Ļ����С������������Ҫ���Ŷ������Ӻͼ��١�
	 * 
	 */
	static Queue<Integer> q = new LinkedList<Integer>();
	static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	static int count = 0;
	
	public static int Test(int cache, int[] page){
		return Test1(cache, page, 0);
	}
	
	/**
	 * index�û�������ҳ�����е�ÿһ����ҳ������һ�κ��Լ�1
	 * @param cache
	 * @param page
	 * @param index
	 * @return
	 */
	public static int Test1(int cache, int[] page, int index){
		int value = count;
		if(index != page.length){
			if(cache != 0 && (map.get(page[index]) == null)){
				q.offer(page[index]);
				map.put(page[index], 1);
				cache--;
				index++;
				count++;
				value = Test1(cache, page, index);
			}else if(cache == 0 && (map.get(page[index]) == null)){
				map.remove(q.peek());
				q.poll();				
				q.offer(page[index]);
				map.put(page[index], 1);
				index++;
				count++;
				value = Test1(0, page, index);
			}else if(cache != 0 && (map.get(page[index]) != null)){
				index++;
				value = Test1(cache, page, index);
			}else if(cache == 0 && (map.get(page[index]) != null)){
				index++;
				value = Test1(cache, page, index);
			}else{
				return value;
			}
		}else{
			return value;
		}
		return value;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,1,3,1,2};
		int value = Test(2, num);
		System.out.println(value);
	}
}
