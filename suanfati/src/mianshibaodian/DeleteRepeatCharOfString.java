package mianshibaodian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeleteRepeatCharOfString {
	/**
	 * ����1��
	 * �Լ���ģ�
	 * ԭ����map�ж��ظ�����ArrayListװmap��û�г��ֹ����ַ�
	 * @param s
	 * @return
	 */
	public String test(String s){
		String str = "";
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		ArrayList<Character> al = new ArrayList<Character>();
		
		for(int i = 0; i<s.length(); i++){
			if(map.get(s.charAt(i)) != null){
				continue;
			}else {
				map.put(s.charAt(i), 1);
				al.add(s.charAt(i));
			}
		}
		for(int j = 0; j < al.size(); j++){
			str += al.get(j);
		}			
		return str;	
	}
	
	/**
	 * ����2
	 * ��������
	 * ����ѭ�����бȽϣ������е��ظ����ַ���Ϊ'\0';
	 * �������'\0'ȥ��
	 * ʡ�ԡ�����������
	 */
	
	/**
	 * �ռ佻��
	 * ����һ��256��int���͵����飬����һ�ν���ӦΪ��1��������0���ظ�����ʱ���ַ������Ӧλ��'\0'
	 * intλ32λ�����Դ�СΪ8�Ϳ�����
	 * @param str
	 * @return
	 */
	public String removeDuplicate(String str){
		String s = "";
		char[] c = str.toCharArray();
		int len = c.length;
		int[] flag = new int[8];
		//�Ƚ���־λ�ַ������ʼ��Ϊ0
		for(int i = 0; i<8; i++){
			flag[i] = 0;
		}
		
		//������Ͱ�Ĳ���+��λ��λ�жϵķ����������ظ����ֵ��ַ�����������'\0'
		for(int i = 0; i<c.length; i++){
			int index = c[i]/32;		//�������ΪͰ������0~7
			int shift = c[i]%32;		//�������ΪͰ��Ԫ�ص�����0~31
			if(((flag[index]) & (1<<shift)) != 0){
				c[i] = '\0';
			}
			flag[index] |= (1<<shift); 
		}
		
		//���ַ������е�'\0'ȡ����������'\0'���ַ���ǰ����ַ�����
		int l = 0;
		for(int i = 0; i<c.length; i++){
			if(c[i] != '\0'){
				c[l++] = c[i];
			}
		}				
		return new String(c, 0, l);
	}
	
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		DeleteRepeatCharOfString d = new DeleteRepeatCharOfString();
		String s = "   ab   ccdddef";
		System.out.println(d.test(s));
		System.out.println(d.removeDuplicate(s));
	}
}
