package cn.wjs.javase.jihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 吴锦森
 * @date 2016年6月7日
 */
public class ArrayListDemo {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		
		int x = 0;
		System.out.println(x);
		
	}
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private int size;
    transient Object[] elementData; //没有private便于内部类访问
    
	public void trimToSize() {
       // modCount++;
        if (size < elementData.length) {
            elementData = (size == 0)
              ? EMPTY_ELEMENTDATA
              : Arrays.copyOf(elementData, size);
        }
    }
}
