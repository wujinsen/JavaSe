package cn.wjs.arithmetic.mainshi;

/**
 * @author 吴锦森
 * @date 2016年6月8日
 */
public class ShuSu {
	public static void main(String[] args) {
        //程序打印出从100到200的所有素数并求和； 
        int Sum = 0;
        
        for (int i = 1; i < 201; i++) {
            boolean flag = true;
            /*内嵌了一个for循环，作用是用100到200之间的每一个数，从2一直除到它本身，如果等于0的话，那么就不属于素数，就把flag置为false*/ 
            for (int j = 2; j <= i - 1; j++) {
                if (i % j == 0)	//能整除说明不是素数
                    flag = false;
            }
            if (flag) {//只有当flag为true的时候，才会这里走。
                Sum = Sum + i;//每一次循环都让sum加上这个素数i，然后重新赋值给sum
                System.out.print(i+",");
            }
        }
        System.out.println("所有素数总和为："+Sum);
    }
}
