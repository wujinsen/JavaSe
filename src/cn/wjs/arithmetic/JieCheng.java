package cn.wjs.arithmetic;

/**
 * @author 吴锦森
 * @date 2016年2月23日
 */
public class JieCheng {
	public static void main(String[] args) {
		int temp = 3;
		int sum = 1;
		for(int i=1;i<=temp;i++){
			 sum = sum * i;
		}
		System.out.println(temp+"的阶乘是:"+sum);
	}
}
