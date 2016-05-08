package jianzhioffer;

/**
 * û��ʵ��
 * 
 * ��һ���ַ����еĿո�ת����"%20"��
 * Ҫ��ֻ����ԭ�����ַ������ϸı䣬������ʵ���µ�����
 * ����1��O(n*n)
 * ����2��O(n)
 * ����2˼·��(��β��ͷ)
 * �ȱ���һ���ҳ��ո���
 * ʵ���������ͱ�����oldlength��newlength���ֱ�Ӿ������β�������������β����ǰ���������ɵ��ַ����µ��ַ������и��ƣ�
 * ���յ�oldlength==newlengthʱ˵�����Ѿ�û�пո���
 * @author wjb
 *
 */
public class ReplaceKongGe {
	/**
	 * ch[]�а����ַ������ж�����㹻�Ŀռ�
	 * lengthΪch�Ŀռ��С
	 * @param ch
	 * @param length
	 * @return
	 */
	public static String replace(char[] ch, int length){
		int index = 0;
		int oldlength = 0;
		int newlength = 0;
		while(ch[index] != '\0'){	
			char c = ch[index];
			oldlength++;
			if(ch[index] == ' '){
				newlength++;
			}
			index++;
		}
		newlength = oldlength + newlength*2;
		if(newlength > length){
			return null;		//˵��ch�Ŀռ䲻������չ
		}
		
		while(oldlength < newlength && oldlength >= 0){
			if(ch[oldlength] == ' '){
				ch[newlength--] = '0';
				ch[newlength--] = '2';
				ch[newlength--] = '%';
			}else{
				ch[newlength--] = ch[oldlength];
			}
		}
		
		return String.valueOf(ch);
	}
	
	public static void main(String[] args) {
		String str = "I am wang";
//		char[] ch = {'I',' ','a','m',' ','w','a','n','g','\0','','','','','',''};
		char[] ch = new char[20];
		System.out.println("ch.length: " + ch.length);
		ch = str.toCharArray();
		System.out.println("ch.length2: " + ch.length);
		int i = 0;
		while(ch[i] != '\0'){
			System.out.println(String.valueOf(ch[i]) + ":");
			i++;
		}
//		System.out.println(replace(ch, ch.length));
	}
}
