package cn.wjs.javase.abstrac;

public abstract class Animal {

    public abstract void eat();

    private String drinkContent;

    private long globalSessionTimeout = 1800000L;

    public void drink(String content){
        drinkContent = content;
    }

    public void hello(String content){
        System.out.println(content);
    }

    public long getGlobalSessionTimeout() {
        return this.globalSessionTimeout;
    }

    public void setGlobalSessionTimeout(long globalSessionTimeout) {
        this.globalSessionTimeout = globalSessionTimeout;
    }
}
