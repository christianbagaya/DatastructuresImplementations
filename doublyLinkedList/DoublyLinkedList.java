
public class DoublyLinkedList<T> {
	
	private static class Node<T> {
		private T element;
		private Node<T> next; 
		private Node<T> previous;
		public Node(T e, Node<T> n, Node<T> p){
			setElement(e);
			next = n;
			previous = p;
		}
		public T getElement() {
			return element;
		}
//		public void setElement(T element) {
//			this.element = element;
//		}
		
		public Node<T> getPrevious(){
			return previous;
		}
		public void setPrevious(Node<T> p) {
			previous = p;
		}
		
		public Node<T> getNext(){
			return next;
		}
		public void setNext(Node<T> n) {
			next =  n;
		}
		
	}
	
	private Node<T> header;
	private Node<T> trailer;
	private int size =0;
	
	public DoublyLinkedList() {
		this.header = new Node<T>(null,null,null) ;
		this.trailer = new Node<T>(null,header,null) ;
		header.setNext(trailer);
	}
	
	public void AddBeginning(Node<T> e) {
		Node<T> successor = header.getNext();
		header.setNext(e);
		e.setNext(successor);
		successor.setPrevious(e);
		e.setPrevious(header);
		size++;
	}
	
	public void AddEnd(Node<T> e) {
		Node<T> pro = trailer.getPrevious();
		e.setNext(trailer);
		e.setPrevious(pro);
		pro.setNext(e);
		size++;
	}
	
//	public void insertNode(Node<T> newNode) {
//		this.header.next = newNode.getElement();
//		
//	}
	
	
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		DoublyLinkedList<Integer> bb = new DoublyLinkedList<Integer>();
//		n = new Node<>();
//		p = new Node<>();
//		
//		Node<Integer> numbers = new Node<Integer>(1,n,p);
		
	}

}
