package cn.wjs.javase.newcharacter;
/**
 * for (数据类型 变量 : 数组或集合) {
 *	// 代码
 *	}
 * @author aa
 *
 */
public class ForeachDemo {
	public static void main(String[] args) {
		int data[] = new int[]{1,2,3,4,5,6,7,8};
		for(int a : data){
			System.out.println(a);
		}
	}
}
