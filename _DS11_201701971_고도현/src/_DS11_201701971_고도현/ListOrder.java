package _DS11_201701971_고도현;

public enum ListOrder {
	Ascending, Descending, Random;	

	public static final String[] ORDER_NAMES = { "오름차순", "내림차순", "무작위" };

	public String orderName() {
		return ListOrder.ORDER_NAMES[this.ordinal()];
	}
}
