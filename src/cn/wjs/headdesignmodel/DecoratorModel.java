package cn.wjs.headdesignmodel;

public class DecoratorModel {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + ", " + beverage.cost());
        Beverage beverage2 = new  DarkRoast();
        beverage2 = new Mocha(beverage2);//Mocha装饰DarkRoast
        beverage2 = new Soy((beverage2));//Soy装饰DarkRoast
        System.out.println(beverage2.getDescription() + ", " + beverage2.cost());

    }
}

/**
 * 饮料
 */
abstract class Beverage {
    String description = "Unkown Beverage";

    String getDescription() {
        return description;
    }

    abstract double cost();
}

/**
 * 饮料装饰类
 */
abstract class CondimentDecorator extends Beverage {

    abstract String getDescription();

}

/**
 * 摩卡咖啡 装饰类
 */
class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    double cost() {
        return beverage.cost() + 1;
    }

}

/**
 * 大豆 装饰类
 */
class Soy extends CondimentDecorator {
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    double cost() {
        return beverage.cost() + 1;
    }

}


/**
 * 浓咖啡 装饰类
 */
class Espresso extends Beverage{
    public Espresso(){
        description = "Espresso";
    }
    @Override
    double cost() {
        return 1;
    }

}
/**
 * 被装饰类
 */
class HousBlend extends Beverage{
    public HousBlend(){
        description = "HousBlend";
    }
    @Override
    double cost() {
        return 2;
    }

}

/**
 * 被装饰类
 */
class DarkRoast extends Beverage{
    public DarkRoast(){
        description = "DarkRoast";
    }
    @Override
    double cost() {
        return 3;
    }

}
/**
 * 被装饰类
 */
class Decat extends Beverage{
    public Decat(){
        description = "Decat";
    }
    @Override
    double cost() {
        return 4;
    }
}

