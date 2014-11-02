package lehuo.lsm.test.service;

import lehuo.lsm.dao.PkImgDao;
import lehuo.lsm.dao.PkSubmitDao;
import lehuo.lsm.model.PkImg;
import lehuo.lsm.model.PkSubmit;
import lehuo.lsm.service.impl.ImgPKService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class ImgPKServiceTest {
	private ClassPathXmlApplicationContext context;

    @Resource
    private ImgPKService  imgPKService;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        imgPKService = (ImgPKService) context.getBean("imgPKService");
	}

    @Test
    public void testImgServiceInsert() {
        PkImg pkImg1 = new PkImg(111,222);
        PkImg pkImg2 = new PkImg(333,444);
        List<PkImg> list = new ArrayList<PkImg>();
        list.add(pkImg1);
        list.add(pkImg2);

        imgPKService.insertPKSubmit(27,6,"127.0.0.1",list);
    }
}