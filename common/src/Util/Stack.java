package Util;


public interface Stack<T> {

	void push(T v);

	T    pop();

	boolean isEmpty();

	void reset();
}
