package lehuo.lsm.test.service;

import lehuo.lsm.model.PkImg;
import lehuo.lsm.service.impl.ImgPKService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.lsm.processer.DoubanProcesser;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class DoubanTest {
	private ClassPathXmlApplicationContext context;

    @Resource
    private DoubanProcesser doubanProcesser;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        doubanProcesser = (DoubanProcesser) context.getBean("doubanProcesser");
	}

    @Test
     public void testDouban() {
        doubanProcesser.action();
    }

    @Test
    public void testlsm() {
        doubanProcesser.testlsm();
    }
}