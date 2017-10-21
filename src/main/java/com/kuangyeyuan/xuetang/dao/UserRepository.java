package com.kuangyeyuan.xuetang.dao;

import com.kuangyeyuan.xuetang.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Darkal on 2016/6/20.
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

//    List<VisitCountEntity> findByVisitCountPK

    @Query("select s from UserEntity s where s.openid=?1")
    UserEntity findByOpenid(String openid);

}