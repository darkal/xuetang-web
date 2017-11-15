package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.HotSearchKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Darkal on 2016/6/20.
 */

@Repository
public interface HotSearchKeywordRepository extends JpaRepository<HotSearchKeyword,Integer> {
    @Override
    @Query("select s from HotSearchKeyword s order by s.size desc")
    List<HotSearchKeyword> findAll();
}