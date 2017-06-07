package cn;

public class Ttest {
	public static void main(String[] args) {
		
		checkName("a","b","c");
	}

	private static boolean  checkName(String fileName, String name, String op) {  
        switch (op) {   // --->在这里提示我要改用jdk1.7  
        case "no":// 不用检查  
            return true;  
        case "contains":// 是否包含,包含返回true  
            return fileName.contains(name) ? true : false;  
        case "equals": // 是否相等,相等返回true  
            return fileName.equals(name) ? true : false;  
        case "noequal": // 是否不相等,不相等返回true  
            return fileName.equals(name) ? false : true;  
  
        default:  
           // System.out.println("wrong op:{}", op);  
        	System.out.println("hello");
            break;  
        }  
        return false;  
    } 
}
