package jianzhioffer;

/**
 * ������3
 * ��Ŀ��
 * ��һ����ά�����У�ÿһ�ж����մ����ң�������ÿһ�У����ϵ��£�������
 * ���һ������������һ��ά�����һ���������ж��������Ƿ��и������������رȽϵĴ���
 * 
 * �����������Ͻǿ�ʼ�Ƚϣ�ÿ�ο���ȥ��һ���л�һ���У�
 * 
 * ���Ƚ�    7   ��
 * 
 * @author wjb
 *
 */
public class FindNumFromArray {
	public static int[] findNumber(int[][] arr, int n, int m, int num){
		int[] index = new int[2];
		if(arr == null){
			index[0] = 0;
			index[1] = 0;
			return index;
		}
		int count = 0;
		int k = m-1;
		int l = 0;
		for(int i = l; i<n; i++){
			for(int j = k; j>=0; j--){
				count++;
				if(arr[i][j] == num){
					index[0] = 1;
					index[1] = count;
					return index;
				}
				if(arr[i][j] > num){
					k--;
				}
				if(arr[i][j] < num){
					l++;
					break;
				}
			}
		}
		index[0] = 0;
		index[1] = count;
		return index;
	}
	
	
	public static void main(String[] args) {
		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		int[][] array = new int[4][4];
//		int[][] array = null;
		int[] flag = findNumber(array, 4, 4, 0);
		System.out.println("boolean: " + flag[0] + ", count: " + flag[1]);
	}
}
