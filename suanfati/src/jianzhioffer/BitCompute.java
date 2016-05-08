package jianzhioffer;

/**
 * ��Ŀ��
 * 		ʵ��һ������������һ������������ö����Ʊ�ʾ�е�1�ĸ�����
 * 
 * >>�з��ŵ����ƣ���������÷���λ���룬��Ϊ������м����ʱ�����Բ������ʽ�����
 * >>>�޷���λ���ƣ����������0����
 * <<�����ŵ����ƣ��൱�ڳ���2
 * @author wjb
 *
 */
public class BitCompute {
	/**
	 * ����1
	 * ��ı䴫������ֵ
	 * ��>>>ȡ��>>����Ϊ���Ϊ�����Ļ�>>�������ѭ��
	 * @param n
	 * @return
	 */
	public static int test1(int n){
		int count = 0;
		while(n!=0){
			if((n & 1) != 0){
				count++;
			}
			n = n>>>1;
		}
		return count;
	}
	
	/**
	 * ����2
	 * ֻ�ı����ڱȽϵı�־λ
	 * ��������ֵ
	 * @param n
	 * @return
	 */
	public static int test2(int n){
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if((n & flag) != 0){
				count++;				
			}
			flag = flag << 1;
		}
		return count;
	}
	
	/**
	 * ����3��
	 * ��1���������
	 * �ж��ٸ�1,�Ϳ��Խ��ж��ٴ������Ĳ���
	 * ˼·��
	 * 		����������Ķ����Ʊ�ʾ�����ұ�1λ�ڵ�mλ����ô��ȥ1ʱ����mλ��1��Ϊ0������mλ֮�������0�����1�������е�mλ֮ǰ������λ�����ֲ��䡣
	 * 		����ԭ������������������൱�ڰ����ұߵ�һ��1���0.�����ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ���
	 * @param n
	 * @return
	 */
	public static int test3(int n){
		int count = 0;
		while(n != 0){
			++ count;
			n = (n-1) & n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(test3(0));
		//�����߽�
		System.out.println(test3(0x80000000));
		System.out.println(test3(0xFFFFFFFF));
		//�����߽�
		System.out.println(test3(1));
		System.out.println(test3(0x7FFFFFFF));
	}
}
