package lehuo.lsm.test.service;

import lehuo.lsm.model.Links;
import lehuo.lsm.model.PkImg;
import lehuo.lsm.service.impl.ImgPKService;
import lehuo.lsm.service.impl.LinksService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class LinksServiceTest {
	private ClassPathXmlApplicationContext context;

    @Resource
    private LinksService linksService;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        linksService = (LinksService) context.getBean("linksService");
	}

    @Test
    public void testlinksService() {
        Integer list = linksService.selectMax();
        System.out.print(list);
    }
    @Test
    public void testlinksSelect() {
        Links list = linksService.select(new Links(87207));
        System.out.print(list);
    }
}