package _DS13_201701971_고도현;

public class DictionaryElement<Key extends Comparable<Key>, Obj extends Comparable<Obj>> {
	private Key _key;
	private Obj _object;

	public DictionaryElement() {
	}

	public DictionaryElement(Key givenKey, Obj givenObject) {	// 생성자
		this.setKey(givenKey);
		this.setObject(givenObject);
	}

	public Key key() {	// getter
		return this._key;
	}

	public void setKey(Key newKey) {	// setter
		this._key = newKey;
	}

	public Obj object() {	// getter
		return this._object;
	}

	public void setObject(Obj newObject) {	// setter
		this._object = newObject;
	}

}
