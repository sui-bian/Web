package lehuo.lsm.controller;

import lehuo.lsm.global.Global;
import lehuo.lsm.model.Links;
import lehuo.lsm.model.PkImg;
import lehuo.lsm.service.impl.ImgPKService;
import lehuo.lsm.service.impl.LinksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by simonliu on 2014/10/26.
 */
@Controller
@RequestMapping(value = "/imgpk")
public class ImgPKController {

    @Resource
    private ImgPKService imgPKService;

    @Resource
    private LinksService linksService;

    private static final int oneBatchNum = 10;

    @RequestMapping(value = "/index")
    public String oneRound(ModelMap map) {
        if(Global.getLINK_MAX()==0){
            Global.setLINK_MAX(linksService.selectMax());
        }

        /*List<Integer> left= linksService.selectRandom(oneBatchNum);
        List<Integer> right= linksService.selectRandom(oneBatchNum);*/

        List<String> left = new ArrayList<String>();
        left.add("1.jpg");
        left.add("2.jpg");

        map.put("left",left);
        map.put("right",left);

        return "pk";
    }

    @RequestMapping(value = "/oneround")
    @ResponseBody
    public String oneRound(String data, String age, String birth, HttpServletRequest request) {
        try {
            String ip = (String) request.getAttribute("ip");

            List<PkImg> list = new ArrayList<PkImg>();
            String[] rounds = data.split(":");
            for (String r : rounds) {
                String[] pkvo = r.split(",");
                PkImg vo = new PkImg(Integer.parseInt(pkvo[0]), Integer.parseInt(pkvo[1]));
                list.add(vo);
            }

            Integer ageInt = Integer.parseInt(age);
            Integer birthInt = Integer.parseInt(birth);

            imgPKService.insertPKSubmit(ageInt, birthInt, ip, list);

            return "success";
        } catch (Exception e) {
            return "failture";
        }
    }

    @RequestMapping(value = "/nextbatch")
    @ResponseBody
    public String nextBatch(){
        List<Integer> list= linksService.selectRandom(oneBatchNum);
        return list.toString();
    }





    public static void main(String[] args) {

    }
}
