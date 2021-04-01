package _DS14_201701971_°íµµÇö;

public interface VisitDelegate<Key extends Comparable<Key>, Obj extends Comparable<Obj>> {
	public void visitForReverseOfSortedOrder(Key key, Obj object, int aLevel);
	public void visitForSortedOrder(Key key, Obj object, int aLevel);
}

