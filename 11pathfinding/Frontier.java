public interface Frontier<T>{
	public void add(T element);
	public T next();
	public boolean hasNext();
}