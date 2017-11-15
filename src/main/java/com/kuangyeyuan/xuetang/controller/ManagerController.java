package com.kuangyeyuan.xuetang.controller;

import com.kuangyeyuan.xuetang.dao.CateRepository;
import com.kuangyeyuan.xuetang.dao.CommentRepository;
import com.kuangyeyuan.xuetang.dao.ContentRepository;
import com.kuangyeyuan.xuetang.entity.CateEntity;
import com.kuangyeyuan.xuetang.entity.CommentEntity;
import com.kuangyeyuan.xuetang.entity.ContentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * Created by darkal on 2017/8/27
 */
@Controller
public class ManagerController {

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    CateRepository cateRepository;

    @Autowired
    CommentRepository commentRepository;


    @RequestMapping("/list.do")
    public String initIndex(Model model) {
        model.addAttribute("contentList", contentRepository.findAllByTimeWithCate());
        return "list";
    }

    @RequestMapping("/catelist.do")
    public String initCateIndex(Model model) {
        model.addAttribute("contentList", cateRepository.findAll());
        return "catelist";
    }

    @ResponseBody
    @RequestMapping("/deleteItem.do")
    public String deleteItem(Model model,String id) {
        contentRepository.delete(Integer.parseInt(id));
        return "200";
    }

    @RequestMapping("/comment.do")
    public String comment(Model model) {
        model.addAttribute("contentList", commentRepository.findAllDesc());
        return "comment";
    }

    @ResponseBody
    @RequestMapping("/deleteComment.do")
    public String deleteComment(Model model,String id) {
        commentRepository.delete(Integer.parseInt(id));
        return "comment";
    }

    @ResponseBody
    @RequestMapping("/deleteCate.do")
    public String deleteCate(Model model,String id) {
        cateRepository.delete(Integer.parseInt(id));
        return "cate";
    }

    @ResponseBody
    @RequestMapping("/topComment.do")
    public String topComment(Model model,String id) {
        commentRepository.top(Integer.parseInt(id));
        return "comment";
    }

    @RequestMapping("/content.do")
    public String addContentContent(Model model,String id) {
        ContentEntity contentEntity = new ContentEntity();
        CateEntity cateEntity = new CateEntity();
        if(id == null ||id.isEmpty()){
            model.addAttribute("content",contentEntity);
            cateEntity.setTitle("请选择");
            model.addAttribute("cate",cateEntity);
        }else{
            contentEntity = contentRepository.findOne(Integer.parseInt(id));
            cateEntity = cateRepository.findOne(contentEntity.getCateId());
            model.addAttribute("content",contentEntity);
            model.addAttribute("cate",cateEntity);
        }

        model.addAttribute("cateList", cateRepository.findAllExpectType("content"));
        model.addAttribute("contentCateList", cateRepository.findAllByType("content"));
        model.addAttribute("allCateList", cateRepository.findAll());

        if(contentEntity.getContentCateId()!=0) {
            model.addAttribute("contentCateName", cateRepository.findOne(contentEntity.getContentCateId()).getTitle());
        }else{
            model.addAttribute("contentCateName", "请选择");
        }

        if(contentEntity.getType().equals("list")) {
            model.addAttribute("extCateName", cateRepository.findOne(Integer.parseInt(contentEntity.getExt())).getTitle());
        }else{
            model.addAttribute("extCateName", "请选择");
        }
        return "add-content";
    }

    @RequestMapping("/cate.do")
    public String addCateContent(Model model,String id) {
        if(id == null ||id.isEmpty()){
            model.addAttribute("content",new CateEntity());
        }else{
            model.addAttribute("content",cateRepository.findOne(Integer.parseInt(id)));
        }
        return "cate";
    }

    @PostMapping("/content.do")
    public String contentSubmit(@ModelAttribute ContentEntity contentEntity) {
        contentEntity.setCreateTime(System.currentTimeMillis());
        contentRepository.save(contentEntity);
        return "redirect:/list.do";
    }

    @PostMapping("/cate.do")
    public String cateSubmit(@ModelAttribute CateEntity cateEntity) {
        cateRepository.save(cateEntity);
        return "redirect:/catelist.do";
    }

    @RequestMapping("/addCate.do")
    public String addCateContent(Model model) {


        CateEntity cateEntity = new CateEntity();
        cateEntity.setType("banner");
        cateEntity.setTitle("顶部滚图");
        cateEntity.setSequence(1);

        cateRepository.save(cateEntity);

//        CateEntity cateEntity1 = new CateEntity();
//        cateEntity1.setType("icon");
//        cateEntity1.setTitle("导航按钮");
//        cateEntity1.setSequence(2);
//
//        cateRepository.save(cateEntity1);

        CateEntity cateEntity2 = new CateEntity();
        cateEntity2.setType("textRollLink");
        cateEntity2.setTitle("滚动文字");
        cateEntity2.setSequence(2);

        cateRepository.save(cateEntity2);


        for (int i = 3; i < 8; i++) {
            CateEntity cateEntity3 = new CateEntity();
            cateEntity3.setType("course");
            cateEntity3.setTitle("第一堂专业课");
            cateEntity3.setSequence(i);
            cateRepository.save(cateEntity3);
        }



//        model.addAttribute("NetworkMenu", menuBean.getNetworkMenu());
        return "add-cate";
    }
}
