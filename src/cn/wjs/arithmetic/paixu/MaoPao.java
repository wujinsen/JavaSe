package cn.wjs.arithmetic.paixu;

/**
 * @author 吴锦森
 * @date 2016年2月23日
 *  比较相邻的元素。如果第一个比第二个大，就交换他们两个。
          对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
          针对所有的元素重复以上的步骤，除了最后一个。
          持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class MaoPao {
	public static void main(String[] args) {
		int arr[] = new int[] {6, 2, 4, 5, 1, 9, 10, 7,55,33};
		print(arr);
		int arr2[] = new int[] { 200, 30, 15, 6, 10 };
		sort(arr);
		print(arr);
		//System.out.println();
		//sort2(arr2);
		//print(arr2);

	}

	public static void sort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		}
	}

	public static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	public static void sort2(int arr[]) {// 另一种冒泡排序方式

		for (int i = 0; i < arr.length; i++) {
			for (int y = 0; y < arr.length - 1; y++) {
				if (arr[y] > arr[y + 1]) {
					int temp = arr[y];
					arr[y] = arr[y + 1];
					arr[y + 1] = temp;
				}
			}
		}

	}
}
