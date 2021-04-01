package _DS10_02_201701971_°íµµÇö;

public interface Queue<T> {
	public int size();
	public boolean isFull();
	public boolean isEmpty();
	
	public T front();
	public T rear();
	
	public boolean enQueue(T anElement);
	public T deQueue();
	
	public void clear();
	
	public T elementAt(int anOrder);
	public Iterator<T> iterator();
}
