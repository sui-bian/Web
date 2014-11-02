package lehuo.lsm.service.impl;

import lehuo.lsm.dao.CommonCRUD;
import lehuo.lsm.dao.LinksDao;
import lehuo.lsm.dao.PkImgDao;
import lehuo.lsm.dao.PkSubmitDao;
import lehuo.lsm.global.Global;
import lehuo.lsm.model.Links;
import lehuo.lsm.model.PkImg;
import lehuo.lsm.model.PkSubmit;
import lehuo.lsm.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by simonliu on 2014/10/26.
 */
@Service
public class LinksService extends BaseService<Links>{

    @Resource
    LinksDao dao;

    private static Random random = new Random();

    public Integer selectMax(){
        return dao.selectMax();
    }

    public List<Integer> selectRandom(int limit){
        int max = Global.getLINK_MAX();

        List<Integer> list = new ArrayList<Integer>(limit);
        for(int i=0;i<limit;i++){
            int r = random.nextInt(max);
            Integer id = dao.selectNearMax(r);
            list.add(id);
        }

        return list;
    }

    @Override
    public CommonCRUD<Links> getDao() {
        return dao;
    }
}
