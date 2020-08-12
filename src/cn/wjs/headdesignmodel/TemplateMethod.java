package cn.wjs.headdesignmodel;

/**
 * 模板类提供模板方法，不同子类实现模板类，子类可以具体实现自己的方法，不同子类有共同的父类方法
 */
public class TemplateMethod {
    public static void main(String[] args) {
        AbstractClass tm = new ConcreteClass();
        tm.TemplateMethod();
        AbstractClass tm2 = new ConcreteClass2();
        tm2.TemplateMethod();
    }

}

//抽象类
abstract class AbstractClass {
    public void TemplateMethod(){ //模板方法

        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    public void SpecificMethod() {//具体方法
        System.out.println("抽象类中的具体方法被调用...");
    }

    public abstract void abstractMethod1(); //抽象方法1

    public abstract void abstractMethod2(); //抽象方法2
}

//具体子类
class ConcreteClass extends AbstractClass {
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}

//具体子类
class ConcreteClass2 extends AbstractClass {
    public void abstractMethod1() {
        System.out.println("ConcreteClass2 抽象方法1的实现被调用...");
    }

    public void abstractMethod2() {
        System.out.println("ConcreteClass2 抽象方法2的实现被调用...");
    }
}
