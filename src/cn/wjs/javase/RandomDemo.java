package cn.wjs.javase;

import java.util.Random;

public class RandomDemo {
	public static void main(String[] args) {
		//Random(seed) 指定种子一样的话，输出的随机数也是一样的
		Random r1 = new Random(4);
		Random r2 = new Random(5);
		//for(int i = 0; i < 10; i++){
			System.out.println(r1.nextInt(30));
			System.out.println(r2.nextInt(30));
	//	}
	}
}
