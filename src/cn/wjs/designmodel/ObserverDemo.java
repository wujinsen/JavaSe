package cn.wjs.designmodel;

import java.util.ArrayList;

/**
 * @author 吴锦森
 * @date 2017年6月13日
 * 观察者模式（Observer）
 */
public class ObserverDemo {
	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		Observer1 o1 = new Observer1(wd);
		Observer2 o2 = new Observer2(wd);
		wd.operation("读者");
		
		
	}
}
interface Observer {  
    public void update(String data);  
}
interface Subject {  
    
    /*增加观察者*/  
    public void registerObserver(Observer o);  
      
    /*删除观察者*/  
    public void removeObserver(Observer o);  
      
    /*通知所有的观察者*/  
    public void notifyObserver();  
      
}
class WeatherData implements Subject{
	private String data;
	private ArrayList listObservers;
	public WeatherData(){
		listObservers = new ArrayList();
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		listObservers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = listObservers.indexOf(o);
		if(i>0){
			listObservers.remove(i);
		}
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(int i=0;i<listObservers.size();i++){
			Observer o = (Observer) listObservers.get(i);
			o.update(data);
		}
	}
	
	public void operation(String data){
		this.data = data;
		notifyObserver();
	}
	
}
class Observer1 implements Observer {  
	private String data;
	private Subject s;
	public Observer1(Subject s){
		this.s = s;
		s.registerObserver(this);
		
	}
    @Override  
    public void update(String data) {
    	this.data = data;
        System.out.println("Observer1订阅的杂志："+data);  
    }
    
}  
class Observer2 implements Observer {  
	private String data;
	private Subject s;
	public Observer2(Subject s){
		this.s = s;
		s.registerObserver(this);
	}
    @Override  
    public void update(String data) {
    	this.data = data;
        System.out.println("Observer2订阅的杂志："+data);  
    }
    
}  