package dao.abs;

import java.util.List;

public interface AbstractDao <T,K>{

    boolean create(T type);
    T findById(K key);
    boolean deleteById(K key);
    boolean update(T type, int id);
    List<T> all();


}
