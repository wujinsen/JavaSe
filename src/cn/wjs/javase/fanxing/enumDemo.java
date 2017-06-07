package cn.wjs.javase.fanxing;

/**
 * 枚举
 * @author 吴锦森
 * @date 2015年12月20日
 */
public class enumDemo {
	public static void main(String[] args) {
		Color c = Color.RED;
		System.out.println(c);
		for(Color c1 : Color.values()){//循环输出所有枚举数据
			System.out.println(c1.ordinal() + "," + c1.name());
		}
		switch (c) {
		case RED:
			System.out.println("红色");
			break;
		case BULE:
			System.out.println("蓝色");
			break;
			
		case GREE:
			System.out.println("绿色");
			break;
		default:
			break;
		}
		
	}
}
/**
 * 使用enum关键字定义枚举类型,enum定义的类都继承了Enum父类
 * @author aa
 *
 */
enum Color{
	RED, BULE,GREE;	//实例化对象
}

