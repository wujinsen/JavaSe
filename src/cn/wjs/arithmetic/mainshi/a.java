package cn.wjs.arithmetic.mainshi;

/**
 * @author 吴锦森
 * @date 2016年6月8日
 */
public class a {
	public static void main(String[] args) {
		  int i,n,k=0;
		     for (n = 3; n<=100; n++) {     //3~100的所有数
		         i=2;
		         while (i<n) {
		             if (n%i==0)  break;  //若能整除说明n不是素数，跳出当前循环
		             i++;
		          }
		        System.out.print(n + ",");
		         
//		      if (i==n) {     //如果i==n则说明n不能被2~n-1整除，是素数
//		             k++;             //统计输出数的个数
//		             System.out.print(i+ "\t ");
//		             if (k %6==0)    //每输出5个则换行
//		              System.out.println();
//		         }
		     }
		 }
}
