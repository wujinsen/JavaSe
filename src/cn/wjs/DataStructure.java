package cn.wjs;

public class DataStructure {
	public static void main(String[] args) {
		Node n1 = new Node("火车头");
		Node n2 = new Node("车厢A");
		Node n3 = new Node("车厢B");
		n1.setNext(n2);
		n2.setNext(n3);
		Node currentNode = n1;
		while(currentNode != null){
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}

}

class Node {

	private String data;

	private Node next;
	public Node(String data) {
		this.data = data;
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
