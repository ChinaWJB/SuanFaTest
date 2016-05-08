package com.wjb.sort;

public class QuickSort {
	/**
	 * ����һ���εݹ鶼д��һ��������
	 * �����Ǹ���Ԫ�ص�ֵ�����飬����ĳ��ֵ��Ԫ�ط���һ�飬��С�ڵķ�����һ�飬��ֵ��Ϊ��׼
	 * ���鲢����ķ�������Ǽ���������Ԫ�ش���������У���ô�������ǰ��һ��Ԫ����Ϊһ�飬����һ����Ϊ��һ�顣
	 * ���ź͹鲢��������������Խ�򵥣������ĺϲ����Ծ�Խ����
	 * @param a
	 * @param low
	 * @param high
	 */
	public void quicksort(int a[], int low, int high){
		int i = low;
		int j = high;
		if(i >= j){		//һ��Ҫ������ж���ֹ������ݹ��޷�ֹͣ��ֱ���ڴ����
			return;
		}
		int temp = a[i];
		while(i<j){
			while(i<j && a[j]>=temp){//��ǰ����Ƚ�
				j--;
			}
			if(i<j){
				a[i++]=a[j];		//����tempС��ֵ��������a[i],����i=i-1
			}
			
			while(i<j && a[i]<temp){//�Ӻ���ǰ�Ƚ�
				i++;
			}
			if(i<j){
				a[j--]=a[i];		//����temp���ֵ��������a[j],Ȼ��j=j+1
			}
		}
		a[i]=temp;
		quicksort(a, low, i-1);
		quicksort(a, i+1, high);	
	}
	
	public void sort(int[] a){
		quicksort(a, 0, a.length-1);
	}
	
	/**
	 * ����2
	 * ÿһ�˿���֮��begin=end����ʱ��a[begin]=a[end]=midvalue
	 * ����һ������Ϊ��׼�����浽�ݴ�����У����ڱȽϣ�����������������ͨ�����齻����������ֵ��
	 * @param a
	 * @param begin
	 * @param end
	 * @return
	 */	
	public int partition(int[] a, int begin, int end){
		int midvalue = a[begin];
		while(begin < end){
			while(begin < end && a[end]>=midvalue){
				end--;
			}
			swap(a, begin, end);
			while(begin < end && a[begin]<midvalue){
				begin++;
			}
			swap(a, begin, end);
		}
		return begin;	//��ʱ��a[begin]=a[end]=midvalue�����ص������±�Ϊ�ź����
	}
		
	public void swap(int[] a, int begin, int end){
		int temp = a[end];
		a[end] = a[begin];
		a[begin] = temp;
	}
	
	/**
	 * ��������֮�������ͨ��partition���ź�һ���򣬼����ͷ���Ǹ�Ԫ���ź��򣬷�������������ֵ
	 * �ٽ���ݹ飬����ֵ������ֱ��������
	 * @param a
	 * @param begin
	 * @param end
	 */
	public void qSort(int[] a, int begin, int end){
		int middle;
		if(begin < end){		//һ��Ҫ������ж���ֹ������ݹ��޷�ֹͣ�����ڴ����
			middle = partition(a, begin, end);
			qSort(a, begin, middle-1);
			qSort(a, middle+1, end);
		}
	}
	
	public void sort2(int[] a){
		qSort(a, 0, a.length-1);
	}
	
	public static void main(String[] args) {
//		int[] array = {7,3,9,5,8,2,4};
		int[] array = {1,4,2,2,2,2,2,8,5};
		QuickSort qs = new QuickSort();
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		qs.sort2(array);
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
	
}	
