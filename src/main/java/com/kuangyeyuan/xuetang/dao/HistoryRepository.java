package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Darkal on 2016/6/20.
 */

@Repository
public interface HistoryRepository extends JpaRepository<HistoryEntity,Integer> {

    @Query("select s from HistoryEntity s where s.openid=?1")
    HistoryEntity findByOpenid(String openid);
}