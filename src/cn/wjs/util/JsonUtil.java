package cn.wjs.util;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.wjs.VisitPersonPage;

/**
 * @author 吴锦森 
 * @version 创建时间：2015年5月3日
 * 类说明
 */
public class JsonUtil {
	public static void main(String[] args) {
		VisitPersonPage v = new VisitPersonPage();
		JsonUtil.toJsonArray(v);
		
		JSONObject j = new JSONObject();
		j.put("success", "true");
		
		j.put("user", JsonUtil.toJsonArray(v));
		System.out.println(j.toString());
		System.out.println(j);
	}
	 public static String toJson(Object obj) {  
		 JSONObject jSONObject = JSONObject.fromObject(obj);  
		 return jSONObject.toString();  
	 }  

	 public static String toJsonArray(Object obj) {  
		 JSONArray jSONObject = JSONArray.fromObject(obj);  
		 return jSONObject.toString();  
	 }
}
