package lehuo.lsm.controller;

import lehuo.lsm.global.Global;
import lehuo.lsm.model.PkImg;
import lehuo.lsm.service.impl.ImgPKService;
import lehuo.lsm.service.impl.LinksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by simonliu on 2014/10/26.
 */
@Controller
public class IndexController {


    @RequestMapping(value = "/index")
    public String index() {
        return "redirect:/imgpk/index";
    }

}
