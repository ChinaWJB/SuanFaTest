package niuke;

/**
 * 题目

    现在有一块长条形的土地，这个土地我们可以看成是由n块小方格连接而成的(这些小方格我们可以将之编号为1到n)。
    而我们需要将其划分成两个部分，分别种上不同的作物(即作物A和B)，划分必须在某两个小方格之间进行，或者在土地的最左端或最右端，
    若划分在第i块到第i+1块间进行，则划分后，第1至第i块地种A，剩下的地种B。
    现在有一些专家对土地进行了检测，他们每个人评估了每块土地适合种的作物。
    请你找到一个合适的划分，使得其与所有专家的评估最吻合，也就是说，你划分到A而专家评估为B的次数和你划分到B而专家评估为A的次数之和最小。

输入描述:

    每组数据给定一个专家评估表land(其中0为评估A，1为评估B)，以及小块数量n(1≤n≤300)，专家评估次数m(1≤m≤300)

输出描述:

    请返回你的划分,即i和i+1。若在最左端，则输出0，1；在最右端则输出n,n+1。若有多解输出最靠左的划分。

输入例子:

    [[1,1,1,1],[0,0,0,0],[1,0,1,1]],4,3

输出例子:

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
					//左边评估
					if(land[k][j] == 0 ){
						count++;
					}

				}
				for(int j=i; j<n; j++){
					//右边评估
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
