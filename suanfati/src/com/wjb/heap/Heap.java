package com.wjb.heap;

public class Heap {
	int[] heapArray;
	int heapsize;
	public Heap(int[] array){
		this.heapArray = array;
		this.heapsize = array.length;	//��ʼ����ʱ����ȣ����������ʱ�򣬻Ὣ�Ѷ�����Ԫ�طŵ�����棬����heapsize��-1
	}
	/**
	 * �ݹ鷨ά����ĳ�����Ĵ󶥶�
	 * ����һ��������±꣬Ҳ�Ƕ�������һ������±꣬ά�����������µ����н��
	 * @param index
	 */
	public void Max_Heap(int index){
		int l = left(index);
		int r = right(index);
		int largest = 0;	//���ڽ����ֵ���±걣������
		//���Ҵ������Ľڵ���������Һ��ӽڵ�����ֵ���������������������ֵ�����������ʹ�����������Ԫ��ֵ���н���
		if(l<heapsize && heapArray[l]>heapArray[index]){
			largest = l;
		}else{
			largest = index;
		}
		if(r<heapsize && heapArray[r]>heapArray[largest]){
			largest = r;
		}
		//�����ݹ�����
		//����Ѿ��Ǵ󶥶Ѿͷ��أ���Ϊ�����¶��ϵģ��������ĵ�����󶥶ѣ�������ӽ��ض�����󶥶����ʣ������������ж�
		//���жϵ�Ҷ�ӽ��ʱ������largest > heapsize���Ի�return
		if(largest == index || largest > heapsize){
			return;
		}
		//�������ֵ�ʹ�����������Ԫ��
		int temp = heapArray[largest];
		heapArray[largest] = heapArray[index];
		heapArray[index] = temp;
		
		Max_Heap(largest);
	}
	
	public int left(int i){
		return 2*(i+1)-1;
	}
	public int right(int i){
		return 2*(i+1);
	}	
	public int parents(int i){
		return (i-1)/2;
	}
	
	/**
	 * ���󶥶�
	 * �������ϣ��ӷ�Ҷ�ӽ�㿪ʼ
	 * ԭ��ÿ��ά��������Ĵ󶥶ѣ��������ά��ʱ�����ƻ�����Ĵ󶥶ѽṹ
	 * @param h
	 */
	public void Build_Max_Heap(Heap h){
		for(int i = h.heapsize/2-1; i>=0; i--){
			Max_Heap(i);
		}
	}
	
	/**
	 * ������
	 */
	public void heapsort(){
		for(int i = 0; i<heapArray.length; i++){
			//ִ��n�Σ���ÿ����ǰ����ֵ�ŵ���ĩβ����ά���󶥶�
			int temp = heapArray[0];
			heapArray[0] = heapArray[heapsize-1];
			heapArray[heapsize-1] = temp;
			heapsize--;
			Max_Heap(0);
		}
	}
	
	
	/**
	 * ��ӡ�ѽṹ
	 * ÿһ��ĵ�һ��Ԫ�ص��±꣬������һ��Ԫ���±��2*i-1
	 * @param array
	 */
	private static void printHeapTree(int[] array){
	    for(int i=1; i<array.length; i=i*2){
	        for(int k=i-1; k<2*i-1 && k<array.length; k++){
	            System.out.print(array[k]+" ");
	        }
	        System.out.println();
	    }    
	}
	
	/**
	 * ��ӡ��ǰ������
	 * @param array
	 */
	private static void printheap(int[] array){
		for(int i=0;i<array.length;i++){
	        System.out.print(array[i]+" ");
	    }
		System.out.println();
	}
	
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args){
	    int[] array=new int[]{1,2,3,4,7,8,9,10,14,16};
	    Heap heap=new Heap(array);
	    
	    System.out.println("ִ�����ѻ�ǰ�ѵĽṹ��");
	    printHeapTree(heap.heapArray);
	    printheap(heap.heapArray);
	    
	    heap.Build_Max_Heap(heap);
	    System.out.println("ִ�����ѻ���ѵĽṹ��");
	    printHeapTree(heap.heapArray);
	    printheap(heap.heapArray);
	    
	    heap.heapsort();
	    System.out.println("ִ�ж���������������");
	    printheap(heap.heapArray);	    
	}
}
