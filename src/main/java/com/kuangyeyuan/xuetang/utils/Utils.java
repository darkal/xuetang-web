package com.kuangyeyuan.xuetang.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by darkal on 2017/8/30
 */
public class Utils {

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

//    public static void main(String[] args) throws Exception {
//
//        File input = new File("/Users/darkal/Documents/TEMP/13.html");
//
//        Document doc = Jsoup.parse(input, "UTF-8", "");
//
//        Elements link = doc.select("tr");
//
//        List<PeopleBean> peopleBeans = new LinkedList<>();
//        int num = 1;
//        Loop:
//        for (Element element : link) {
//
//            PeopleBean peopleBean = new PeopleBean();
//
//            for (Element element1 : element.select("tr")) {
//                for (Element element2 : element.getElementsByClass("MsoNormal")) {
//
//                    if (peopleBean.getName().isEmpty()) {
//                        peopleBean.setName(element2.text());
//                        continue;
//                    }
//                    if (peopleBean.getTitle1().isEmpty()) {
//                        peopleBean.setTitle1(element2.text());
//                        continue;
//                    }
//
//                    if (peopleBean.getTitle2().isEmpty()) {
//                        peopleBean.setTitle2(element2.text());
//                        continue;
//                    }
//
//                    if (peopleBean.getTitle3().isEmpty()) {
//                        peopleBean.setTitle3(element2.text());
//                        continue;
//                    }
//
//                }
//
//                System.out.println("<li>\n" +
//                        "                                        <div class=\"left\"><img src=\"images/image0" + num++ + ".png\" width=\"70\"></div>\n" +
//                        "                                        <div class=\"left ziti\"><b>" + peopleBean.getName() + "</b><br>" + peopleBean.getTitle1() + "\n" +
//                        "                                            <br>" + peopleBean.getTitle2() + "<br>" + peopleBean.getTitle3() + "</div>\n" +
//                        "                                        <div class=\"clear\"></div>\n" +
//                        "                                    </li>");
//
//            }
//
//            peopleBeans.add(peopleBean);
//        }
//    }
}
