package cn.wjs.arithmetic.mainshi;

/**
 * @author 吴锦森
 * @date 2016年6月8日
 * 题目:N的阶乘末尾有多少个0 
 * Z = N/5 + N /(5*5) + N/(5*5*5).....知道N/(5的K次方)等于0

公式中 N/5表示不大于N的数中能被5整除的数贡献一个5，N/(5*5)表示不大于N的数中能被25整除的数再共享一个5.......
 */
public class JiehengOfN {
	public static void main(String[] args) {
        int x = 11;
        int count = 0;
 
        while (x>0)
        {
        	System.out.print(count + ",");
              count +=  x / 5;
              x = x / 5;
        }
        System.out.println();
        System.out.println(count);
        System.out.println(fun1(10000));
	}
	public static int fun1(int n){
		int sum = 0;
		int j;
		for(int i=5; i<=n; i+=5){
			j = i;
			while(j % 5 ==0){
				sum++;
				j /= 5;
			}
		}
		return sum;
	}
}
