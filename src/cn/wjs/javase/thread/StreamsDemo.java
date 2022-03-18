package cn.wjs.javase.thread;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(findPrice("88"));
        long duration = System.currentTimeMillis() - start;
        System.out.println("总消耗时间：" + duration + "毫秒");
    }

    public static List<String> findPrice(String product) {
        List<Shop> shops = Arrays.asList(new Shop("sunjin.org"),
                new Shop("加瓦匠"),
                new Shop("京东商城"),
                new Shop("天猫商城"));
        return shops.parallelStream()
                .map(shop -> String.format("%s 的价格是 %s", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

}

class Shop {

    private String name;
    private String price;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public String getPrice(String name) {
        return name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
