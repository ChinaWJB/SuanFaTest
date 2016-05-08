package com.wjb.sort;

public class SelectSort {
	/**
	 * ѡ������ԭ������forѭ����ѡ����С����ǰ��
	 * @param a
	 */
	public void selectSort(int[] a){
		int temp = 0;	//���ڼ�¼��Сֵ
		int num = 0;
		for(int i=0; i<a.length; i++){
			temp = a[i];	//���ڼ�¼��Сֵ
			num = i;		//���ڼ�¼��Сֵ���±�		
			for(int j=i+1; j<a.length; j++){
				if(a[j]<temp){	//ע�⣺ÿ�αȽ���֮��ֱ�ӽ��н��������Ǽ�¼������ǰ��Сֵ��ֵ�����꣬���һ������
					temp = a[j];
					num = j;
				}
			}
			if(num!=i){
				a[num] = a[i];
				a[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {7,3,9,5,8,2,4};
		SelectSort ss = new SelectSort();
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		ss.selectSort(array);
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
}
