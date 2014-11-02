package lehuo.lsm.service;


import lehuo.lsm.dao.CommonCRUD;
import lehuo.lsm.dao.UserDao;

import javax.annotation.Resource;

/**
 * Created by simonliu on 2014/10/26.
 */
public abstract class BaseService<T>{

    public abstract CommonCRUD<T> getDao();

    public void insert(T t){
        getDao().insert(t);
    }

    public void delete(T t){
        getDao().delete(t);
    }

    public void update(T t){
        getDao().update(t);
    }

    public T select(T t){
        return getDao().select(t);
    }
}
