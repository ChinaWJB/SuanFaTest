package niuke;

/**
 * ��Ŀ

    ������һ�鳤���ε����أ�����������ǿ��Կ�������n��С�������Ӷ��ɵ�(��ЩС�������ǿ��Խ�֮���Ϊ1��n)��
    ��������Ҫ���仮�ֳ��������֣��ֱ����ϲ�ͬ������(������A��B)�����ֱ�����ĳ����С����֮����У����������ص�����˻����Ҷˣ�
    �������ڵ�i�鵽��i+1�����У��򻮷ֺ󣬵�1����i�����A��ʣ�µĵ���B��
    ������һЩר�Ҷ����ؽ����˼�⣬����ÿ����������ÿ�������ʺ��ֵ����
    �����ҵ�һ�����ʵĻ��֣�ʹ����������ר�ҵ��������Ǻϣ�Ҳ����˵���㻮�ֵ�A��ר������ΪB�Ĵ������㻮�ֵ�B��ר������ΪA�Ĵ���֮����С��

��������:

    ÿ�����ݸ���һ��ר��������land(����0Ϊ����A��1Ϊ����B)���Լ�С������n(1��n��300)��ר����������m(1��m��300)

�������:

    �뷵����Ļ���,��i��i+1����������ˣ������0��1�������Ҷ������n,n+1�����ж��������Ļ��֡�

��������:

    [[1,1,1,1],[0,0,0,0],[1,0,1,1]],4,3

�������:

    [0,1]

 * @author wjb
 *
 */
public class GetPartition {
	@SuppressWarnings("null")
	public static int[] getPartition(int[][] land, int n, int m){
		int count = 0;
		int max = 0;
		int[] index = new int[2];
		for(int i=0; i<=n; i++){
			count = 0;
			for(int k=0; k<m; k++){
				for(int j=0; j<i; j++){
					//�������
					if(land[k][j] == 0 ){
						count++;
					}

				}
				for(int j=i; j<n; j++){
					//�ұ�����
					if(land[k][j] == 1 ){
						count++;
					}
				}
			}
			if(max<count){
				max = count;
				index[0] = i;
				index[1] = i+1;
			}
		}	
		return index;

	}
	public static void main(String[] args) {
//		int[][] land = {{0,0,0,0},{1,1,1,1},{1,0,1,1}};
		int[][] land = {{0,0,0,0},{1,1,1,1},{1,0,0,1}};
		int[] temp = getPartition(land, 4, 3);
		for(int i=0; i<temp.length; i++){
			System.out.println(temp[i]);
		}
//		System.out.println(land.length);
	}
}
