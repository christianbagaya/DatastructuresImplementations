package singlyLinkedList;

public class Node<E> {
	private Node<E> next;
	private Node<E> previous;
	private E element;
	
	
	public Node (E e, Node<E> next, Node<E> previous){
		this.element = e;
		this.next = next;
		this.previous = previous;
	}
		
	
	public Node<E> getNext() {
		return this.next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	public Node<E> getPrevious() {
		return this.previous;
	}
	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}
	public E getElement() {
		return this.element;
	}
	public void setElement(E element) {
		this.element = element;
	}
	
	@Override
	public String toString() {
		return "Node [next=" +next+ ", previous=" + previous + ", element=" + element + "]";
	}

//	@Override
//	public String toString() {
//		return "["+getPrevious()+"] ["+getElement()+"] "+ getNext();
////				"["+this.getPrevious() +this.getElement()+" "+this.getNext()+"]";		
//	}
//	
}
