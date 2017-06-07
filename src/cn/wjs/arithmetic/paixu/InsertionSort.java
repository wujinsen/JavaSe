package cn.wjs.arithmetic.paixu;

public class InsertionSort {

	public static void main(String[] args) {
	//	int i = 0;
		//System.out.println(--i);
		
		int[] arr = { 5, 2, 4, 6, 1, 3, 3};
		// print(arr);
		System.out.println("---");
		// insertionSort(arr);
		//insertionSort(arr);
		insertSort(arr);
		//insertSort2(arr);
		print(arr);
	}

	public static void insertionSort(int[] arr) {
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			// Insert arr[j] into the sorted sequence arr[1.. j-1]
			int i = j-1;
			while (i >= 0 && arr[i] > key) {
				arr[i+1] = arr[i];
			//	System.out.println("arr[i+1]"+arr[i+1]);
				i--;
			}
			arr[i+1] = key;
		//	System.out.println("key:"+key);
	//	System.out.println("arr[i+1]aaaa:"+arr[i+1]+"  i:"+i);
			
		}
	}

	public static void insertSort(int[] arr) {
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j;
			while (i > 0 && arr[i-1] > key) {//前一个大于后面的
				arr[i] = arr[i-1];
				i--;
			}
			arr[i] = key;
		}
	}

	public static void insertSort2(int[] array) {
		for (int out = 1; out < array.length; out++) {
			int temp = array[out];// 被标记的值或者说是当前需要插入的值
			int in = out;
			// 如果轮循值大于被标记值则往后移
			while (in > 0 && temp < array[in - 1]) {
				array[in] = array[in - 1];
				in--;
			}
			// 将被标记值插入最终移出的空位置
			array[in] = temp;
		}
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.err.print(i + ",");
		}
	}
}
