package cn.wjs.javase.stream;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsTest {
    public static void main(String[] args) {

        Set<String> set = new HashSet();
        set.add("a");
        set.add("a");
        System.out.println(set);
        List list = new ArrayList(set);
        System.out.println(list);

        List<StudentA> studentList = new ArrayList<>();
        studentList.add(new StudentA(1, "张三", new BigDecimal(18)));
        studentList.add(new StudentA(2, "李四", new BigDecimal(25)));
        studentList.add(new StudentA(1, "王五", new BigDecimal(20)));

        System.out.println(studentList.stream().collect(Collectors.groupingBy(StudentA::getId, Collectors.counting())));
        //两个
        double sum = studentList.stream().mapToInt(StudentA::getId).sum();
        System.out.println(sum);
        System.out.println("---------collectingAndThen两个聚合函数（stream次数多）---------");
        //排序
        List<StudentA> studentsSortName = studentList.stream().sorted(Comparator.comparing(StudentA::getAge)).collect(Collectors.toList());
        System.out.println(studentsSortName);

    }
}

class StudentA {

    private int id;
    private String name;
    private int grade;
    private int glass;
    private BigDecimal age;

    public StudentA(int id, String name, BigDecimal age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGlass() {
        return glass;
    }

    public void setGlass(int glass) {
        this.glass = glass;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", glass=" + glass +
                ", age=" + age +
                '}';
    }
}
