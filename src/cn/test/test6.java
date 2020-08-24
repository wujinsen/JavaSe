package cn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class test6 {
    public static void main(String[] args) {
        List<AA> list = new ArrayList();
        AA aa = new AA();
        aa.setAge(1);
        list.add(aa);
        list = list.stream().map(x -> {
            aa.setAge(2);
            return x;
        }).collect(Collectors.toList());
        System.out.println(list);
    }
}
class AA{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AA{" +
                "age=" + age +
                '}';
    }
}
