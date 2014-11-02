package lehuo.lsm.test.dao;

import lehuo.lsm.dao.PkImgDao;
import lehuo.lsm.dao.PkSubmitDao;
import lehuo.lsm.model.PkImg;
import lehuo.lsm.model.PkSubmit;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class PkImgDaoTest {
	private ClassPathXmlApplicationContext context;

    @Resource
    private PkImgDao pkImgDao;

    @Resource
    private PkSubmitDao pkSubmitDao;
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        pkImgDao = (PkImgDao) context.getBean("pkImgDao");
        pkSubmitDao = (PkSubmitDao)context.getBean("pkSubmitDao");
	}

	@Test
	public void testPkIInsert() {
        PkImg pkImg1 = new PkImg(111,222);
        pkImgDao.insert(pkImg1);
	}

    @Test
    public void testPkImgInsert() {
        PkImg pkImg1 = new PkImg(111,222);
        PkImg pkImg2 = new PkImg(333,444);
        List<PkImg> list = new ArrayList<PkImg>();
        list.add(pkImg1);
        list.add(pkImg2);

        pkImgDao.batchInsert(list);
    }
}