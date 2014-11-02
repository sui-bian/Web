package lehuo.lsm.dao;


import lehuo.lsm.model.PkImg;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PkImgDao extends CommonCRUD<PkImg> {

    public void batchInsert(List<PkImg> list);
	
}
