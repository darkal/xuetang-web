package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Darkal on 2016/6/20.
 */

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity,Integer> {

}