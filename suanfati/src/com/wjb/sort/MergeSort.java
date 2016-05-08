package com.wjb.sort;

public class MergeSort {
	/**
	 * ��ʵ���ڷ��Σ��ݹ鷵����һ�㣬�ڸò�Ĭ���������鶼���ź���ġ�Ȼ�����ź����ϲ�������һ��
	 * @param a
	 * @param p
	 * @param q
	 * @param r
	 */
	public static void merge(int a[], int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int i,j,k;
		int[] L = new int[n1];	//Ϊ�˽���������������з���
		int[] R = new int[n2];	//Ϊ�˽���������������з���
		
		for(i=0,k=p; i<n1; i++,k++){
			L[i]=a[k];			//����������������֣���벿�ָ�������
		}
		for(j=0,k=q+1; j<n2; j++,k++){
			R[j]=a[k];			//����������������֣��Ұ벿�ָ�������
		}
		
		for(k=p,i=0,j=0; i<n1&&j<n2; k++){
			if(L[i]>R[j]){		//������������бȽϣ�Ȼ��С�ķ��뵽ԭ���飬��Ľ������Ƚ�
				a[k]=R[j];
				j++;
			}else{				//������������бȽϣ�Ȼ��С�ķ��뵽ԭ���飬��Ľ������Ƚ�
				a[k]=L[i];
				i++;
			}			
		}
		if(i<n1){
			for(j=i; j<n1; j++,k++){
				a[k] = L[j];	//��Ĳ������η���ԭ��������
			}
		}
		if(j<n2){
			for(i=j; i<n2; i++,k++){
				a[k] = R[i];
			}
		}
	}
	
	/**
	 * �ݹ�ʵ�ֹ鲢����
	 * @param a
	 * @param p
	 * @param r
	 */
	public void mergeSort(int a[], int p, int r){
		if(p<r){
			int q = (p+r)/2;
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {7,3,9,5,8,2,4};
		MergeSort ms = new MergeSort();
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		ms.mergeSort(array, 0, array.length-1);
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
}
