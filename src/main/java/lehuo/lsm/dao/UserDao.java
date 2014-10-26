package lehuo.lsm.dao;


import org.springframework.stereotype.Component;

import lehuo.lsm.annotation.SqlMapper;
import lehuo.lsm.model.User;
@Component
public interface UserDao extends CommonCRUD<User> {
	
}
