package cn.wjs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public Test() {
		System.out.println("parent");
	}

	static {
		System.out.println("static parent");
	}

	public static void main(String[] args) {

		Test test = new Test();
		System.out.println(test);
		// JSONObject allData = new JSONObject();
		// JSONArray array = new JSONArray();
		// JSONObject temp = new JSONObject();
		// temp.put("deptid", "1");
		// temp.put("title", "zhangsan");
		// array.add(temp);
		// allData.put("allDepts", array);
		// System.out.println(allData);
		String[] array = new String[] { "1", "2", "3" };
		for (int i = 0; i < array.length; i++) {
			System.out.println(i);
			System.out.println(array[2]);
		}
		List<P> pList = new ArrayList<P>();
		Map outMap = new HashMap();
		outMap.put("ret", "ok");
		outMap.put("ret2", "ok");
		P p = new P();
		p.setA(1);
		p.setName("zhangsan");
		p.setName("zhangsan2");
		p.setOutMap(outMap);
		pList.add(p);
		System.out.println(pList.get(0).getName());
		System.out.println(pList.get(0).getOutMap().get("ret3"));
		// Iterator iter = pList.iterator();
		// while(iter.hasNext()){
		// System.out.println(iter.next());
		// }
		List list = new ArrayList();
		list.add("aa");
		list.add("aa");
		System.out.println(list);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		System.out.println(sdf.format(new Date()) + "0000");
		System.out.println(sdf.format(getDayBegin()));
		System.out.println(sdf.format(getBeginDayOfTomorrow()));
	}

	public static Date getBeginDayOfTomorrow() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayBegin());
		cal.add(Calendar.DAY_OF_MONTH, 1);

		return cal.getTime();
	}

	// 获取当天的开始时间
	public static java.util.Date getDayBegin() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}

class P {
	String name;
	int a;
	private Map<String, String> inMap; // 前台给后台传的对象

	private Map<String, Object> outMap;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Map<String, String> getInMap() {
		return inMap;
	}

	public void setInMap(Map<String, String> inMap) {
		this.inMap = inMap;
	}

	public Map<String, Object> getOutMap() {
		return outMap;
	}

	public void setOutMap(Map<String, Object> outMap) {
		this.outMap = outMap;
	}

}
