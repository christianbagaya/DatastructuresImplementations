package singlyLinkedList;

public class SinglyLinkedList<E> {
	private int size;
	Node<E> header ;
	Node<E> trailer;
	
	public SinglyLinkedList() {
		// TODO Auto-generated constructor stub
		
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.setNext(trailer);
	}
	
	public int getSize() {
		return this.size;
	}
	public E Elast() {
		Node<E> element = this.trailer.getPrevious();
		return(element.getElement());
	}
	
	public E Efirst() {
		Node<E> element = this.header.getNext();
		return(element.getElement());
	}
	
	public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newNode = new Node<E> (e, predecessor, successor);
		newNode.setElement(e);
		newNode.setNext(successor);
		newNode.setPrevious(predecessor);		
	}
	
	public Node<E> removeBetween(Node<E> element) {
		Node<E> predecessor = element.getPrevious();
		Node<E> successor = element.getNext();
		
		predecessor.setNext(successor);
		successor.setPrevious(predecessor);
		size--;
		return element;
	}
	
	public Node <E> removeFirst(){
		Node<E> element = this.header.getNext();
		Node<E> successor = element.getNext();
		if(element.getElement()!=null) {
			header.setNext(successor);
			successor.setPrevious(header);
			return element;
		}
		else {
			return null;
		}
	}
	
	public Node<E> removeLast(){
		Node<E> element = this.trailer.getPrevious();
		Node<E> successor = element.getPrevious();
		if(element.getElement()!=null) {
			trailer.setPrevious(successor);
			successor.setNext(header);
			return element;
		}
		else {
			return null;
		}
				
	}
	public void addFirst(Node<E> e) {
		Node<E> successor = this.header.getNext();
		e.setNext(successor);
		e.setPrevious(header);
	}
	
	public void addLast(Node<E> e) {
		Node<E> predecessor = this.trailer.getPrevious();
		e.setNext(this.trailer);
		e.setPrevious(predecessor);
	}

	public static void main(String[] args) {
		// EODO Auto-generated method stub
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		Node<Integer> node = new Node<Integer>(null,null,null);
		list.addFirst(node);
		System.out.println(node.toString());
	}
}
