package mianshibaodian;

import java.util.ArrayList;

public class SuShu100 {
	public ArrayList<Integer> primeNumber(int n){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 2; i<=n; i++){	//��С������Ϊ2
			double sqrti;
			boolean flag = true;	//��־λ�������жϵڶ���forѭ������ʱ�������������Ļ��ǲ�������������
			sqrti = Math.sqrt(i);	//ֻ��Ҫ�жϵ�2�������ĸ���ֵ֮ǰ���Ϳ����ж��ǲ���������
			for(int j = 2; j<sqrti; j++){
				if(i%j == 0){
					flag = false;
					break;
				}
			}
			if(flag){				//��־λ��������ʱ������ӵ�ArrayList��
				al.add(i);
			}
		}		
		return al;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		SuShu100 ss = new SuShu100();
		al = ss.primeNumber(100);
		System.out.println(al);
	}
}
