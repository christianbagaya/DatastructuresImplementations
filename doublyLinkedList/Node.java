
public class Node<T> {
	private T element;
	private Node<T> next; 
	private Node<T> previous;
	public Node(T e, Node<T> next, Node<T> previous){
		this.element = e;
		this.next = next;
		this.previous = previous;
	}
}
