package niuke.wanmei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ����һϵ�����������밴��Ҫ������ֽ��з��࣬�����
 * A1 = �ܱ�5����������������ż���ĺͣ�
 * A2 = ��1�����ֽ��н�����ͣ���n1-n2+n3-n4...
 * A3 = ��2�����ֵĸ�����
 * A4 = ��3�����ֵ�ƽ��������ȷ��С�����1λ
 * A5 = ��4�������е��������
 * @author wjb
 *
 */
public class NumbersClass {
	public static void test(String s){
		System.out.println("���룺 ");
		Scanner scanner = new Scanner(s);
//		ArrayList<Integer> al = new ArrayList<Integer>();		
		int size = scanner.nextInt();
		int[] num = new int[size]; 
//		while(scanner.hasNext()){
//			al.add(scanner.nextInt());
//		}
		for(int i = 0; i<size && scanner.hasNext(); i++){
			num[i] = scanner.nextInt();
		}
		int sum1 = 0;
		int sum2 = 0;
		int count = 0;
		float fnum = 0.0f;
		int max = 0;
		int flag =0 ;
		int n = 0;
		for(int i = 0; i<size; i++){
			int temp = num[i]%5;
			if(temp == 0 && num[i] % 2 == 0){
				sum1 += num[i];
			}else if(temp == 1){
				flag++;
				if(flag%2==0){
					sum2 -= num[i];
				}else{
					sum2 += num[i];
				}				
			}else if(temp == 2){
				count++;
			}else if(temp == 3){
				n++;
				fnum += num[i];
			}else{
				if(max<num[i]){
					max=num[i];
				}
			}			
		}
		fnum = fnum/n;
		int b = (int)Math.round(fnum*10);
		fnum = (float)(b/10.0);
		System.out.print(sum1 + " " + sum2 + " " + count + " " + fnum + " " + max);
		
	}
	
	
	public static void main(String[] args) {
		//13 1 2 3 4 5 6 7 8 9 10 20 16 18
		//30 11 2 9.7 9
		test("13 1 2 3 4 5 6 7 8 9 10 20 16 18");
	}
}
