package mianshibaodian;

public class WordsOfString {
	/**
	 * �Լ�д����һ���ַ������ҳ����е��ʵĸ���;
	 * 1.��ȥ���ַ����׵Ŀո�
	 * 2.��������if�ж�
	 * 3.��һ��if����s.charAt(index)��' '�Ƚ�i����Ϊ�ո�����������if�������������ѭ��
	 * 4.�ڶ���if���ٴαȽ�i+1������Ϊ�ո���count++�������������ѭ��
	 * @param s
	 * @return
	 */
	public int wordCount(String s){
		int count = 0;
		int j = 0;
		s = s.trim();
		
		/*ȥ���ַ����׵Ŀո�*/
		if(s.charAt(0) == ' '){
			for(; j<s.length(); j++){
				if(s.charAt(j) != ' '){					
					break;
				}
			}
		}
		for(int i = j; i<s.length(); i++){
			if(s.charAt(i) == ' '){
				if(s.charAt(i+1) != ' '){
					count++;
				}
			}
		}		
		return count+1;
	}
	
	/**
	 * java���Ա���
	 * ���ñ�־λ���ж��Ƿ�Ϊ�գ�
	 * ֻҪΪ' '�ͽ���־λ��0
	 * �������if()��else if()
	 * @param s
	 * @return
	 */
	public int wordCount2(String s){
		int count = 0;
		int signal = 0;		//�ñ�־λ���ж��Ƿ�Ϊ��һ�����ʣ�ֻҪ�ǿո񣬾ͽ�signal��0
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == ' '){
				signal = 0;
			}else if(signal == 0){	//����ó�����������������1.�ַ���Ϊ�գ�2.��־λΪ0��ȷ���ǿո��ĵ��ʣ�
				signal = 1;
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		WordsOfString wn = new WordsOfString();
		System.out.println(wn.wordCount("   I am     wangjiabin"));
	}
}
