package cn.wjs.designmodel;
/**
 * 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户。
 * 需要设计一个接口，为一系列实现类提供统一的方法，多个实现类实现该接口，设计一个抽象类（可有可无，属于辅助类），提供辅助函数
 * @author aa
 *
 */
public class StrategyDemo {
	public static void main(String[] args) {
		String exp = "2+8";
		ICalculator calculator = new Plus();
		int result = calculator.calculate(exp);
		System.out.println(result);
	}
}
interface ICalculator{
	public int calculate(String exp);
}
abstract class AbstractCalculator{
	public int[] split(String exp, String opt){
		String array[] = exp.split(opt);
		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}
}
class Plus extends AbstractCalculator implements ICalculator{

	@Override
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int arrayInt[] = split(exp, "\\+");
		
		return arrayInt[0] + arrayInt[1];
	}
}
class minus extends AbstractCalculator implements ICalculator{

	@Override
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int arrayInt[] = split(exp, "-");
		
		return arrayInt[0] - arrayInt[1];
	}
}
class Multiply extends AbstractCalculator implements ICalculator{
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int arrayInt[] = split(exp, "\\*");
		
		return arrayInt[0] * arrayInt[1];
	}
}
