package _DS13_201701971_°íµµÇö;

public interface Stack<E> {
	public int size();
	public boolean isFull();
	public boolean isEmpty();
	public boolean push(E anElement);
	public E pop();
	public E peek();
	public void clear();
}
