package jianzhioffer;

/**
 * 
 * ��ת�������С����
 * 
 * ��Ŀ��
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת������һ����������������һ����ת�������ת�������СԪ�ء�
 * ���磺
 * 		{3,4,5,1,2}��{1,2,3,4,5}��һ����ת��
 * 
 * ˼·��
 * 	���ַ����ң����ڶ��ַ��ı��壬��Ҫ����ָ�루����������������ǰһ��һֱ����ǰ�벿�֣���һ��һֱ���ں�벿��
 * 	ֱ����ǰһ������+1���ں�һ�����������������СֵΪ��һ������ָ������ֵ
 * ע�⣺
 * 	���������ֵ�����������
 *  ������null���������
 *  ������ֻ����һ�����ֵ����飡����
 *  ������������ת��������������飡����
 * @author wjb
 *
 */
public class XuanZhuanArray {
	public static int findMinNum(int[] arr) throws Exception{
		if(arr == null){
			throw new Exception("Invalid parameters");
		}
		
		int start = 0;
		int end = arr.length-1;
		int mid = end/2;
		int value = arr[start];
		
		while(arr[start] >= arr[end]){			
			if((end-start)==1){
				value = arr[end];
				break;
			}			
			//�����������ֵ����ȣ�ֻ��ͨ��ѭ������
			if(arr[mid] == arr[start] && arr[mid] == arr[end]){
				value = test(arr, start, end);
				return value;
			}
			
			if(arr[mid] >= arr[start]){	//3,4,5,1,2��2,2,2,0,1
				start = mid;
			}else if(arr[mid] <= arr[end]){	//4,5,1,2,3��2,0,1,1,1
				end = mid;
			}
			mid = (start+end)/2;
		}		
		return value;
	}
	
	/**
	 * �����������������Ӧ�������ֵ����ȣ���ô��ֻ��ͨ��ѭ������������
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static int test(int[] arr, int start, int end){
		int value = arr[start];
		for(int i = start+1; i<end; ++i){
			if(value > arr[i]){
				value = arr[i];
			}
		}		
		return value;
	}
	
	public static void main(String[] args) throws Exception {
//		int[] arr = {3,4,5,1,2};
//		int[] arr = {1,2,3,4,5}; 
		int[] arr = {1};
//		int[] arr = {2,0,2,2,2};
//		int[] arr = {2,2,2,0,2};
		
		System.out.println(findMinNum(arr));
	}
}
