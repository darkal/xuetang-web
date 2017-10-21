package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Darkal on 2016/6/20.
 */

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    @Query("select c from OrderEntity c where c.state=1 and c.openId=?1")
    List<OrderEntity> findPayedOrder(String openId);

    @Query("select count(1) from OrderEntity c where c.videoId=?1 and c.openId=?2 and c.state=1")
    int findPayedOrder(Integer videoId, String openId);

    @Query("select c from OrderEntity c where c.videoId=?1 and c.state=1 and c.type=2 order by c.price DESC")
    List<OrderEntity> findLuckyMoney(Integer videoId);

    @Query("select count(1) from OrderEntity c where c.videoId=?1 and c.state=1")
    int getPayedNum(Integer videoId);
}