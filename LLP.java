//import sun.security.action.GetBooleanAction;

public class LLP<T> {
	private int length;
	private Node<T> head;
	
	
	
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T info){
			this.data = info;
			this.next = null;
		}
		
		public Node (T info, Node<T> next){
			this.data = info;
			this.next = next;
		}
		
		public T getData(){
			return this.data;
		}
		
		public void setData(T info){
			this.data = info;
		}
		
		public Node<T> getNext(){
			return this.next;
		}
		
		public void setNext(Node<T> node){
			this.next = node; 
		}
		
	}

	
	// Constructor
	public LLP(){
		// This list is empty, so set reference to head
		// node to a new node with no data
		length = 0;
		head = null;
	}
	
	public int getLength(){
		return length;
	}
	
	
	// Appends the specified element to the end of this list
	public void add(T data){
		
		if (head == null){
			head = new Node<T>(data);
			length++;
			return;
		}
		Node<T> temp = new Node<T>(data);
		Node<T> current =  head;
		
		//while starting at the head node, crawl to the end of the list
		while (current.getNext() != null){
			Node<T> next = current.getNext();
			current = next;
		}
		// the last node's "next" reference is set to the new node
		current.setNext(temp);
		length++; // increment number of elements in the list
	}
	public boolean isEmpty(){
		return head ==null;
	}
	// Removes element from head of the list
	public T remove(){
		if (isEmpty()) {
			return null;
		}
		else{
			T element = head.getData();
			head = head.getNext();
			return element;
		}
	}
	
	public void insert(T data){
		// This will insert at the end of the list
		insertNth(length, data);
	}
	
	// This method assumes 1-indexing. That is, the first element
	// in the linked list is in index position 1.
	public void insertNth(int index, T data){
		Node<T> newNode = new Node<T>(data);
		Node<T> current = head;
		// There are two cases to consider: when the list is empty and when 
		// the index exceeds the length of the list or is less than 1
		if (isEmpty()){
			head = newNode;
			return;
		}
		if ((index<=0) || (index >length)){
			System.out.println("Should throw an exception here: trying to insert beyond end of list; instead just add to end of list");
			return;
		}
		// traverse the list and stop at the index 
		// just before the index where new node should be inserted
		for (int i=1; i<index-1; i++){
			current = (Node<T>) current.getNext();
		}
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		

	}

	// This will ensure our list will be printed out fabulously!
	public String toString() {
		String output = "";
 
		if (head != null) {
			Node<T> current = head;
			while (current != null) {
				output += "[" + current.getData().toString() + "]";
				current = current.getNext();
			}
 
		}
		return output;
    }

    public static LLP buildonetwothree()
    {
        LLP onetwothree = new LLP<Integer>();
        onetwothree.add(1);
        onetwothree.add(2);
        onetwothree.add(3);
        return onetwothree;
    }
    public int countTime(int myint)
    {
        Node<Integer> myNum = new Node<Integer>(myint);
        if (head == null)
        {
            return 0;
        }
        int count = 0;
    
        while (head != null)
        {
            if (head.getData() == myNum)
            {
                count++;
            }
            head = head.getNext();
        }
        return count;

    }
    public static void main(String[] args)
    {
        System.out.println(buildonetwothree());
        System.out.println(buildonetwothree().countTime(1));
    }


}