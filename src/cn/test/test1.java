package cn.test;

import java.util.*;
import java.util.stream.Collectors;

public class test1 {
    public static void main(String[] args) {

        // 根据id去重
        List<Person> persons = new ArrayList();
        persons.add(new Person("1",18));
        persons.add(new Person("1",20));
        persons.add(new Person("1",23));
        persons.add(new Person("2",25));
        persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        System.out.println(persons);
        Collections.reverse(persons); // 倒序排列
        System.out.println(persons);
        List<Person> unique = persons.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getId))), ArrayList::new));
        System.out.println(unique);
    }
}

class Person{

    public Person(String id, int age){
        this.id = id;
        this.age = age;
    }

    private String id;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}

