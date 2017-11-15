package com.kuangyeyuan.xuetang.controller;

import com.kuangyeyuan.xuetang.dao.SessionRepository;
import com.kuangyeyuan.xuetang.dao.VideoReportRepository;
import com.kuangyeyuan.xuetang.entity.VideoReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by darkal on 2017/11/13
 */
@Controller
public class ReportController {
    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    VideoReportRepository videoReportRepository;

    @RequestMapping("/report/video")
    @ResponseBody
    public String video(int videoId, String session, long watchTime) {
        String openid = "";
        try {
            openid = sessionRepository.findOpenId(session);
        } catch (Exception e) {
//            e.printStackTrace();
        }

        VideoReport videoReport = new VideoReport();
        videoReport.setOpenId(openid);
        videoReport.setWatchTime(watchTime);
        videoReport.setTime(System.currentTimeMillis());
        videoReport.setVideoId(videoId);
        videoReportRepository.save(videoReport);

        return "";
    }

}
