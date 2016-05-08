package com.wjb.baidu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ֻ��Ҫ���У��������Լ���Iterator����Iterator���������е�Ԫ��
 * 
 * Queue<Integer> q = new LinkedList<Integer>();
 * 
 * @author wjb
 *
 */
public class CachPage2 {
	
	static Queue<Integer> q = new LinkedList<Integer>();
	static int count = 0;	//���������������ҳ��
	
	public static int test(int cache, int[] page){
		return test1(q,cache, page, 0);
	}
	
	public static int test1(Queue<Integer> queue, int cache, int[] page, int index){
		int temp = 0;
		Iterator<Integer> it = queue.iterator();
		/*
		 * ����û��������ҳ�����е���ҳ��û�б�����
		 */
		if(cache != 0 && index != page.length){
			/*
			 * �������У��鿴�������Ƿ��Ѿ����ڴ�������ҳ
			 */
			while(it.hasNext()){
				if(it.next() == page[index]){
					temp = 1;
					break;
				}
			}
			/*
			 * ������û�и���ҳ
			 */
			if(temp != 1){
				count++;
				queue.offer(page[index]);
				cache--;
				index++;
				test1(queue, cache, page, index);
			}else{	//���������и���ҳ
				index++;
				test1(queue, cache, page, index);
			}
		}
		/*
		 * ������������ҳ�����е���ҳû�б�����
		 */
		else if(cache == 0 && index != page.length){
			/*
			 * �������У��鿴�������Ƿ��Ѿ����ڴ�������ҳ
			 */
			while(it.hasNext()){
				if(it.next() == page[index]){
					temp = 1;
					break;
				}
			}
			/*
			 * ������û�и���ҳ
			 */
			if(temp != 1){
				count++;
				queue.poll();
				queue.offer(page[index]);
				index++;
				test1(queue, 0, page, index);
			}else{	//���������и���ҳ
				index++;
				test1(queue, cache, page, index);
			}
		}
		/*
		 * ��ҳ�����Ѿ��������ˣ����ܻ�������Ƿ����������ն�����count
		 */
		return count;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3};
		int value = test(2, num);
		System.out.println(value);
	}
}
