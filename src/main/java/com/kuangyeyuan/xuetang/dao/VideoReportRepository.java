package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.VideoReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Darkal on 2016/6/20.
 */

@Repository
public interface VideoReportRepository extends JpaRepository<VideoReport,Integer> {
}