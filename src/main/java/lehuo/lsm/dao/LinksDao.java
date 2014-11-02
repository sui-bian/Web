package lehuo.lsm.dao;


import lehuo.lsm.model.Links;
import lehuo.lsm.model.PkImg;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface LinksDao extends CommonCRUD<Links> {

    public Integer selectMax();

    public Integer selectNearMax(int id);
	
}
