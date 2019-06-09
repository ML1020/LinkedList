	class Node{
	public int value;//保存节点中的数据
	public Node next=null;//指向下一个结点的引用，特殊值 null
	public Node(int value){
		this.value = value;
	}
}

public class LinkedList{
	public static void display(Node head){
		//如何表里一个链表
		for(Node cur = head;cur != null;cur = cur.next){
			System.out.printf("%d -->",cur.value);
		}
		System.out.println("null");
	}
	
	//头插
	public static Node pushFront(Node head,int value){
		Node newNode = new Node(value);
		newNode.next = head;
		return newNode;
	}
	
	//找到最后一个结点
    public static Node getLast(Node head){
		Node last = head;
		while (last.next != null){
			last = last.next;
		}
			return last;
	}
	
	//尾插
	public static Node pushBack(Node head,int value){
		Node newNode = new Node(value);
		if(head==null){
			newNode.next = head;
			//访问对象的属性
			return newNode;
		}
		else{
			Node last = getLast(head);
			last.next=newNode;
			return head;
		}
	}
	
	//头删
	public static Node popFront(Node head){
		//删除第一个头结点，返回第二个头结点
		if(head==null){
			System.out.printf("您输入的参数不合法%n");
			return null;
		}
		return head.next;
	}
	
	//倒数第二个结点
	public static Node getLastLast(Node head){
		Node cur = head;//遍历
		while(cur.next.next != null){
			cur = cur.next;
		}
		return cur;
	}
	
	//尾删
	public static Node popBack(Node head){
		if(head == null){
			System.out.printf("参数不合法%n");
			return null;
		}
		if(head.next == null){
			return null;
		}
		else{
			Node lastLast = getLastLast(head);
			lastLast.next = null;
			return head;
		}
	}	
	
//静态方法只能调用静态方法
public static void main(String[] args){
	Node head = null;   //表示head指向的链表是空链表
	head = pushBack(head,1);
	head = pushBack(head,2);
	head = pushBack(head,3);
	display(head);  //1-->2-->3-->null
	head = pushFront(head,10);
	head = pushFront(head,20);
	head = pushFront(head,30);
	display(head);  //30-->20-->10-->1-->2-->3-->null
	head = popFront(head);
	head = popFront(head);
	head = popFront(head);
	display(head);  //1-->2-->3-->null
	head = popBack(head);
	head = popBack(head);
	display(head);  //1-->null
	}
}