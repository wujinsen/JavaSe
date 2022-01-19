package cn.wjs.javase.abstrac;

public class DemoMain {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        cat.setGlobalSessionTimeout(3000l);
        Animal animal = new Cat();
        animal.hello("hello");
        cat.drink("aaa");
        System.out.println(animal.getGlobalSessionTimeout());
        SmallCat smallCat = new SmallCat();
        smallCat.setGlobalSessionTimeout(1000l);
        System.out.println(smallCat.getGlobalSessionTimeout());
    }

}
