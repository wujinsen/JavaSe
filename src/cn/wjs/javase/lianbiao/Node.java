/**
 * 吴锦森   下午11:33:38
 */
package cn.wjs.javase.lianbiao;


/**
 * @author 吴锦森
 * @date 2015年12月6日
 */
public class Node {
	
	private String data;	//假设要保存的数据类型是字符串
	private Node next;		//保存下一个节点引用
	
	public Node(String data){//构造方法存放数据
		this.data = data;
	}
	public void addNode(Node newNode){//保存的是节点关系
		if(this.next == null){		//当前节点为null
			this.next = newNode;	//保存新节点
		}
	}
	public void printNode(){
		System.out.println(this.data);
		if(this.next != null){	//还有下一个节点
			this.next.printNode();//继续输出
		}
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
