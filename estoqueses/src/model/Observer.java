package model;

public interface Observer<T> {
	public void update(T obj) throws Exception;
}
