package lehuo.lsm.service.impl;

import lehuo.lsm.dao.CommentDao;
import lehuo.lsm.dao.CommonCRUD;
import lehuo.lsm.dao.LinksDao;
import lehuo.lsm.global.Global;
import lehuo.lsm.model.Comment;
import lehuo.lsm.model.Links;
import lehuo.lsm.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by simonliu on 2014/10/26.
 */
@Service
public class CommentService extends BaseService<Comment>{

    @Resource
    CommentDao dao;

    @Override
    public CommonCRUD<Comment> getDao() {
        return dao;
    }
}
