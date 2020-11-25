package test.mypac;

public class FruitBox<T> {
	public T item;

	
	public void setItem(T item) {
		this.item=item;
	}
	
	public T getItem() {
		return this.item;
	}
	/*
	 * 	new Fruit();
	 * 	new Fruit<Apple>();
	 * 	new Fruit<Banana>();
	 * 	new Fruit<Orange>();
	 */
}
