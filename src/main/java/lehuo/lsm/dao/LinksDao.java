package lehuo.lsm.dao;


import lehuo.lsm.model.Links;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LinksDao extends CommonCRUD<Links> {

    public Integer selectMax();

    public Integer selectNearMax(int id);

    public List<String> selectNeedReload();

    public List<Links> selectbyoffset(Integer offset);

    public void updateLinksbyLink(Links vo);

    public void batchInsertLinks(List<Links> list);

    public void insertLinks(Links vo);
	
}
