package cn.wjs.javase;

import java.util.HashMap;
import java.util.Map;



/**
 * @author 吴锦森
 * @date 2016年6月10日
 */
public class OutOfMemoryErrorDemo {
	public static void main(String[] args) {
		Map<Key, String> map = new HashMap<Key, String>(1000);
		int counter = 0;
		while(true){
			map.put(new Key("aaa"), "value");
			counter++;
			if(counter % 1000 == 0){
				System.out.println("map size:" + map.size());
				System.out.println("Free memory after count " + counter + "is" +  getFreeMemory() + "MB");
			}
		}
	}
	 // inner class key without hashcode() or equals() -- bad implementation
	 static class Key {
	  private String key;

	  public Key(String key) {
	   this.key = key;
	  }
//	  public boolean equals(Object obj){
//		  if(obj instanceof Key){
//			  return key.equals(((Key)obj).key);
//		  }
//		  else  return false;
//	  }
//	  public int hashCode(){
//		  return key.hashCode();
//	  }
	 }
	//delay for a given period in milli seconds
	 public static void sleep(long sleepFor) {
	  try {
	   Thread.sleep(sleepFor);
	  } catch (InterruptedException e) {
	   e.printStackTrace();
	  }
	 }
	 //get available memory in MB
	 public static long getFreeMemory() {
	  return Runtime.getRuntime().freeMemory() / (1024 * 1024);
	 }
}