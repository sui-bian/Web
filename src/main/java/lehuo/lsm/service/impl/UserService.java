package lehuo.lsm.service.impl;

import lehuo.lsm.dao.UserDao;
import lehuo.lsm.model.User;
import lehuo.lsm.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by simonliu on 2014/10/26.
 */
@Service
public class UserService extends BaseService{

    @Resource
    UserDao dao;

    public void insert(User u){
        dao.insert(u);
    }
}
