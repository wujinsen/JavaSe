package cn.wjs.arithmetic;

/**
 * @author 吴锦森
 * @date 2016年2月23日
 */
public class Snake2 {
	public static void main(String[] args) {
		/**
		 * 2、计算并输出nXn的蛇形矩阵。(n>0) 例如4X4的蛇形矩阵如下： 1 3 4 10 2 5 9 11 6 8 12 15 7 13 14 16
		 */
		// DOWN UPRIGHT RIGHT LEFTDOWN
		int n = 5;
		int[][] data = new int[5][5];
		int dire; // 当前数字的移动方向
		final int UPRIGHT = 0; // 上右
		final int DOWN = 1; // 下
		final int LEFTDOWN = 2; // 左下
		final int RIGHT = 3;// 右
		dire = DOWN;
		int value = 1; // 数组元素的值
		int row = 0; // 第一维下标
		int col = 0; // 第二维下标
		data[0][0] = 1; // 初始化第一个元素
		data[n - 1][n - 1] = n * n;
		while (value < n * n - 1) {
			System.out.print("(" + dire + ")");
			switch (dire) {
			case DOWN:// DOWN -UPRIGHT +RIGHT -LEFTDOWN
				row++; // 移动到下一行
				if (row >= n) { // 超过边界
					row--; // 后退
					dire = RIGHT;
					continue; // 跳过该次循环
				} else {
					value++; // 数值增加1
					data[row][col] = value;// 赋值
					if (col == 0) {
						dire = UPRIGHT;
					} else if (col == n - 1) {
						dire = LEFTDOWN;
					}
				}
				break;
			case UPRIGHT:// +DOWN -UPRIGHT +RIGHT LEFTDOWN
				row--;
				col++; // 移动到上一行，右一列
				if (col >= n)// 超过边界
				{
					row++;
					col--; // 后退
					dire = DOWN;
					continue; // 跳过该次循环
				} else if (row < 0) { // 超过边界
					row++;
					col--; // 后退
					dire = RIGHT;
					continue; // 跳过该次循环
				} else {
					value++; // 数值增加1
					data[row][col] = value;// 赋值
					dire = UPRIGHT;
				}
				break;
			case RIGHT:// +DOWN -UPRIGHT RIGHT -LEFTDOWN
				col++; // 移动到右一列
				if (col >= n) {
					col--; // 后退
					dire = DOWN;
					continue; // 跳过该次循环
				} else {
					value++; // 数值增加1
					data[row][col] = value;// 赋值
					if (row == 0) {
						dire = LEFTDOWN;
					} else if (row == n - 1) {
						dire = UPRIGHT;
					}
				}
				break;
			case LEFTDOWN:// +DOWN UPRIGHT +RIGHT -LEFTDOWN
				row++;
				col--; // 移动到下一行，左一列
				if (row >= n) { // 超过边界
					row--;
					col++; // 后退
					dire = RIGHT;
					continue; // 跳过该次循环
				} else if (col < 0)// 超过边界
				{
					row--;
					col++; // 后退
					dire = DOWN;
					continue; // 跳过该次循环
				} else {
					value++; // 数值增加1
					data[row][col] = value;// 赋值
					dire = LEFTDOWN;
				}
				break;
			}
		}
		System.out.println();
		// 输出数组中的元素
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] < 10) {// 右对齐
					System.out.print(' ');
				}
				System.out.print(data[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
