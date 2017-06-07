package cn.wjs.javase.fanxing;


/**
 * 可变参数 
 * @author aa
 *
 */
public class ChangeParameter {
	public static void main(String[] args) {
		System.out.println(add(new int[]{1, 2, 3}));
		System.out.println(add(1, 2, 3));
		System.out.println(add());
	}
	/**
	 * public [static][final] 返回值类型 方法名称(参数类型 ... 变量)
	 * @return
	 */
	public static int add(int ... data){
		int sum = 0;
		for(int i = 0;i < data.length;i++){
			sum += data[i];
		}
		return sum;
	}
}
