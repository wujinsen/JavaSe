
package cn.wjs.javase.lianbiao;

/** 链表
 * @author 吴锦森
 * @date 2015年12月6日 处理节点关系
 */
public class Link {
	//将Node类作为内部类
	private class Node {
		
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
		public boolean containsNode(String data){
			if(data.equals(this.data)){//不需要查找了
				return true;
			}else{
				if(this.next != null){
					return this.next.containsNode(data);//递归调用
				}else{	//没有后续节点
					return false;
				}
			}
			
		}
		/**
		 * 
		 * @param previous 上一个节点
		 * @param data 要删除的数据
		 */
		public void removeNode(Node previous, String data){
			if(this.data.equals(data)){
				previous.next = this.next;//空出当前节点
			}else{
				this.next.removeNode(this, data);//向后继续删除
			}
		}
		public void toArrayNode(){
			Link.this.retData[Link.this.foot++] = this.data;//添加到数组
			if(this.next != null){
				this.next.toArrayNode();//递归调用
			}
		}
		
		public String getNode(int index){
			if(Link.this.foot++ == index){//当前索引为查找数据
				return this.data;
			}else{
				return this.next.getNode(index);//继续向下查找
			}
		}
		public void printNode(){
			System.out.println(this.data);
			if(this.next != null){	//还有下一个节点
				this.next.printNode();//继续输出
			}
		}
	
	}
	//-----------内部类结尾
	private Node root; // 根节点
	private int count;//统计数据个数
	private int foot = 0;//操作返回数组的脚标
	private String retData[];//返回数组
	private boolean changeFlag = true;
	public boolean add(String data) {// 保存数据
		if (data == null) {//如果没有数据
			return false;
		}
		Node newNode = new Node(data);
		if(this.root == null){	//没有根节点
			this.root = newNode;//第一个成为根节点
		}else{
			this.root.addNode(newNode);
		}
		this.changeFlag = true;
		return true;
	}
	public boolean addAll(String data[]){
		for(int x=0;x<data.length;x++){
			if(!this.add(data[x])){//如果保存失败
				return false;
			}
		}
		this.count++;
		return true;
	}
	public int size(){		//取得元素个数
		return this.count;
	}
	public boolean isEmpty(){//判断是否空链表
		return this.count==0;//判断链表长度
	}
	/**
	 * 查找数据
	 * @param data
	 * @return
	 */
	public boolean contains(String data){
		//根节点没有数据,查找的也没有数据
		if(this.root==null || data==null){
			return false;
		}
		return this.root.containsNode(data);//交给Node类处理
	}
	//删除
	public void remove(String data){
		if(!this.contains(data)){			//删除的数据不存在,直接返回被调用处
			return;
		}
		if(data.equals(this.root.data)){	//要删除的是根节点
			this.root = this.root.next;//下一个节点成为根节点
		}else{
			this.root.next.removeNode(this.root, data);
		}
		this.count--;
	}
	public String[] toArray(){
		if(this.count == 0){
			return null;
		}
		if(changeFlag == true){
			this.foot = 0;			//脚标初始化
			this.retData = new String[this.count];
			this.root.toArrayNode();//调用Node类操作
			changeFlag = false;	//改变标记，不需要重新获取数据
		}
		return this.retData;
	}
	//获取数据
	public String get(int index){
		if(index > this.count){
			return null;
		}
		this.foot = 0;//定义初始脚标
		return this.root.getNode(index);
	}
	//清空链表
	public void clear(){
		this.root = null;	//清空链表
		this.count = 0;		//元素个数为0
	}
	public void print(){
		if(this.root != null){
			this.root.printNode();
		}
	}
	public static void main(String[] args) {
		Link list = new Link();
		list.add("aaa");	
	}
}
