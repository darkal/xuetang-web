package com.kuangyeyuan.xuetang.controller;

import com.kuangyeyuan.xuetang.bean.*;
import com.kuangyeyuan.xuetang.dao.*;
import com.kuangyeyuan.xuetang.entity.*;
import com.kuangyeyuan.xuetang.factory.TemplateFactory;
import com.kuangyeyuan.xuetang.utils.ControllerUtils;
import com.kuangyeyuan.xuetang.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by darkal on 2017/8/22
 */
@Controller
public class IndexController {

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    CateRepository cateRepository;

    @Autowired
    ChoiceRepository choiceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserController userController;

    @RequestMapping("/Datas/tab1.json")
    @ResponseBody
    public RespBean home(String version) {

        int versionCode = 1;

        List<ContentEntity> contentEntities = new LinkedList<>();

        if(version!=null){
            versionCode = Integer.parseInt(version);
        }

        if(versionCode == 1) {
            contentEntities.addAll(contentRepository.findAllWithVersion1());
        }

        contentEntities.addAll(contentRepository.findAllBySequence());

        LinkedList<TemplateDataBean> bannerList = new LinkedList<TemplateDataBean>();
        LinkedList<TemplateDataBean> textRollLinkList = new LinkedList<TemplateDataBean>();
        LinkedList<TemplateDataBean> iconLinkList = new LinkedList<TemplateDataBean>();

        LinkedList<DataBean> dataBeanLinkedList = new LinkedList<DataBean>();

        for (ContentEntity contentEntity : contentEntities) {
            TemplateDataBean templateDataBean = ControllerUtils.getTemplateDataBean(contentEntity);

            if (contentEntity.getCateId() == 1) {
                bannerList.add(templateDataBean);
                continue;
            }
            if (contentEntity.getCateId() == 2) {
                textRollLinkList.add(templateDataBean);
                continue;
            }
        }

        for (CateEntity cateEntity : cateRepository.findAllByType("content")){
            iconLinkList.add(ControllerUtils.getIconTemplateDataBean(cateEntity));
        }

        dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.banner, bannerList));
        dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.roundAvatorText, iconLinkList));
        dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.textRollLink, textRollLinkList));

        for (CateEntity cateEntity : cateRepository.findAllByType("course")) {
            if(cateEntity.getDisplay() == 0){
                continue;
            }

            LinkedList<TemplateDataBean> courseTitle = new LinkedList<TemplateDataBean>();
            TemplateDataBean templateDataBean1 = new TemplateDataBean();
            templateDataBean1.setName(cateEntity.getTitle());
            courseTitle.add(templateDataBean1);

            LinkedList<TemplateDataBean> courseList = new LinkedList<TemplateDataBean>();
            LinkedList<TemplateDataBean> courseLargeList = new LinkedList<TemplateDataBean>();
            LinkedList<TemplateDataBean> courseMoreList = new LinkedList<TemplateDataBean>();

            if (versionCode > 1 && cateEntity.getIsLarge() == 1){
                TemplateDataBean templateDataBean = new TemplateDataBean();
                templateDataBean.setName(cateEntity.getTitle());
                templateDataBean.setPicUrl(cateEntity.getBannerUrl());
                templateDataBean.setWebUrl("/pages/list/list?type=list&id=" + cateEntity.getId());
                courseLargeList.add(templateDataBean);
            }

            if(versionCode > 1) {
                // 乱序观察视频受欢迎程度
                Collections.shuffle(contentEntities);
            }

            for (ContentEntity contentEntity : contentEntities) {
                TemplateDataBean templateDataBean = ControllerUtils.getTemplateDataBean(contentEntity);

                if (contentEntity.getCateId() == cateEntity.getId()) {
                    if(versionCode == 1 && cateEntity.getIsLarge() == 1 && courseLargeList.size() == 0){
                        courseLargeList.add(templateDataBean);
                    }else if(courseList.size() < 6){
                        courseList.add(templateDataBean);
                    }else if(courseMoreList.size() == 0) {
                        templateDataBean.setName("更多 " + cateEntity.getTitle() + " 视频");
                        templateDataBean.setWebUrl("/pages/list/list?type=list&id=" + cateEntity.getId());
                        courseMoreList.add(templateDataBean);
                    }
                }
            }

            dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.title, courseTitle));
            if (courseLargeList.size() > 0) {
                dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.largeLandScapeNodesc, courseLargeList));
            }



            dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.normalLandScape, courseList));
            if(courseMoreList.size()>0){
                dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.textMoreLink,courseMoreList));
            }
        }

        return TemplateFactory.getRespBean(dataBeanLinkedList);
    }

    @RequestMapping("/Datas/choice.json")
    @ResponseBody
    public List<ChoiceBean> choice() {
        List<ChoiceBean> choiceList = new LinkedList<ChoiceBean>();

        List<ChoiceEntity> choiceEntities = choiceRepository.findAll();

        for (ChoiceEntity choiceEntity : choiceEntities) {
            ChoiceBean choiceBean = new ChoiceBean();
            choiceBean.setBanner(choiceEntity.getBanner());
            choiceBean.setTitle(choiceEntity.getTitle());

            List<TemplateDataBean> linkedList = new LinkedList<TemplateDataBean>();

            for (String id : choiceEntity.getContentId().split("\\|")) {
                ContentEntity contentEntity = contentRepository.findOne(Integer.parseInt(id));
                TemplateDataBean templateDataBean = new TemplateDataBean();
                templateDataBean.setName(contentEntity.getTitle());
                templateDataBean.setPicUrl(contentEntity.getImage());
                templateDataBean.setVideoId(contentEntity.getId());
                templateDataBean.setDesc(contentEntity.getContentDesc());
                linkedList.add(templateDataBean);
            }

            choiceBean.setTemplateData(linkedList);

            choiceList.add(choiceBean);
        }
        return choiceList;
    }

    @RequestMapping("/Datas/list.json")
    @ResponseBody
    public RespBean getList(String cateId) {

        CateEntity cateEntity = cateRepository.getOne(Integer.parseInt(cateId));


        LinkedList<ContentEntity> contentEntities = new LinkedList<>();

        // 内容分类
        if(cateEntity.getType().equals("content")){
            contentEntities.addAll(contentRepository.findByContentCateId(Integer.parseInt(cateId)));
        }else{
            contentEntities.addAll(contentRepository.findByCateId(Integer.parseInt(cateId)));
        }

        LinkedList<TemplateDataBean> tempDataList = new LinkedList<TemplateDataBean>();

        LinkedList<TemplateDataBean> bannerList = new LinkedList<TemplateDataBean>();

        for (String url : cateEntity.getBannerUrl().split("\\|")) {
            TemplateDataBean bannerBean = new TemplateDataBean();
            bannerBean.setName(cateEntity.getTitle());
            bannerBean.setPicUrl(url);
            bannerList.add(bannerBean);
        }

        LinkedList<TemplateDataBean> firstCourceTitle = new LinkedList<TemplateDataBean>();
        TemplateDataBean templateDataBean1 = new TemplateDataBean();
        templateDataBean1.setName(cateEntity.getTitle());
        firstCourceTitle.add(templateDataBean1);

        for (ContentEntity contentEntity : contentEntities) {
            if(!contentEntity.getType().equals("list")){
                TemplateDataBean templateDataBean = ControllerUtils.getTemplateDataBean(contentEntity);
                tempDataList.add(templateDataBean);
            }
        }

        LinkedList<DataBean> dataBeanLinkedList = new LinkedList<DataBean>();
        dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.banner, bannerList));
        dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.title, firstCourceTitle));
        dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.normalLandScape, tempDataList));

        return TemplateFactory.getRespBean(dataBeanLinkedList);
    }

    @RequestMapping("/Datas/video.json")
    @ResponseBody
    public VideoBean video(String id, String session,String type) {
        VideoBean videoBean = new VideoBean();
        try {
            if(type == null || !type.equals("ajax")) {
                userController.addSingleHistory(session, id);
                contentRepository.addViewCount(Integer.parseInt(id));
            }
            ContentEntity contentEntity = contentRepository.findOne(Integer.parseInt(id));

            Boolean isPay = false;
            if (contentEntity.getPrice() > 0) {
                if (session != null) {
                    String openId = sessionRepository.findOpenId(session);
                    isPay = orderRepository.findPayedOrder(Integer.parseInt(id), openId) > 0;
                }
            } else {
                isPay = true;
            }

            videoBean.setStart(contentEntity.getStart());
            videoBean.setPay(isPay);
            videoBean.setCode(200);
            VideoBean.DataBean dataBean = new VideoBean.DataBean();
            dataBean.setPrice(contentEntity.getPrice());
            if (contentEntity.getPrice() > 0) {
                dataBean.setPayNum(orderRepository.getPayedNum(Integer.parseInt(id)));
            }
            dataBean.setCover(contentEntity.getImage());
            dataBean.setName(contentEntity.getTitle());
            dataBean.setDesc(contentEntity.getContentDesc());
            dataBean.setArtistName(contentEntity.getAuthor());
            dataBean.setPlayCount(contentEntity.getViewCount());
            if (isPay && contentEntity.getStart()==1) {

                String videoUrl = contentEntity.getVideoUrl();
                if(!videoUrl.contains("http") && videoUrl.contains("0_")){
                    dataBean.setVideoURL("http://video.darkal.cn//p/104/sp/10400/playManifest/entryId/"+videoUrl+
                            "/format/applehttp/protocol/http/video.m3u8");
                }else {
                    dataBean.setVideoURL(contentEntity.getVideoUrl());
                }
            }else{
                dataBean.setVideoURL("http://push.darkal.cn/pre/pre.m3u8");
                videoBean.setTips(contentEntity.getTips());
            }
            dataBean.setContent(contentEntity.getContent());
            dataBean.setCommentCount(commentRepository.findAllCommentNum(Integer.parseInt(id)));

            videoBean.setData(dataBean);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return videoBean;
    }

    @RequestMapping("/Datas/video_bi.json")
    @ResponseBody
    public VideoBiBean videoBi(String id) {
        VideoBiBean videoBiBean = new VideoBiBean();
        try {
            ContentEntity content = contentRepository.findOne(Integer.parseInt(id));

            List<ContentEntity> contentEntityList = contentRepository.findByCateId(content.getCateId());

            contentEntityList.addAll(contentRepository.findByContentCateId(content.getContentCateId()));
            videoBiBean.setCode(200);

            // 去重
            List<ContentEntity> contentList = new LinkedList<>();
            List<Integer> idList = new LinkedList<>();
            for(ContentEntity contentEntity : contentEntityList){
                if(!idList.contains(contentEntity.getId()) &&
                        (contentEntity.getType().equals("") || contentEntity.getType().equals("video") )) {
                    idList.add(contentEntity.getId());
                    contentList.add(contentEntity);
                }
            }

            List<VideoBiBean.MvsBean> mvsBeanList = new LinkedList<>();
            for (ContentEntity contentEntity : contentList) {
                if (!id.equals(contentEntity.getId() + "")) {
                    VideoBiBean.MvsBean mvsBean = new VideoBiBean.MvsBean();
                    mvsBean.setArtistName(contentEntity.getAuthor());
                    mvsBean.setName(contentEntity.getTitle());
                    mvsBean.setCover(contentEntity.getImage());
                    mvsBean.setId(contentEntity.getId());
                    mvsBean.setPlayCount(contentEntity.getViewCount());
                    mvsBeanList.add(mvsBean);
                }
            }
            videoBiBean.setMvs(mvsBeanList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return videoBiBean;
    }

    @RequestMapping("/Datas/live.json")
    @ResponseBody
    public LiveBean live() {
        LiveBean liveBean = new LiveBean();
        try {
            List<ContentEntity> contentEntityList = contentRepository.findByType("live");
            liveBean.setCode(200);

            List<TemplateDataBean> linkedList = new LinkedList<TemplateDataBean>();
            for (ContentEntity contentEntity : contentEntityList) {
                TemplateDataBean templateDataBean = new TemplateDataBean();
                templateDataBean.setName(contentEntity.getTitle());
                templateDataBean.setPicUrl(contentEntity.getImage());
                templateDataBean.setVideoId(contentEntity.getId());
                templateDataBean.setDesc(contentEntity.getContentDesc());
                linkedList.add(templateDataBean);
            }
            liveBean.setData(linkedList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return liveBean;
    }

    @RequestMapping("/Datas/createUsers.json")
    @ResponseBody
    public String updateUser(@ModelAttribute UserEntity userEntity) {
        userRepository.save(userEntity);
        return "true";
    }


    @RequestMapping("/Datas/createComment")
    @ResponseBody
    public String createComment(@ModelAttribute CommentEntity commentEntity) {
        commentEntity.setTime(System.currentTimeMillis());
        commentRepository.save(commentEntity);
        return "true";
    }

    @RequestMapping("/Datas/comment.json")
    @ResponseBody
    public List<CommentBean> getComment(String id) {
        List<CommentBean> list = new LinkedList<>();

        for (CommentEntity commentEntity : commentRepository.findAllTopComment(Integer.parseInt(id))) {
            addCommentList(list,commentEntity);
        }

        for (OrderEntity orderEntity : orderRepository.findLuckyMoney(Integer.parseInt(id))) {
            UserEntity userEntity = userRepository.findByOpenid(orderEntity.getOpenId());
            CommentBean commentBean = new CommentBean();
            commentBean.setMoney(true);
            commentBean.setAvatar(userEntity.getAvatarUrl());
            commentBean.setTop(false);
            commentBean.setContent(userEntity.getNickname()+" 赞赏了 ¥" + orderEntity.getPrice());
            commentBean.setTime(Utils.stampToDate(orderEntity.getTime() + "000"));
            commentBean.setuName(userEntity.getNickname());

            list.add(commentBean);
        }

        for (CommentEntity commentEntity : commentRepository.findAllNormalComment(Integer.parseInt(id))) {
            addCommentList(list,commentEntity);
        }
        return list;
    }

    public void addCommentList(List<CommentBean> commentBeanList,CommentEntity commentEntity){
        CommentBean commentBean = new CommentBean();
        commentBean.setAvatar(commentEntity.getAvatar());
        commentBean.setTop(commentEntity.isTop());
        commentBean.setContent(commentEntity.getContent());
        commentBean.setTime(Utils.stampToDate(commentEntity.getTime() + ""));
        commentBean.setuName(commentEntity.getuName());
        commentBeanList.add(commentBean);
    }

    @RequestMapping("/Datas/content.json")
    @ResponseBody
    public ContentBean getContent(String id, String session) {
        userController.addSingleHistory(session, id);
        ContentBean contentBean = new ContentBean();

        contentRepository.addViewCount(Integer.parseInt(id));
        ContentEntity contentEntity = contentRepository.getOne(Integer.parseInt(id));
        contentBean.setAuthor(contentEntity.getAuthor());
        contentBean.setContent(contentEntity.getContent());
        contentBean.setViewCount(contentEntity.getViewCount());
        contentBean.setTitle(contentEntity.getTitle());

        return contentBean;
    }
}
