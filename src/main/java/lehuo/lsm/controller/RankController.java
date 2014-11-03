package lehuo.lsm.controller;

import lehuo.lsm.global.Global;
import lehuo.lsm.model.Comment;
import lehuo.lsm.model.Links;
import lehuo.lsm.model.PkImg;
import lehuo.lsm.service.impl.CommentService;
import lehuo.lsm.service.impl.ImgPKService;
import lehuo.lsm.service.impl.LinksService;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping(value = "/rank")
public class RankController {

    @Resource
    LinksService linksService;

    @Resource
    CommentService commentService;

    @RequestMapping(value = "/rankList")
    public String rankList(ModelMap map){
        List<String> list = new ArrayList<String>();
        list.add("5378_1.jpg");
        list.add("5378_2.jpg");
        list.add("7.jpg");
        list.add("8.jpg");
        list.add("9.jpg");
        list.add("10.jpg");
        list.add("1.jpg");
        list.add("2.jpg");
        list.add("5378_1.jpg");
        list.add("10.jpg");
        list.add("1.jpg");
        list.add("2.jpg");
        list.add("5378_2.jpg");
        list.add("7.jpg");
        list.add("8.jpg");
        list.add("9.jpg");

        map.put("list",list);
        return "ranklist";
    }

    @RequestMapping(value = "/detail")
    public String detail(String id,ModelMap map){
        Links link = linksService.select(new Links(Integer.parseInt(id)));

        map.put("link",link);
        map.put("images",parseImgUrl(link.getImg()));
        map.put("comment","comment");
        return "detail";
    }

    @RequestMapping(value = "/score")
    @ResponseBody
    public String getScore(String data,String score){
        String id = data.replace("rating:","");
        Integer sc = Integer.parseInt(score);
        return "success";
    }

    @RequestMapping(value = "/comment")
    @ResponseBody
    public String comment(String linkId,String comment){
        if(StringUtils.isBlank(comment)){
            return "false";
        }else{
            try{
                commentService.insert(new Comment(Integer.parseInt(linkId),comment));
                return "true";
            }catch(Exception e){
                return "false";
            }
        }
    }

    private List<String> parseImgUrl(String url){
        List<String> images = new ArrayList<String>();
        try{
            url = url.substring(1,url.length()-1);
        }catch (Exception e){

        }

        if(!StringUtils.isBlank(url)){
            String[] surl = url.split("\\, ");
            for(String u:surl){
                images.add(u);
            }
        }

        return images;
    }
}
