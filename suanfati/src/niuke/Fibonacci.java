package niuke;

/**
 * ԭ����Fibonacci���㷨��
 * ��Ŀ��
 * 		һֻ����һ�ο�����1��̨�ף�Ҳ����һ����2��̨�ף�
 * ���ʣ�
 * 		n��̨�ף��ܹ��ж���������
 * ������
 * 		��һ����һ������ʣ�µ���f(n-1)�����
 * 		��һ������������ʣ�µ���f(n-2)�����
 * 		�ܹ�f(n)=f(n-1)+f(n-2)�����
 * 		n=1�� 1��
 * 		n=2�� 2��
 * 		n=3�� 3��
 * 		n=4�� 5��
 * 
 * @author wjb
 *
 */
public class Fibonacci {
	/**
	 * ����1
	 * �ݹ�
	 * Ч�ʵͣ��������ظ�����
	 * @param n
	 * @return
	 */
	public static int test1(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return test1(n-1) + test1(n-2);
	}
	
	/**
	 * ����2
	 * ʱ�临�Ӷ�ΪO(n)
	 * 
	 * @param n
	 * @return
	 */
	public static long test2(long n){
		long[] result = {0,1};
		if(n < 2){
			return result[(int) n];
		}
		long n1 = 0;
		long n2 = 1;
		long sum = 0;
		for(int i = 2; i<=n; i++){
			sum = n2 + n1;
			n1 = n2;
			n2 = sum;
		}
		return sum;			
	}
	
	public static void main(String[] args) {
//		System.out.println(test1(50));	//̫���ˣ��ݹ�Ĳ���̫����ʱ��̫��
		System.out.println(test2(50));
	}
}
