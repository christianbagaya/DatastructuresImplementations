package List;

import java.util.Arrays;
public class List<T> extends Object {
	private int lenghtOfList;
	private T[] myList;
	private int size;
	
	public List(int lenghtOfList) {
		this.lenghtOfList = lenghtOfList;
		@SuppressWarnings("unchecked")
		T[] tempArr = (T[]) new Object[this.lenghtOfList];
		this.myList = tempArr;
	}
	
	public void setLenghtOfList(int lenghtOfList) {
		this.lenghtOfList = lenghtOfList;
	}
	public int getLenghtOfList() {
		return this.lenghtOfList;
	}
	/**
	 * returns the number of elements in an array
	 * @return integer
	 */
	public int size() {
		return this.size;
	}
	
	public T[] getMyList() {
		return this.myList;
	}
	
	/**
	 * return true if the list is empty and false otherwise
	 * @return boolean
	 */
	public Boolean isEmpty() {
		if(this.size()==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * returns the element of the list at index i
	 * throw an error when i is not in the interval (0,size()-1
	 * @param i
	 * @return
	 */
	public T get(int i) {
		if (i<0 || i>this.size()) {
			throw new IndexOutOfBoundsException("Hey, the Index " + i + " is out of bounds!");
		}
		T element = this.myList[i];
		return element;	
	}
	
	/**
	 * set an element e of type T at index i in the list
	 * throw an error if i is out of the interval [0, size-1] 
	 * @param i
	 * @param e
	 * @return
	 */
	public T set(int i, T e) {
		if ((i<0 || i>this.size())) {
			throw new IndexOutOfBoundsException("Hey, the Index " + i + " is out of bounds!");
		}
		/**
		 * If the list is empty and the null is replaced by an element, the size should change from 0 to 1
		 */
		if(this.size() ==0) {
			this.size++;
		}
		if(this.lenghtOfList ==0) {
			this.lenghtOfList++;
		}
		T removed = this.get(i);
		this.myList[i] = e;
		
		return removed;
	}
	
	/**
	 * add an element e at index i and shifts all the subsequent elements
	 * this method is used in the add method
	 * @param i
	 * @param e
	 */
	private void shiftAndAdd(int i, T e) {
		if(this.myList[i] != null) {
			for (int b = this.size()-1; b>=i; b--) {
				this.myList[b+1] = myList[b]; 
			}
			
			this.myList[i] = e;
		}
		else {
			this.myList[i] = e;
		}
		this.size +=1;
	}
	
	/**
	 * uses the shiftAndAdd method to add an element e at a position i. 
	 * However, before adding, it checks whether the list is not full. 
	 * If the list is full, it doubles its size then, add the element e at position i
	 * @param i
	 * @param e
	 */
	public void add(int i, T e) {
		if ((i<0 || i>this.size())) {
			throw new IndexOutOfBoundsException("Hey, the Index " + i + " is out of bounds!");
		}
		else {
			if(this.size()==this.lenghtOfList) {
				@SuppressWarnings("unchecked")
				T[] temporaryArr = (T[]) new Object[this.size()*2];
				this.lenghtOfList *=2; 
				for(int k =0; k<this.size(); k++) {
					temporaryArr[k] = this.myList[k];
				}
				this.myList = temporaryArr;
				shiftAndAdd(i,e);
			}
			else {
				shiftAndAdd(i, e);
			}
		}
		
	}
	
	public void shiftBackRemove(int i) {
		for(int k = i; k<this.size(); k++) {
			this.myList[k] = myList[k+1]; 
		}
		this.myList[this.size()-1] = null;
		this.size -= 1; 
	}
	
	public T remove(int i) {
		if ((i<0 || i>this.size())) {
			throw new IndexOutOfBoundsException("Hey, the Index " + i + " is out of bounds!");
		}
		else {
			T removed = this.myList[i];
			shiftBackRemove(i);
			return removed;
		}
	}
	
	@Override
	public String toString() {
		return "Class= "+ Arrays.toString(this.getMyList());
	}
	
	public static void main(String[]args) {
		List<Integer> myList = new List<Integer>(1);
		System.out.println(myList.size());
		
		myList.get(0);
		System.out.println(myList.set(0, 1));
		System.out.println("the element is= "+myList.get(0));
		System.out.println("size = "+myList.size());
		System.out.println(myList.toString());
		System.out.println();
		myList.add(0, 5);
		myList.add(0, 4);
		myList.add(0, 3);
		myList.add(2, 10);
		System.out.println(myList.toString());
		System.out.println("new size = "+myList.size());
		myList.remove(3);
		System.out.println(myList.toString());
		System.out.println("new size = "+myList.size());
		
	}
	
	
	
}
