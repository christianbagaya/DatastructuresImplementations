import java.util.Arrays;
/**
 * 
 * @author Christian Bagaya
 *
 * @param <T>
 */
public class Stack<T> extends Object{
	private int lengthOfStack=1;
	private int numberOfElements;
	private T [] myStack;
	
	/**
	 * constructor of the stack
	 * @param lengthOfStack which is the initial length of the stack
	 */
	public Stack() {
		@SuppressWarnings("unchecked")
		T[] temporary = (T[])new Object[this.lengthOfStack];
		this.myStack = temporary;
	}
	
	/**
	 * getter of the stack of elements which is an array of type T
	 * @return
	 */
	public T [] getmyStack() {
		return myStack;
	}
	
	/**
	 * returns the length of the stack but not the number of elements inside the stack.	
	 * @return
	 */
	public int getlengthOfStack() {
		return lengthOfStack;
	}
	/**
	 * The push method which adds an object e of type T at the end of the stack
	 * @param e
	 */
	public void push(T e) {
		if(this.numberOfElements == this.lengthOfStack) {			
			@SuppressWarnings("unchecked")
			T[] temporaryArr = (T[])new Object[this.lengthOfStack*2];
			this.lengthOfStack*=2; /** keep track of the length of the stack */
			for(int i=0; i<this.numberOfElements; i++) {
				temporaryArr[i] = this.myStack[i];
			}
			temporaryArr [this.numberOfElements] = e;
			this.myStack = temporaryArr;
		}
		else {
			this.myStack [this.numberOfElements] = e;
		}
		this.numberOfElements++; /** keep track of the number of elements of the stack */
	}
	
	/**
	 * Checks whether the stack is empty or not
	 * @return
	 */
	public Boolean isEmpty() {
		if(this.numberOfElements==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * removes the last element of the stack
	 * @return
	 */
	public T pop() {
		T removedElt = this.myStack[this.numberOfElements-1];
		this.myStack[this.numberOfElements-1] = null;
		this.numberOfElements--;
		return removedElt;
	}
	
	/**
	 * returns the number of elements
	 * @return
	 */
	public int size() {
		return this.numberOfElements;
	}
	/**
	 * return the last element of the stack
	 * @return
	 */
	public T top() {
		if(this.numberOfElements==0) {
			return null;
		}
		return this.myStack[this.numberOfElements-1];
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Stack<T> other = (Stack<T>) obj;
		if (!myStack.equals(other.myStack))
			return false;
		if (lengthOfStack != other.lengthOfStack)
			return false;
		return true;
	}	
	
//	public String ToString() {
//		return "the Stack is [" + this.getmyStack() + " and has a lengthOfStack of " +this.getlengthOfStack()+ "]";
		
	@Override
	public String toString() {
		return " Stack="+ Arrays.toString(this.myStack);		
	}
	
	public static void main(String[] args) {
		Stack <Integer> a= new Stack <Integer> ();
		
		/**
		 * Testing of push(), size(), isEmpty() and pop()
		 */
		for (int i=0; i<10; i++) {
			a.push(1+i);
		}
		
		System.out.println(a.toString());

		System.out.println();
//		System.out.println("the removed element is= "+a.pop().toString());
		
		System.out.println();
		System.out.println(a.toString());
		
		System.out.println();
		System.out.println("Is the stack empty?= "+a.isEmpty());
		System.out.println("fuck"+a.pop());
		System.out.println("The size = "+a.size());
		System.out.println("the last element = "+a.top());
	}	
}