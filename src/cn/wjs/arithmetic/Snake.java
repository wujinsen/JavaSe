package cn.wjs.arithmetic;

/**
 * @author 吴锦森
 * @date 2016年2月23日
 */
public class Snake {

	public static void main(String args[]) {
		int number = 18;
		int[][] ary = show(number);
		int length = (int) Math.sqrt(number);
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(ary[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public static int[][] show(int number) {
		int sqrt = (int) Math.sqrt(number);
		sqrt = 5;
		int[][] ary = new int[sqrt][sqrt];
		int start = 1;
		for (int i = 1; i < 2 * sqrt; i++) {
			if (i <= sqrt) {
				System.out.println("i:"+i);
				int startPoint = i - 1;
				for (int j = 0; j < i; j++) {
					if (i % 2 == 1) {	//奇数
						System.out.println("奇数:"+start);
						System.out.println("奇数:j:"+j+",startPoint:"+startPoint);
						ary[j][startPoint--] = start++;
						
					} else {
						System.out.println("偶数:"+start);
						System.out.println("偶数:startPoint:"+startPoint+",j:"+j);
						ary[startPoint--][j] = start++;
					
					}
				}
			}
//			else {
//				int foot = sqrt - 1;
//				int footEnd = i - sqrt;
//				for (int k = 0; k < 2 * sqrt - i; k++) {
//					if (i % 2 == 0) {	//偶数
//						ary[foot--][footEnd++] = start++;
//					} else {
//						ary[footEnd++][foot--] = start++;
//					}
//				}
//			}
		}
		return ary;
	}
}