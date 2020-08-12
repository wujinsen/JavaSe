package cn.wjs.javase.lianbiao;

/**
 * 链表反转
 */
public class NodeReverse {

    public static void main(String[] args) {
        Node head = new Node();
        for (int i = 1; i < 6; i++) {
            Node node = new Node(i);
            head.addNode(node);
        }
        head.printNode();
       // reverseList();
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;//下一个节点
            head.next = pre;//上一个节点
            pre = head;//
            head = next;//循环下一个节点
        }
        return pre;
    }

    static class Node {
        public int value;
        public Node next;

        public Node() {};

        public Node(int data) {
            this.value = data;
        }

        public void addNode(Node newNode) {//保存的是节点关系
            if (this.next == null) {        //当前节点为null
                this.next = newNode;    //保存新节点
            }
        }

        public void printNode() {
            System.out.println(this.value);
            if (this.next != null) {    //还有下一个节点
                this.next.printNode();//继续输出
            }
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

