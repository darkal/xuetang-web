package com.kuangyeyuan.xuetang.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by darkal on 2017/8/27
 */
@Controller
public class UEditorController {

    @RequestMapping("/ueditor/config")
    public @ResponseBody
    String controller(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");


        String exec = new ActionEnter(request, rootPath).exec();
        // response.getWriter().write(baseState);
        return exec;
    }
}
