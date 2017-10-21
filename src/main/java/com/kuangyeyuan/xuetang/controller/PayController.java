package com.kuangyeyuan.xuetang.controller;

import com.kuangyeyuan.xuetang.utils.Md5Utils;
import com.kuangyeyuan.xuetang.utils.Utils;
import com.kuangyeyuan.xuetang.bean.PaymentBean;
import com.kuangyeyuan.xuetang.dao.*;
import com.kuangyeyuan.xuetang.entity.ContentEntity;
import com.kuangyeyuan.xuetang.entity.OrderEntity;
import com.riversoft.weixin.common.util.XmlObjectMapper;
import com.riversoft.weixin.pay.payment.Payments;
import com.riversoft.weixin.pay.payment.bean.PaymentNotification;
import com.riversoft.weixin.pay.payment.bean.UnifiedOrderRequest;
import com.riversoft.weixin.pay.payment.bean.UnifiedOrderResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by darkal on 2017/9/4
 */
@Controller
public class PayController {
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

    @RequestMapping("/pay/createOrder")
    @ResponseBody
    public PaymentBean createOrder(String videoId,String session) {

        String openId = sessionRepository.findOpenId(session);

        if(openId == null || openId.length() ==0 || orderRepository.findPayedOrder(Integer.parseInt(videoId),openId) > 0){
            return null;
        }

        ContentEntity contentEntity = contentRepository.findOne(Integer.parseInt(videoId));

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOpenId(openId);
        orderEntity.setVideoId(Integer.parseInt(videoId));
        orderEntity.setPrice(contentEntity.getPrice());
        orderEntity.setState(0);
        orderEntity.setType(1);
        orderEntity.setTime(System.currentTimeMillis()/1000);

        orderEntity = orderRepository.save(orderEntity);

        UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
        unifiedOrderRequest.setOpenId(openId);
        unifiedOrderRequest.setBody(contentEntity.getTitle());
        unifiedOrderRequest.setDetail(contentEntity.getTitle());
        unifiedOrderRequest.setTradeNumber(orderEntity.getId()+"");
        unifiedOrderRequest.setTotalFee((int) (contentEntity.getPrice() * 100));
        unifiedOrderRequest.setNotifyUrl("https://api.darkal.cn/xuetang/pay/notify");
        unifiedOrderRequest.setTradeType("JSAPI");

        UnifiedOrderResponse response = Payments.defaultOrders().unifiedOrder(unifiedOrderRequest);


        PaymentBean paymentBean = new PaymentBean();
        paymentBean.setPackageId(response.getPrepayId());
        paymentBean.setTimeStamp(orderEntity.getTime()+"");
        paymentBean.setNonceStr(Utils.getRandomString(6).toUpperCase());
        paymentBean.setSignType("MD5");

        String stringSignTemp = "appId=wx00eb00cce90c9a3c&nonceStr="+paymentBean.getNonceStr()+"&package=prepay_id="+
                paymentBean.getPackageId()+"&signType=MD5&timeStamp="+paymentBean.getTimeStamp()+"&key=7C99F0E3D2DF03519D3449A7A33A8D28";


        paymentBean.setPaySign(Md5Utils.getMd5(stringSignTemp));

        return paymentBean;
    }

    @RequestMapping(value="/pay/notify", method = RequestMethod.POST)
    @ResponseBody
    public String notify(HttpServletRequest httpRequest) {
        try{
            String content = IOUtils.toString(httpRequest.getInputStream(), "UTF-8");
            PaymentNotification paymentNotification = XmlObjectMapper.defaultMapper().fromXml(content, PaymentNotification.class);
            if(Payments.defaultOrders().checkSignature(paymentNotification)) {

                OrderEntity orderEntity = orderRepository.findOne(Long.parseLong(paymentNotification.getTradeNumber()));

                if(orderEntity.getPrice()*100 <= paymentNotification.getTotalFee()){
                    orderEntity.setState(1);
                    orderRepository.save(orderEntity);
                    System.out.println(orderEntity.getId()+"订单支付成功！");

                    return "<xml>\n" +
                            "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                            "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                            "</xml>";
                }else{
                    System.out.println(orderEntity.getId()+"订单金额不符！");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return "";
    }

    @RequestMapping("/pay/createLuckyMoneyOrder")
    @ResponseBody
    public PaymentBean createLuckyMoneyOrder(String videoId,double fee,String session) {

        String openId = sessionRepository.findOpenId(session);
        ContentEntity contentEntity = contentRepository.findOne(Integer.parseInt(videoId));


        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOpenId(openId);
        orderEntity.setVideoId(Integer.parseInt(videoId));
        orderEntity.setPrice(fee);
        orderEntity.setState(0);
        orderEntity.setType(2);
        orderEntity.setTime(System.currentTimeMillis()/1000);

        orderEntity = orderRepository.save(orderEntity);

        UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
        unifiedOrderRequest.setOpenId(openId);
        unifiedOrderRequest.setBody(contentEntity.getTitle()+"红包赞赏");
        unifiedOrderRequest.setDetail(contentEntity.getTitle()+"红包赞赏");
        unifiedOrderRequest.setTradeNumber(orderEntity.getId()+"");
        unifiedOrderRequest.setTotalFee((int) (fee * 100));
        unifiedOrderRequest.setNotifyUrl("https://api.darkal.cn/xuetang/pay/notify");
        unifiedOrderRequest.setTradeType("JSAPI");

        UnifiedOrderResponse response = Payments.defaultOrders().unifiedOrder(unifiedOrderRequest);


        PaymentBean paymentBean = new PaymentBean();
        paymentBean.setPackageId(response.getPrepayId());
        paymentBean.setTimeStamp(orderEntity.getTime()+"");
        paymentBean.setNonceStr(Utils.getRandomString(6).toUpperCase());
        paymentBean.setSignType("MD5");

        String stringSignTemp = "appId=wx00eb00cce90c9a3c&nonceStr="+paymentBean.getNonceStr()+"&package=prepay_id="+
                paymentBean.getPackageId()+"&signType=MD5&timeStamp="+paymentBean.getTimeStamp()+"&key=7C99F0E3D2DF03519D3449A7A33A8D28";


        paymentBean.setPaySign(Md5Utils.getMd5(stringSignTemp));

        return paymentBean;
    }

}
