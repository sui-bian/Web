package lehuo.lsm.dao;

public interface CommonCRUD<T>{
	public int insert(T t);
	
	public int delete(T t);
	
	public int update(T t);
	
	public T select(T t);
}
