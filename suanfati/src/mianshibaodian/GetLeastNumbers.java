package mianshibaodian;

import java.util.ArrayList;

import com.wjb.heap.Heap;

public class GetLeastNumbers {
	/**
	 * ��һ�����������У��ҳ���С��ǰk������
	 * ����1��log(n)����Ϊ����Ҫ����ֻ��Ҫpartition
	 * ȱ�㣺���޸����������е�Ԫ��λ��
	 * ���ÿ��ŵ�partition���������򣩣��ҳ�index������index��k���бȽϣ������ȣ��򷵻�ǰk����
	 * ���С��k�����index+1��end
	 * �������k�����begin��index-1
	 * ����һ�����ҵ�index == k�������ô���Ϊ����ѭ��������
	 * @param num
	 * @param k
	 */
	public void test1(int[] num, int k){
		if(k<=0 || k>num.length){	//�����k������Ҫ��
			return ;
		}
		int[] kvalue = new int[k];
		int index = 0;
		int start = 0;
		int end = num.length-1;
		index = partition(num, 0, num.length-1);
		while(index != k-1){
			if(index < k-1){
				start = index+1;
				index = partition(num, start, end);
			}else{
				end = index-1;
				index = partition(num, start, end);
			}
		}
	}
	
	/**
	 * partitionÿ��ֻ�ܽ�һ��Ԫ�طŵ���ȷ��λ�ã����������λ��
	 * ÿ�ν���patition����һ��Ԫ����ΪҪȷ��λ�õ�Ԫ��
	 * @param num
	 * @param begin
	 * @param end
	 * @return
	 */
	public int partition(int[] num, int begin, int end){
		int temp = num[begin];
		while(begin < end){
			while(begin < end && num[end] > temp){
				end--;
			}
			swap(num, begin, end);
			while(begin < end && num[begin] <= temp){//ע�⣺������һ���Ⱥţ����������ȵĻ�����ѭ��
				begin++;
			}
			swap(num, begin, end);
		}
		return begin;	
	}
	
	public void swap(int[] num, int m, int n){
		int temp = num[m];
		num[m] = num[n];
		num[n] = temp;
	}
	
	
	
	/**
	 * ����2��O(nlgk),��ΪҪ����n�Σ�����ÿ��ά���󶥶ѣ���Ϊlogk
	 * 
	 * �ʺϺ�������
	 * 
	 * ���ô󶥶���ʵ��
	 * �����½�һ������Ϊk��������
	 * Ȼ��ÿ�δӴ���������ȡһ�������������������е����Ƚϣ���С�����ģ����滻�����������ģ��������
	 * ÿ���滻����Ҫά���������Ĵ󶥶�����
	 * 
	 * ��û�иı�num�е�ֵ������ֻ��������һ����СΪk�����飬��ͣ���滻����ĵ�һ��Ԫ�أ����󶥶ѵĶѶ�����ά���󶥶�
	 * 
	 */
	public int[] test2(int[] num, int k){
		int[] value = new int[k];
		int i = 0;
		for(i = 0; i<k; i++){
			value[i] = num[i];
		}
		Build_Max_Heap(value, k);
		
		for(int j = i; j<num.length-1; j++){
			if(value[0]>num[j]){
				value[0] = num[j];
				Max_Heap(value, k, 0);
			}else{
				
			}
		}				
		return value;
	}
	
	/**
	 * ���¶���
	 * �ݹ鷨ά����ĳ�����Ĵ󶥶�
	 * ����һ��������±꣬Ҳ�Ƕ�������һ������±꣬ά�����������µ����н��
	 * @param index
	 */
	public void Max_Heap(int heapArray[], int k,  int index){
		int l = left(index);
		int r = right(index);
		int largest = 0;	//���ڽ����ֵ���±걣������
		
		//���Ҵ������Ľڵ���������Һ��ӽڵ�����ֵ���������������������ֵ�����������ʹ�����������Ԫ��ֵ���н���
		if(l<k && heapArray[l]>heapArray[index]){
			largest = l;
		}else{
			largest = index;
		}		
		if(r<k && heapArray[r]>heapArray[largest]){
			largest = r;
		}
		
		//�����ݹ�����
		//����Ѿ��Ǵ󶥶Ѿͷ��أ���Ϊ�����¶��ϵģ��������ĵ�����󶥶ѣ�������ӽ��ض�����󶥶����ʣ������������ж�
		//���жϵ�Ҷ�ӽ��ʱ������largest > heapsize���Ի�return
		if(largest == index || largest > heapArray.length){
			return;
		}
		
		//��һ��ִ��
		//������Ǹ��ڵ㣬�򽻻����ֵ�ʹ�����������Ԫ�أ����ٴεݹ飬ά���ӽ����Ϊ���ڵ����һ������
		int temp = heapArray[largest];
		heapArray[largest] = heapArray[index];
		heapArray[index] = temp;
		//���largest���Ǹ��ڵ㣬���ٴεݹ飬ά��
		Max_Heap(heapArray, k, largest);
	}
	public int left(int i){
		return 2*(i+1)-1;
	}
	public int right(int i){
		return 2*(i+1);
	}
	
	/**
	 * ���󶥶�
	 * 
	 * �������мǣ�
	 * �������������ϣ��ӷ�Ҷ�ӽ�㿪ʼ
	 * ������ԭ��ÿ��ά��������Ĵ󶥶ѣ��������ά��ʱ�����ƻ�����Ĵ󶥶ѽṹ
	 * @param h
	 */
	public void Build_Max_Heap(int[] a, int k){
		for(int i = k/2-1; i>=0; i--){
			Max_Heap(a, k, i);
		}
	}
	
	
	public static void main(String[] args) {
		GetLeastNumbers gln = new GetLeastNumbers();
		int[] num = {4,6,9,3,5,7,1,2,8};
		int k = 0;
		
		gln.test1(num, k);	//��Ϊ����ֱ�������������ϲ���������ֱ��ȡ���������ǰk���Ϳ�����
		for(int i = 0; i<k; i++){
			System.out.print(num[i] + " ");
		}
		
//		int[] temp = new int[k];
//		temp = gln.test2(num, k);
//		
//		for(int i = 0; i<k; i++){
//			System.out.print(temp[i] + " ");
//		}
	}
}
