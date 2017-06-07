package cn.wjs.javase.newcharacter;

public class VariableParam {
	public static void main(String[] args) {
		System.out.println(add(new int[] {}));
		System.out.println(add(new int[] { 1, 2, 3 }));
		System.out.println(add(1, 2, 3));
		System.out.println(add(1, 2, 3, 6, 7, 8));

	}

	public static int add(int... data) {// 可变参数
		int sum = 0;
		for (int x = 0; x < data.length; x++) {
			sum += data[x];
		}
		return sum;
	}

}
