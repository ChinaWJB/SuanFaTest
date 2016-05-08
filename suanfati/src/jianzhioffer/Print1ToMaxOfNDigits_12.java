package jianzhioffer;

/**
 * 20160429
 * ��Ŀ��12������ע��������⣩
 * 		��������n����˳���ӡ����1������nλʮ��������
 * 		���磺����3�����ӡ��1��2��3һֱ������3λ����999
 * 
 * �����ַ����������char[]��
 * 
 * @author wjb
 *
 */
public class Print1ToMaxOfNDigits_12 {
	public static void test(int n){
		if(n<=0){
			return;
		}
		char[] num = new char[n];
		for(int i = 0; i < n; i++){
			num[i] = '0';
		}
		while(!increate(num)){
			printNum(num);
		}
	}
	
	public static boolean increate(char[] num){
		int len = num.length;
		int sum = 0;
		int over = 0;
		boolean flag = false;	//��ѭ���Ľ�����־λ�������������ʱ������
		for(int i = len-1; i >= 0; i--){
			sum = num[i] - '0' + over;
			if(i == len-1){	//ֻ��ÿ�����½���������λ��1��ʱ��Ž���
				sum++;
			}
			if(sum >= 10){//�н�λ
				if(i == 0){
					flag = true;	//��ʱ�Ѿ��������
				}
				over = sum/10;
				int gewei = sum%10;
				num[i] = (char)(gewei + '0');
			}else{//û�н�λ
				num[i] = (char)(sum + '0');
				break;//���û�н�λ����1���˳�ѭ��
			}
		}
		return flag;
	}
	
	public static void printNum(char[] num){
		String s = "";
		boolean flag = false;
		for(int i = 0; i < num.length; i++){
			if(num[i] != '0' && flag == false){
				s += num[i];
				flag = true;
				continue;
			}
			if(flag){
				s += num[i];
			}
		}
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		test(3);
	}
}
