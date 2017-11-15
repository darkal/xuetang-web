package com.kuangyeyuan.xuetang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kuangyeyuan.xuetang.Constants;
import com.kuangyeyuan.xuetang.bean.DataBean;
import com.kuangyeyuan.xuetang.bean.DataBeanType;
import com.kuangyeyuan.xuetang.bean.RespBean;
import com.kuangyeyuan.xuetang.bean.TemplateDataBean;
import com.kuangyeyuan.xuetang.dao.*;
import com.kuangyeyuan.xuetang.entity.*;
import com.kuangyeyuan.xuetang.factory.TemplateFactory;
import com.kuangyeyuan.xuetang.utils.ControllerUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by darkal on 2017/9/5
 */
@Controller
public class UserController {
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
    HistoryRepository historyRepository;

    @Autowired
    ReportRepository reportRepository;


    @RequestMapping("/my/onLogin")
    @ResponseBody
    public String onLogin(final String code, final String nickName, final String avatarUrl, final String gender,
                          final String province, final String city, final String country) {

        String session = DigestUtils.md5Hex(code + System.currentTimeMillis());

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + Constants.APP_ID + "&secret=" +
                Constants.APP_SERCRET + "&js_code=" + code + "&grant_type=authorization_code";

        JSONObject json = JSONObject.parseObject(restTemplate.getForObject(url, String.class));
        UserEntity userEntity = new UserEntity();
        userEntity.setOpenid(json.getString("openid"));
        userEntity.setNickname(nickName);
        userEntity.setAvatarUrl(avatarUrl);
        userEntity.setGender(gender);
        userEntity.setProvince(province);
        userEntity.setCity(city);
        userEntity.setCountry(country);

        userRepository.save(userEntity);

        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity.setOpenid(json.getString("openid"));
        sessionEntity.setSession_key(json.getString("session_key"));
        sessionEntity.setSession(session);
        sessionEntity.setTimestamp(System.currentTimeMillis());
        sessionRepository.save(sessionEntity);

        return session;
    }

    @RequestMapping("/my/checkSession")
    @ResponseBody
    public String checkSession(String session) {
        SessionEntity sessionEntity = sessionRepository.findBySession(session);
        if (sessionEntity != null && sessionEntity.getOpenid().length() > 8 &&
                sessionEntity.getTimestamp() < (System.currentTimeMillis() + 86400000)) {
            return "true";
        }

        return "false";
    }


    @RequestMapping("/my/addHistory")
    @ResponseBody
    public Boolean addHistory(String session, String ids) {
        String openId = sessionRepository.findOpenId(session);

        if (openId != null && openId.length() > 8) {
            HistoryEntity history = historyRepository.findByOpenid(openId);
            LinkedList<String> historyids = new LinkedList<>(Arrays.asList(history.getHistoryIds().split("\\|")));
            for (String id : ids.split("\\|")) {
                if (historyids.size() > 30) {
                    historyids.removeFirst();
                }
                historyids.addLast(id);
            }
            history.setHistoryIds(StringUtils.join(historyids.toArray(), "|"));

            historyRepository.save(history);
            return true;
        }
        return false;
    }

    public void addSingleHistory(String session, String id) {
        String openId = sessionRepository.findOpenId(session);
        if (openId != null && openId.length() > 8) {
            HistoryEntity history = historyRepository.findByOpenid(openId);
            LinkedList<String> historyids;
            if(history != null){
                historyids = new LinkedList<>(Arrays.asList(history.getHistoryIds().split("\\|")));
            }else{
                history = new HistoryEntity();
                history.setOpenid(openId);
                historyids = new LinkedList<>();
            }


            if(historyids.contains(id)){
                historyids.remove(id);
            }

            if (historyids.size() > 30) {
                historyids.removeFirst();
            }

            historyids.addLast(id);

            history.setHistoryIds(StringUtils.join(historyids.toArray(), "|"));

            historyRepository.save(history);
        }
    }

    @RequestMapping("/my/history")
    @ResponseBody
    public RespBean getHistory(String session) {
        String openId = sessionRepository.findOpenId(session);
        HistoryEntity history = historyRepository.findByOpenid(openId);

        LinkedList<ContentEntity> contentEntities = new LinkedList<>();

        for (String id : history.getHistoryIds().split("\\|")) {
            try {
                ContentEntity contentEntity = contentRepository.getOne(Integer.parseInt(id));
                if (contentEntity != null) {
                    contentEntities.addFirst(contentEntity);
                }
            }catch (Exception e){
//                e.printStackTrace();
            }
        }

        LinkedList<TemplateDataBean> firstCourceList = new LinkedList<TemplateDataBean>();

        LinkedList<TemplateDataBean> firstCourceTitle = new LinkedList<TemplateDataBean>();
        TemplateDataBean templateDataBean1 = new TemplateDataBean();
        templateDataBean1.setName("我的浏览记录");
        firstCourceTitle.add(templateDataBean1);

        for (ContentEntity contentEntity : contentEntities) {
            try{
                TemplateDataBean templateDataBean = ControllerUtils.getTemplateDataBean(contentEntity);
                firstCourceList.add(templateDataBean);
            }catch (Exception e){
    //                e.printStackTrace();
            }
        }

        LinkedList<DataBean> dataBeanLinkedList = new LinkedList<DataBean>();

        dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.title, firstCourceTitle));
        dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.normalLandScape, firstCourceList));

        return TemplateFactory.getRespBean(dataBeanLinkedList);
    }

    @RequestMapping("/my/buy")
    @ResponseBody
    public RespBean getBuy(String session) {
        String openId = sessionRepository.findOpenId(session);
        List<OrderEntity> orderList = orderRepository.findPayedOrder(openId);

        LinkedList<ContentEntity> contentEntities = new LinkedList<>();

        for (OrderEntity order : orderList) {
            contentEntities.addFirst(contentRepository.getOne(order.getVideoId()));
        }

        LinkedList<TemplateDataBean> firstCourceList = new LinkedList<TemplateDataBean>();

        LinkedList<TemplateDataBean> firstCourceTitle = new LinkedList<TemplateDataBean>();
        TemplateDataBean templateDataBean1 = new TemplateDataBean();
        templateDataBean1.setName("我的购买记录");
        firstCourceTitle.add(templateDataBean1);

        for (ContentEntity contentEntity : contentEntities) {
            try {
                TemplateDataBean templateDataBean = ControllerUtils.getTemplateDataBean(contentEntity);
                firstCourceList.add(templateDataBean);
            }catch (Exception e){

            }
        }

        LinkedList<DataBean> dataBeanLinkedList = new LinkedList<DataBean>();

        dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.title, firstCourceTitle));
        dataBeanLinkedList.add(TemplateFactory.getDataBean(DataBeanType.normalLandScape, firstCourceList));

        return TemplateFactory.getRespBean(dataBeanLinkedList);
    }

    @RequestMapping("/my/report")
    @ResponseBody
    public String report(String session,String name,String tel,String text,int score,String formId) {
        String openId = sessionRepository.findOpenId(session);

        if(openId != null) {
            ReportEntity reportEntity = new ReportEntity();
            reportEntity.setOpenId(openId);
            reportEntity.setUserName(name);
            reportEntity.setTel(tel);
            reportEntity.setText(text);
            reportEntity.setScore(score);
            reportEntity.setFormId(formId);

            reportRepository.save(reportEntity);
        }
        return "1";
    }
}
