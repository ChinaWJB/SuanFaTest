package substring;

import java.util.HashMap;
import java.util.Map;

public class SubString {
    public int lengthOfLongestSubstring(String s) {
    	/* ����1 */
//        char[] c = s.toCharArray();
//        Map<Character, Integer> m = new HashMap<>();
//        int num1 = 0;
//        Integer num2 = 0;
//        int n1 = 0;
//        int n2 = 0;
//        for(int i = 0; i < c.length; i++){      	
//            num2 = m.get(c[i]); 
//            m.put(c[i],i);
//            n1++;
//            if(num2!=null && num2>=num1){
//            	num1 = num2;
//            	n1--;
//	            if(c[num2]==c[i] && n2 < n1){
//	                n2 = n1;
//	                n1 = i - num2;
//	            }else {
//	            	n1 = i - num2;
//	            }
//            }else if((i<=c.length-1) && n2 > n1){
//            	
//            }else{
//            	n2 = n1;
//            }
//        }
//        return n2;
    	
    	/* ����2 */
    	int max = 0;
    	int i = 0;
    	int j = 0;
    	int index = 0;
    	int[] temp = new int[128];
    	while(i<s.length()){
    		if(temp[s.charAt(i)]==0){
    			temp[s.charAt(i)]=i+1;//�洢��û�г��ֵ���ĸ��λ�ã����߱����֮�����ĸ�ĵ�ǰλ��
    			i++;
    			if(max<(i-j)){
    				max = i-j;
    			}
    		}else{
	    		index = temp[s.charAt(i)];	   
	    		temp[s.charAt(i)] = 0;//���֮����ڴ洢��һ���ظ�����ĸ�ĵ�ǰ����
    			if(j<index){
    				j=index;
    			}
    		}
    	}
    	return max;
    }
    
    public static void main(String[] args) {
		String s = "eee"; //"tmmzuxt";//"uqinntq"; //"vqblqcb";  //"abcabcd"; //"a";
		SubString ss = new SubString();
		System.out.println("length: " + ss.lengthOfLongestSubstring(s));
	}
}