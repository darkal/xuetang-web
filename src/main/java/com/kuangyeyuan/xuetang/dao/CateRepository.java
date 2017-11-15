package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.CateEntity;
import com.kuangyeyuan.xuetang.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Darkal on 2016/6/20.
 */



@Repository
public interface CateRepository extends JpaRepository<CateEntity,Integer> {
    @Query("select s from CateEntity s where s.type='course' or s.type='single' order by s.display desc,s.sequence ")
    List<CateEntity> findAll();

    @Query("select s from CateEntity s where s.type='course' or s.type='single' order by s.sequence ")
    List<CateEntity> findAllIndex();

    @Query("select s from CateEntity s where s.type=?1 order by s.sequence ")
    List<CateEntity> findAllByType(String type);

    @Query("select s from CateEntity s where s.type!=?1 order by s.sequence ")
    List<CateEntity> findAllExpectType(String type);

//    List<VisitCountEntity> findByVisitCountPK
}