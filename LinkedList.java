package Linked_List;

import JUNE7.remove_duplicates;

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int size() {
		return this.size;
	}

	public boolean isempty() {
		return this.size == 0;
	}

	public void display() {
		Node temp = this.head;
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		while (temp != null) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception(" Linked List is empty");
		}

		return this.tail.data;
	}

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception(" Linked List is empty");
		}

		return this.head.data;
	}

	public int getAt(int index) throws Exception {
		// todo
		if (index < 0 || index > size - 1) {
			throw new Exception(" index out of bound ");
		}
		Node temp = this.head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public Node getNodeAt(int index) throws Exception {

		if (index < 0 || index > size - 1) {
			throw new Exception(" index out of bound ");
		}
		Node temp = this.head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void addLast(int data) {
		Node nn = new Node();

		nn.data = data;
		if (this.size == 0) {
			this.tail = nn;
			this.head = nn;
			this.size++;
		} else {
			this.tail.next = nn;
			size++;
			this.tail = nn;
		}
	}

	public void addFirst(int data) {
		Node nn = new Node();
		nn.data = data;

		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			size++;
		} else {
			nn.next = this.head;
			this.head = nn;
			size++;
		}

	}

	public void addAt(int data, int index) throws Exception {
		if (index < 0 || index > size)
			throw new Exception(" index out of bound");
		Node nn = new Node();
		nn.data = data;
		if (index == 0) {
			addFirst(data);
		} else if (index == size) {
			addLast(data);
		} else {
			Node nm1 = getNodeAt(index - 1);
			Node np1 = getNodeAt(index);
			nn.next = np1;
			nm1.next = nn;
			size++;
		}
	}

	public int deleteFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception(" Linked list empty");
		}
		int rv = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		size--;
		return rv;
	}

	public int deleteLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked list empty");
		}
		int temp = 0;
		if (this.size == 1) {
			temp = this.head.data;
			this.head = null;
			this.tail = null;
		} else {
			Node nm1 = getNodeAt(size - 2);
			nm1.next = null;
			temp = this.tail.data;
			this.tail = nm1;
		}
		return temp;
	}

	public int deleteAt(int index) throws Exception {
		if (index < 0 || index > size - 1) {
			throw new Exception(" index out of bound");
		}
		int temp = 0;
		if (index == 0) {
			return deleteFirst();
		} else if (index == size - 1) {
			return deleteLast();
		} else {
			Node nm1 = getNodeAt(index - 1);
			Node nn = nm1.next;
			Node np1 = nn.next;
			nm1.next = np1;
			temp = nn.data;

			this.size--;
			return temp;
		}
	}

	public void ReverseDataIterative() throws Exception {
		Node left = this.head;
		Node right = getNodeAt(this.size - 1);
		for (int i = 0; i <= size / 2; i++) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			left = left.next;
			right = getNodeAt(this.size - i - 2);
		}
	}

	public void ReversePointerIterative() {
		// Node temp = head;
		// Node swap = temp;
		// Node temp1 = temp.next;
		// while (temp.next != null) {
		// swap = temp;
		// temp = temp1;
		// if (temp == null) {
		// break;
		// }
		// temp1 = temp.next;
		// temp.next = swap;
		// }
		// tail = head;
		// head = swap;
		// tail.next = null;
		Node left = this.head;
		Node right = this.head.next;
		while (left.next != null && left != null) {
			
			if(right.next==null) {
				right.next=left;
				break;
			} else {
			
				Node temp = right.next;
				right.next = left;
				left = right;
				right = temp;
			}
		}
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;

	}

	public void ReversePointerRecurse() {
		ReversePointerRecurse(this.head, this.head.next);
	}

	private void ReversePointerRecurse(Node prev, Node curr) {

//		if (curr == null) {
//
//			Node swap = head;
//			head = tail;
//			tail = swap;
//			tail.next = null;
//		}
//		Node next = curr.next;
//
//		curr.next = prev;
//		ReversePointerRecurse(curr, next);
		if(curr==null) {
			Node swap=this.head;
			this.head=this.tail;
			this.tail=swap;
			this.tail.next=null;
			
			return;
		}
		Node temp=curr.next;
		curr.next=prev;
		ReversePointerRecurse(curr,temp);
		

	}

	public void RevDataRec() {
		RevDataRec(head, head, 0);
	}

	private Node RevDataRec(Node left, Node right, int floor) {
//		if (right == null) {
//			return left;
//		}
//		left = RevDataRec(left, right.next, floor + 1);
//		if (floor > size / 2) {
//			int temp = left.data;
//			left.data = right.data;
//			right.data = temp;
//		}
//
//		return left.next;
		if(right==null) {
			return left;
		}
		left=RevDataRec(left, right.next, floor+1);
		if(floor>size/2) {
			int temp=left.data;
			left.data=right.data;
			right.data=temp;
		
		}
		return left.next;

	}

	private class HeapMover {
		Node node;
	}

	public void RevDataHeapMoverRev() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		RevDataHeapMoverRev(left, this.head, 0);
	}

	private void RevDataHeapMoverRev(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		RevDataHeapMoverRev(left, right.next, floor + 1);
		if (floor > size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
		}
		left.node = left.node.next;

	}

	public void fold() {
		HeapMover left = new HeapMover();
		left.node = this.head;

		fold(left, this.head, 0);

	}

	private void fold(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}

		fold(left, right.next, floor + 1);
		if (size % 2 != 0 && floor == size / 2) {//// odd case;
			this.tail = left.node;
			left.node.next = null;
			return;
		} else if (size % 2 == 0 && floor == size / 2) {/////// even case;
			left.node.next = right;
			right.next = null;
			this.tail = right;
			return;
		} else if (floor > size / 2) {
			Node temp = left.node.next;
			left.node.next = right;
			right.next = temp;
			left.node = right.next;

		}
	}

	public int mid() {
		return this.midnode().data;
	}

	private Node midnode() {
		Node slow = this.head;
		Node fast = this.head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public int kth_element_fromStart(int k) {
		Node slow = this.head;
		Node fast = this.head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.data;

	}

	public void remove_duplicates() {
		Node temp = this.head;
		while (temp.next != null) {
			if (temp.data == temp.next.data) {
				temp.next = temp.next.next;
				this.size--;
			} else {
				temp = temp.next;
			}
			this.tail = temp;
			temp.next = null;
		}
	}

	public void k_Reverse(int k) throws Exception {
		Node temp = this.head;
		while (temp != null) {
			for (int i = 0; i < k; i++) {
				Node temp1 = temp.next;
				temp1.next = temp;
				temp = temp1;
			}
			temp = temp.next;
		}
	}

	public LinkedList MergeTwoSortedLL(LinkedList other) {
		Node ttemp = this.head;
		Node otemp = other.head;
		LinkedList rv = new LinkedList();

		while (ttemp != null && otemp != null) {
			if (ttemp.data > otemp.data) {
				rv.addLast(otemp.data);
				otemp = otemp.next;
			} else {
				rv.addLast(ttemp.data);
				ttemp = ttemp.next;
			}
		}

		if (ttemp == null) {
			rv.addLast(otemp.data);
			otemp = otemp.next;
		} else if (otemp == null) {
			rv.addLast(ttemp.data);
			ttemp = ttemp.next;

		}
		return rv;
	}

	public void MergeSort() {

		LinkedList fh = new LinkedList();

		fh.head = this.head;
		fh.tail = this.midnode();
		fh.tail = null;
		fh.size = (this.size + 1) / 2;

		LinkedList sh = new LinkedList();

		sh.head = this.midnode().next;
		sh.tail = this.tail;
		sh.size = this.size - fh.size;

		fh.MergeSort();
		sh.MergeSort();

		LinkedList LL = fh.MergeTwoSortedLL(sh);
		this.head = LL.head;
		this.tail = LL.tail;
		this.tail.next = null;

	}
}
