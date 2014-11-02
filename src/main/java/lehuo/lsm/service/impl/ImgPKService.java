package lehuo.lsm.service.impl;

import lehuo.lsm.dao.CommonCRUD;
import lehuo.lsm.dao.PkImgDao;
import lehuo.lsm.dao.PkSubmitDao;
import lehuo.lsm.model.PkImg;
import lehuo.lsm.model.PkSubmit;
import lehuo.lsm.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by simonliu on 2014/10/26.
 */
@Service
public class ImgPKService{

    @Resource
    PkImgDao pkImgDao;

    @Resource
    private PkSubmitDao pkSubmitDao;

    @Transactional
    public void insertPKSubmit(Integer age,Integer birth,String ip,List<PkImg> list){
        try{
            PkSubmit pksub = new PkSubmit(null,age,birth,ip);
            pkSubmitDao.insert(pksub);

            for(PkImg pkimg:list){
                pkimg.setAccessId(pksub.getId());
            }

            pkImgDao.batchInsert(list);
        }catch (Exception e){

        }
    }

}
