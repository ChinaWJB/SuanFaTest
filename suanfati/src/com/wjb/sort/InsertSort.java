package com.wjb.sort;

public class InsertSort {
	/**
	 * ���������ԭ���ǣ���ǰҪ���������֮ǰ�ź�������Ƚϴ�С���ȵ�ǰ����Ͱ���������λ��ÿ����һλ
	 * ���Ա�֤�ȶ���
	 * @param a
	 */
	public void insertSort(int[] a){
		int j;
		int temp;
		for(int i=1; i<a.length; i++){	//��Ϊ��Ҫ��iǰ���ֵ��a[i]���бȽϣ�����i��СΪ1��
			temp = a[i];
			j = i;
			while(j>=1 && a[j-1]>temp){	//���ں�temp = a[i]���бȽ�
				a[j] = a[j-1];			//���ǰ�������temp�󣬾ͽ�������ƶ�һλ��ֱ������С����ڣ��ͽ�����������λ����
				j--;					//ע�⣺ÿ�β�ֱ�ӽ��н���������ֱ�Ӹ��Ǻ����ֵ�����temp�е�ֵ������ȷ��λ����
			}
			a[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {7,3,9,5,8,2,4};
		InsertSort is = new InsertSort();
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		is.insertSort(array);
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
}
